package com.baixin.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * 传给前端的统一JSON对象
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Data
public class Result implements Serializable {

    // 200是正常，非200表示异常
    private int code;
    private String msg;
    private Object data;
    private String action;

    public static Result succ(Object data) {
        return succ(200, "操作成功", data);
    }

    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public Result action(String action){
        this.action = action;
        return this;
    }

}
