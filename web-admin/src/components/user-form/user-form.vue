<template>
  <Form style="width:80%" ref="userForm" :model="user" :label-width="80" :rules="rules">
    <FormItem label="昵称" prop="nickName">
      <Input v-model="user.nickName" placeholder="请输入用户昵称" />
    </FormItem>
    <FormItem label="联系电话" prop="phone">
      <Input v-model="user.phone" placeholder="请输入联系电话" />
    </FormItem>
    <FormItem label="登录名" prop="userName">
      <Input v-model="user.userName" placeholder="请输入登录名" />
    </FormItem>
    <FormItem label="角色" prop="role">
      <select-role :default-role="user.role" @on-change="changeRole"></select-role>
    </FormItem>
    <FormItem label="状态" prop="state">
      <radio-state @on-change="changeState" :default-state="user.state"></radio-state>
    </FormItem>
  </Form>
</template>
<script>
import { addUser } from "@/api/user";
import selectRole from "_c/select-role/select-role.vue";
import radioState from "_c/radio-state/radio-state.vue";
export default {
  components: {
    selectRole,
    radioState
  },
  props: {
    defaultUser: {}
  },
  computed: {
    user: function() {
      return this.defaultUser;
    }
  },
  data: function() {
    return {
      rules: {
        nickName: [
          {
            required: true,
            message: "昵称不能为空",
            trigger: "blur"
          }
        ],
        phone: [
          {
            required: true,
            message: "联系电话不能为空",
            trigger: "blur"
          }
        ],
        userName: [
          {
            required: true,
            message: "登录名不能为空",
            trigger: "blur"
          }
        ],
        role: [
          {
            required: true,
            message: "角色不能为空",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    submit() {
      return new Promise((resolve,reject)=>{
          this.$refs.userForm.validate(valid=>{
              if(valid){
                  addUser(this.user).then(res=>{
                      resolve(res)
                  })
              }else{
                  reject(valid)
              }
          })
      });
    },
    changeRole(val) {
      this.user.role = val;
    },
    changeState(val) {
      this.user.state = val;
    }
  }
};
</script>
<style scoped>
</style>