<template>
  <el-card class="box-card">
    <div>
      <p>本周热议</p>
    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'  ' + o }}
    </div>
  </el-card>
</template>

<script>
export default {
  name: "HotMessage"
}
</script>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 248px;
}
</style>