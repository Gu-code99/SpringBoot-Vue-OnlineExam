<template>
  <section class="index">
    <div class="hello">
      <i class="iconfont icon-xihuan"></i><span>很高兴遇见你,{{user.userName}}老师。</span>
    </div>
    <div class="msg">
      <p class="title">教务公告：</p>
      <ul>
        <li @click="openMsg1()"><i class="iconfont icon-flag"></i>清明节放假通知</li>
        <li @click="openMsg2()"><i class="iconfont icon-flag"></i>下周例行工作报告会</li>
        <li @click="openMsg3()"><i class="iconfont icon-flag"></i>关于毕业生答辩具体流程</li>
      </ul>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      user: { //用户信息
        userName: null,
        userId: null
      }
    }
  },
  created() {
    this.getUserInfo()
  },
  methods: {
    getUserInfo() { //获取用户信息
      let userName = this.$cookies.get("cname")
      let userId = this.$cookies.get("cid")
      this.user.userName = userName
      this.user.userId = userId
    },
    openMsg1() {
      this.$alert('根据《国务院办公厅关于2020年部分节假日安排的通知》精神，图书馆服务中心将于4月5日（星期五）至4月7日（星期天）进行清明节放假调休，共3天，闭馆期间不提供借阅服务。4月8日（星期一）开始正常开放。望同学们相互转告，给您带来不便，敬请谅解。','清明节放假通知',{
        confirmButtonText: '确定'
      })
    },
    openMsg2() {
      this.$alert('下周五(5月8日)晚上6点将在行政楼一楼会议室举行例会，请各位老师按时参加会议。','下周例行工作报告会',{
        confirmButtonText: '确定'
      })
    },
    openMsg3() {
      this.$alert('根据学院工作安排，2016级毕业生答辩日期定于5月15日，具体地点和要求已下发各位老师及班长，请通知各班同学尽快做好准备。如有变更，将提前通知。请关注公告信息。','关于毕业生答辩具体流程',{
        confirmButtonText: '确定'
      })
    }
  }
}
</script>


<style lang="scss" scoped>
.index {
  margin-left: 70px;
  .hello {
    font-size: 20px;
    color: #726f70;
    .icon-xihuan {
      font-size: 30px;
      color: #dd6572;
    }
  }
  .msg {
    .title {
      font-size: 16px;
      color: #000;
      margin-top: 20px;
      margin-left: 10px;
    }
    ul {
      display: flex;
      flex-direction: column;
      width: 200px;
      overflow: hidden;
    }
    li {
      margin-top: 10px;
      font-size: 14px;
      color: lightcoral;
      cursor: pointer;
      display: inline-block;
    }
  }
}
</style>

