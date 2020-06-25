<!-- 添加教师 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="姓名">
            <el-input v-model="form.teacherName"></el-input>
          </el-form-item>
      <el-form-item label="学院">
        <el-select v-model="form.institute" placeholder="请选择" class="select3">
          <el-option
            v-for="item in options7"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="form.sex" placeholder="请选择" class="select3">
          <el-option
            v-for="item in options8"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
          <el-form-item label="电话号码">
            <el-input v-model="form.tel"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.pwd"></el-input>
          </el-form-item>
          <el-form-item label="身份证号">
            <el-input v-model="form.cardId"></el-input>
          </el-form-item>
      <el-form-item label="职称">
        <el-select v-model="form.type" placeholder="请选择" class="select3">
          <el-option
            v-for="item in options9"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
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
      options7: [{
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
      options8: [{
        value: '男',
        label: '男'
      }, {
        value: '女',
        label: '女'
      }],
      options9: [{
        value: '教授',
        label: '教授'
      }, {
        value: '副教授',
        label: '副教授'
      }, {
        value: '讲师',
        label: '讲师'
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
        url: '/api/teacher',
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
          this.$router.push({path: '/teacherManage'})
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
}.select3 {
   width: 320px;
 }
</style>

