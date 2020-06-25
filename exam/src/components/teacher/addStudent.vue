<!-- 添加学生 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="姓名">
        <el-input v-model="form.studentName"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="form.sex" placeholder="请选择" class="select2">
          <el-option
            v-for="item in options10"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="学院">
        <el-select v-model="form.institute" placeholder="请选择" class="select2">
          <el-option
            v-for="item in options4"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属专业">
        <el-select v-model="form.major" placeholder="请选择" class="select2">
          <el-option
            v-for="item in options5"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属年级">
        <el-select v-model="form.grade" placeholder="请选择" class="select2">
          <el-option
            v-for="item in options6"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="班级">
        <el-input v-model="form.clazz"></el-input>
      </el-form-item>
      <el-form-item label="电话号码">
        <el-input v-model="form.tel"></el-input>
      </el-form-item>
      <el-form-item label="身份证号">
        <el-input v-model="form.cardId"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.pwd"></el-input>
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
      options10: [{
        value: '男',
        label: '男'
      }, {
        value: '女',
        label: '女'
      }],
      options4: [{
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
      options5: [{
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
      options6: [{
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
        studentName: null,
        grade: null,
        major: null,
        clazz: null,
        institute: null,
        tel: null,
        email: null,
        pwd: null,
        cardId: null,
        sex: null,
        role: 2
      }
    };
  },
  methods: {
    onSubmit() { //数据提交
      this.$axios({
        url: '/api/student',
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
          this.$router.push({path: '/studentManage'})
        }
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
}.select2 {
   width: 320px;
 }
</style>

