<template>
  <div>
  <div style="margin:10px;text-align:right">
      <Input type="text" v-model="searchKey" style="width:200px" icon="md-search"  />
      <Button type="primary" icon="md-search" style="margin:0 10px" @click="search">查询</Button>
      <Button type="info" icon="md-add" @click="userFormFlag=true;">新增</Button>
  </div>
    <Table :data="users" :columns="columndefine" stripe></Table>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right;">
        <Page :total="total" :current="page" @on-change="changePage" :page-size="pageSize" show-sizer @on-page-size-change="pageSizeChange" ></Page>
      </div>
    </div>

    <Modal v-model="userFormFlag" :mask-closable="false" :loading="loading" title="编辑用户信息" @on-ok="ok" @on-cancel="cancel" @on-visible-change="visiableChange">
        <user-form :default-user="targetUser" ref="uf"></user-form>
    </Modal>
  </div>
</template>
<script>
import {getUserList} from "@/api/user"
import userForm  from "_c/user-form/user-form.vue"
export default {
  components:{userForm},
  name: "list",
  data: function() {
    return {
      loading:true,
      targetUser:{state:100},
      userFormFlag:false,
      users: [],
      total:0,
      page:1,
      pageSize:10,
      searchKey:"",
      columndefine: [
        {
          title: "昵称",
          key: "nickName"
        },
        {
          title: "登录名",
          key: "userName"
        },
        {
          title:"联系电话",
          key:"phone"
        },
        {
          title: "角色",
          key: "role",
          render:(h,params)=>{
            return h("span",{},params.row.role=="manager"?"管理员":"员工")
          }
        },
        {
          title: "最后一次登录日期",
          key: "lastVisitTime"
        },
        {
          title: "状态",
          key: "state",
          render:(h,params)=>{
            return h("span",{},params.row.state == 100?"正常":"禁用")
          }
        },
        {
          title: "操作",
          key: "id",
          render: (h, params) => {
            return h("div", [
              h(
                "Button",
                {
                  props: {
                    type: "primary",
                    size: "small"
                  },
                  style: {
                    marginRight: "5px"
                  },
                  on: {
                    click: () => {
                      this.targetUser = params.row;
                      this.userFormFlag = true;
                    }
                  }
                },
                "修改"
              )
            ]);
          }
        }
      ]
    };
  },
  methods: {
    changePage(page) {
      this.page = page;
      this.getUserList()
    },
    getUserList(){
      getUserList({
        searchKey:this.searchKey,
        page:this.page,
        pageSize:this.pageSize
      }).then(res=>{
        var data = res.data;
        this.users = data.content;
        this.total = data.totalElements;
        this.page = data.number+1;
      })
    },
    search(){
      this.getUserList()
    },
    ok(){
      this.$refs.uf.submit().then(res=>{
        console.log(res.data)
        this.userFormFlag = false;
        this.getUserList()
      },err=>{
        this.loading = false;
      })
    },
    cancel(){
      this.userFormFlag = false;
      this.targetUser={state:100};
    },
    visiableChange(visiable){
      if(!visiable){
        this.targetUser = {state:100}
      }
    },
    pageSizeChange(pageSize){
      this.pageSize = pageSize;
      this.getUserList()
    }
  },
  mounted(){
    this.getUserList()
  }
};
</script>
<style scoped>
</style>