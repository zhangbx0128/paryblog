<template>
  <div class="card">
    <p style="margin-top: 0px;">网站公告</p>
    <el-divider></el-divider>
    <p style="margin-top: 0px;">Welcome to Pray's Blog</p>
<!--    <div>-->
<!--      <p style="margin-left: 20px; margin-top:60px;margin-bottom:0px;font-size: 16px;font-family: 宋体;font-weight: bold;">-->
<!--        {{'访客量: '+uv}} </p>-->
<!--      <p style="margin-left: 20px; margin-top:5px;font-size:16px;font-family: 宋体;font-weight: bold;">-->
<!--        {{'总访问量: '+pv}}</p>-->
      <el-col :sm="8" style="margin-top: 0px;">
        <el-row :gutter="24" class="footer-title">
          <el-col :span="24">网站信息</el-col>
        </el-row>
        <el-row :gutter="24" class="footer-content">
          <el-col :span="24">
            {{'总访问量: '+pv}} <br>
            {{'访客量: '+uv}}
          </el-col>
        </el-row>
      </el-col>
<!--    </div>-->
<!--    <div style=" margin-top:60px;">-->
<!--      <p id="showsectime">-->
<!--        无-->
<!--      </p>-->
<!--    </div>-->


  </div>


</template>

<script>
export default {
  name: "RightCard",
  data() {
    return {
      runTime: 0,
      pv: 0,
      uv: 0,
    }
  },
  methods: {
    NewDate(str) {
      str = str.split('-');
      var date = new Date();
      date.setUTCFullYear(str[0], str[1] - 1, str[2]);
      date.setUTCHours(0, 0, 0, 0);
      return date;
    },

    getPVAndUV(){
      const _this = this
      this.$axios.get('/visitornum').then(res => {
        _this.uv = res.data.data.uv
        _this.pv = res.data.data.pv
      })

    },
    getRunTime() {
      //var birthDay = this.NewDate("2021-03-10");
      var birthDay = new Date();
      var today = new Date();
      var timeold = today.getTime() - birthDay.getTime();

      var sectimeold = timeold / 1000
      var secondsold = Math.floor(sectimeold);
      var msPerDay = 24 * 60 * 60 * 1000;

      var e_daysold = timeold / msPerDay;
      var daysold = Math.floor(e_daysold);
      var e_hrsold = (daysold - e_daysold) * -24;
      var hrsold = Math.floor(e_hrsold);
      var e_minsold = (hrsold - e_hrsold) * -60;
      var minsold = Math.floor((hrsold - e_hrsold) * -60);

      var seconds = Math.floor((minsold - e_minsold) * -60).toString();
      document.getElementById("showsectime").innerHTML = "网站已正常运行" + daysold + "天";
    }
  },
  mounted() {
    this.getRunTime();

  },
  watch: {
    '$route':'getPVAndUV'
  },
  created() {
    this.getPVAndUV()
  }
}
</script>

<style scoped>
.card {
  width: 250px;
  height: 300px;
  padding: 20px 0px 0px 0px;
  background-color: white;



  text-align: center;


}
.footer-content {
  font-size: 13px;
}
.card:hover {
  -webkit-box-shadow: #ccc 0px 10px 10px;
  -moz-box-shadow: #ccc 0px 10px 10px;
  box-shadow: #ccc 0px 10px 10px;
}


</style>