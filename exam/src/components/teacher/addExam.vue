<!-- 添加考试 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="试卷名称">
        <el-input v-model="form.source"></el-input>
      </el-form-item>
      <el-form-item label="介绍">
        <el-input v-model="form.description"></el-input>
      </el-form-item>
      <el-form-item label="所属学院">
        <el-select v-model="form.institute" placeholder="请选择" class="select1">
          <el-option
            v-for="item in options1"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属专业">
        <el-select v-model="form.major" placeholder="请选择" class="select1">
          <el-option
            v-for="item in options2"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属年级">
        <el-select v-model="form.grade" placeholder="请选择" class="select1">
          <el-option
            v-for="item in options3"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="考试日期" >
        <el-col :span="11">
          <el-date-picker  placeholder="选择日期" v-model="form.examDate" style="width: 100%;"></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="持续时间">
        <el-input v-model="form.totalTime"></el-input>
      </el-form-item>
      <el-form-item label="总分">
        <el-input v-model="form.totalScore"></el-input>
      </el-form-item>
      <el-form-item label="考试类型">
        <el-input v-model="form.type"></el-input>
      </el-form-item>
      <el-form-item label="考生提示">
        <el-input type="textarea" v-model="form.tips"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">立即创建</el-button>
        <el-button type="text" @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      options1: [{
        value: '信息工程学院',
        label: '信息工程学院'
      }, {
        value: '金融学院',
        label: '金融学院'
      }, {
        value: '化工学院',
        label: '化工学院'
      }, {
        value: '土木工程建筑学院',
        label: '土木工程建筑学院'
      },],
      value: '',
      options2: [{
        value: '计算机科学与技术',
        label: '计算机科学与技术'
      }, {
        value: '网络工程',
        label: '网络工程'
      }, {
        value: '信息工程',
        label: '信息工程'
      }, {
        value: '金融工程',
        label: '金融工程'
      },{
        value: '保险学',
        label: '保险学'
      },{
        value: '应用化学',
        label: '应用化学'
      },{
        value: '土木工程',
        label: '土木工程'
      }, {
        value: '给排水科学与工程',
        label: '给排水科学与工程'
      }],
      options3: [{
        value: '2016',
        label: '2016'
      }, {
        value: '2017',
        label: '2017'
      }, {
        value: '2018',
        label: '2018'
      }, {
        value: '2019',
        label: '2019'
      }],
      form: { //表单数据初始化
        source: null,
        description: null,
        institute: null,
        major: null,
        grade: null,
        examDate: null,
        totalTime: null,
        totalScore: null,
        type: null,
        tips: null,
        paperId: null,
      }
    };
  },
  methods: {
    formatTime(date) { //日期格式化
      let year = date.getFullYear()
      let month= date.getMonth()+ 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
      let day=date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
      let hours=date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
      let minutes=date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
      let seconds=date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
      // 拼接
      return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    },
    onSubmit() {
      let examDate = this.formatTime(this.form.examDate)
      this.form.examDate = examDate.substr(0,10)
      this.$axios(`/api/examManagePaperId`).then(res => {
        this.form.paperId = res.data.data.paperId + 1 //实现paperId自增1
        this.$axios({
          url: '/api/exam',
          method: 'post',
          data: {
            ...this.form
          }
        }).then(res => {
          if(res.data.code == 200) {
            this.$message({
              message: '数据添加成功',
              type: 'success'
            })
            this.$router.push({path: '/selectExam'})
          }
        })
      })
    },
    cancel() { //取消按钮
      this.form = {}
    },

  }
};
</script>
<style lang="scss" scoped>
.add {
  padding: 0px 40px;
  width: 400px;
}.select1 {
  width: 320px;
}
</style>

