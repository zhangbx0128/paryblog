<template>
  <div class="card">
    <!--展示名片头部--头像名称-->
    <div class="card-header">
      <el-avatar :size="50" :src="user.avatar"></el-avatar>
      <p style="margin-top: 0px;">Pray</p>
      <el-divider></el-divider>
    </div>
<!--    <div class="content" align="center">-->
<!--      <div class="header">{{ introduction.name }}</div>-->
<!--      &lt;!&ndash;彩色滚动字体&ndash;&gt;-->
<!--      <div id="rollText" class="m-margin-top" v-if="introduction.rollText.length!=0"></div>-->
<!--    </div>-->
    <!--卡片中部--github地址-->
    <div class="card-middle">
      <div style="max-width: 180px;margin-left: 40px">
        <el-image :fit="fit"
                  src="https://cdn.jsdelivr.net/gh/zhangbx0128/picture@main/github‘.png"
                  style="cursor:pointer;width: 55px; height: 55px" @click="goToGithub"></el-image>
        <el-image :fit="fit"
                  src="https://cdn.jsdelivr.net/gh/zhangbx0128/picture@main/bilibili.png"
                  style="cursor:pointer;width: 55px; height: 55px" @click="goTobilibili"></el-image>
        <el-image :fit="fit"
                  src="https://cdn.jsdelivr.net/gh/zhangbx0128/picture@main/music163.jpeg"
                  style="cursor:pointer;width: 55px; height: 55px" @click="goTomusic163"></el-image></div>
    </div>
    <!--卡片底部--个人喜好-->
    <div class="card-footer">
      <el-collapse>
        <el-collapse-item name="1" style="padding-left: 20px;padding-right: 20px" title="最喜欢的游戏">
          <div>life</div>
        </el-collapse-item>
        <el-collapse-item name="2" style="padding-left: 20px;padding-right: 20px" title="最喜欢的颜色">
          <div>紫色</div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>

<script>
export default {
  name: "Card",
  data() {
    return {
      hasLogin: false,
      fit: 'fill',
      user: {
        avatar: "https://cdn.jsdelivr.net/gh/zhangbx0128/picture@main/touxiang.JPG"
      },
    }
  },
  methods: {
    //跳转到个人github
    goToGithub() {
      window.location.href = "https://github.com/zhangbx0128"
    },
    goTobilibili(){
      window.location.href = "https://space.bilibili.com/128822192"
    },
    goTomusic163(){
      window.location.href = "https://music.163.com/#/user/home?id=340558360"
    }
  },


  created() {
  }
}
</script>

<style scoped>
.card {
  width: 250px;
  padding: 20px 0px 0px 0px;
  background-color: white;
}
#rollText {
  font-size: 15px;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
}
.card-header {
  text-align: center;
}
.card-footer {
  margin-top: 10px;
}
.card:hover {
  -webkit-box-shadow: #ccc 0px 10px 10px;
  -moz-box-shadow: #ccc 0px 10px 10px;
  box-shadow: #ccc 0px 10px 10px;
}
</style>