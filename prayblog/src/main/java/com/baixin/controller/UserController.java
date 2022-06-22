package com.baixin.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baixin.common.lang.vo.UserMessageVo;
import com.baixin.entity.Post;
import com.baixin.entity.UserMessage;
import com.baixin.service.PostService;
import com.baixin.service.UserMessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baixin.common.lang.Result;
import com.baixin.common.lang.vo.UserInfo;
import com.baixin.entity.User;
import com.baixin.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户前端控制器
 *
 * @author: baixin
 * @date: 2022/6/11
 */


@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        return userService.getById(id);
    }
    /**
     * 分页查询用户
     */
    @RequiresRoles("role_root")
    @RequiresAuthentication
    @RequiresPermissions("user:read")
    @GetMapping("/list")
    public Result userList(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<UserInfo> list = userService.getUserInfoList();
        int size = list.size();
        Page page = new Page(currentPage,pageSize);
        if (pageSize > size) {
            pageSize = size;
        }
        // 求出最大页数，防止currentPage越界
        int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
        if (currentPage > maxPage) {
            currentPage = maxPage;
        }
        // 当前页第一条数据的下标
        int curIdx = currentPage > 1 ? (currentPage - 1) * pageSize : 0;
        List pageList = new ArrayList();
        // 将当前页的数据放进pageList
        for (int i = 0; i < pageSize && curIdx + i < size; i++) {
            pageList.add(list.get(curIdx + i));
        }
        page.setTotal(list.size()).setRecords(pageList);
        return Result.succ(page);
    }

    /**
     * 创建用户
     */
    @RequiresRoles("role_root")
    @RequiresPermissions("user:create")
    @RequiresAuthentication
    @PostMapping("/create")
    public Result createUser(@Validated @RequestBody User user){
        if(user==null){
            return Result.fail("不能为空");
        }
        else{
            if(user.getRole().contains("role_root")){
                return Result.fail("禁止设置root用户");
            }
            user.setUpdateTime(LocalDateTime.now());
            user.setCreateTime(LocalDateTime.now());
            user.setPassword(SecureUtil.md5(user.getPassword()));
            userService.saveOrUpdate(user);
        }
        return Result.succ(null);
    }


    /**
     * 修改用户信息
     */
    @RequiresRoles("role_root")
    @RequiresPermissions("user:update")
    @RequiresAuthentication
    @PostMapping("/update")
    public Result updateUser(@Validated @RequestBody User user){
        if(user==null){
            return Result.fail("不能为空");
        }
        else{
            user.setUpdateTime(LocalDateTime.now());
            User subUser = userService.getById(user.getId());
            if(subUser.getRole().equals("role_root")){
                return Result.fail("禁止修改此用户");
            }
            //未修改密码
            if(user.getPassword().equals("")){
                user.setPassword(subUser.getPassword());
            }
            else{
                //存储在数据中的密码为md5加密后的
                user.setPassword(SecureUtil.md5(user.getPassword()));
            }
            userService.saveOrUpdate(user);
        }
        return Result.succ(null);
    }

    /**
     * 删除用户
     */
    @RequiresRoles("role_root")
    @RequiresPermissions("user:delete")
    @RequiresAuthentication
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable(name = "id") Long id) {
        User user = userService.getById(id);
        if(user.getRole().equals("role_root")){
            return Result.fail("禁止删除此用户");
        }
        if (userService.removeById(id)) {
            return Result.succ(null);
        } else {
            return Result.fail("删除失败");
        }

    }

    /**
     * 修改用户的状态
     */
    @RequiresRoles("role_root")
    @RequiresPermissions("user:update")
    @RequestMapping("/publish/{id}")
    public Result publish(@PathVariable(name = "id")Long id){
        User user = userService.getById(id);
        if(user.getRole().equals("role_root")){
            return Result.fail("禁止禁用此用户");
        }
        if (user.getStatus()==0)
        {
            user.setStatus(1);
        }
        else {
            user.setStatus(0);
        }
        userService.saveOrUpdate(user);
        return Result.succ(null);
    }

    /**
    *
     *
     * 新增
    *
    */
    @ResponseBody
    @GetMapping("/user/collection")
    public Result collection() {
        IPage page = postService.page(getPage(), new QueryWrapper<Post>()
                .inSql("id", "SELECT post_id FROM user_collection where user_id = " + getProfileId())
        );
        return Result.succ(page);
    }
    @GetMapping("/user/mess")
    public String mess() {

        IPage<UserMessageVo> page = messageService.paging(getPage(), new QueryWrapper<UserMessage>()
                .eq("to_user_id", getProfileId())
                .orderByDesc("created")
        );

        // 把消息改成已读状态
        List<Long> ids = new ArrayList<>();
        for(UserMessageVo messageVo : page.getRecords()) {
            if(messageVo.getStatus() == 0) {
                ids.add(messageVo.getId());
            }
        }
        // 批量修改成已读
        messageService.updateToReaded(ids);

        req.setAttribute("pageData", page);
        return "/user/mess";
    }

    @ResponseBody
    @PostMapping("/msg/remove/")
    public Result msgRemove(Long id,
                            @RequestParam(defaultValue = "false") Boolean all) {

        boolean remove = messageService.remove(new QueryWrapper<UserMessage>()
                .eq("to_user_id", getProfileId())
                .eq(!all, "id", id));

        return remove ? Result.succ(null) : Result.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/message/nums/")
    public Map msgNums() {

        int count = messageService.count(new QueryWrapper<UserMessage>()
                .eq("to_user_id", getProfileId())
                .eq("status", "0")
        );
        return MapUtil.builder("status", 0)
                .put("count", count).build();
    }
}
