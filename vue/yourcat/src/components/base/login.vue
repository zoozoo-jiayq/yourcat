<template>
<Card class="form" >
    <h4 slot="title">登录</h4>
        <form >
            <Row class="row">
                <Col span="8"><span class="text">用户名：</span></Col><Col span="16"><Input v-model="login.username" size="large"  placeholder="请输入用户名"/></Col>
            </Row>
            <Row class="row">
                <Col span="8"><span class="text">密码：</span></Col><Col span="16"><Input type="password" v-model="login.password" size="large"  placeholder="请输入密码"/></Col>
            </Row>
            <Row class="row">
                <Button type="primary" long size="large" @click="dologin">登录</Button>
            </Row>
        </form>
</Card>
</template>
<script>
const qs = require('qs');
export default {
    data(){
        return {
            login:{}
        }
    },
    methods:{
        dologin(){
            console.log(this)
            this.axios.post("/login",qs.stringify(this.login),{
                headers:{
                    "Content-Type":"application/x-www-form-urlencoded"
                }
            }).then(res=>{
                this.$router.push("/main");
            })
        }
    }
}
</script>
<style scoped>
    .form{
        position: absolute;
        top:30%;
        left:50%;
        transform: translate(-50%,-50%);
        width:400px;
    }
    .row{
        margin:20px 0
    }
    .text{
        line-height: 36px;
    }
</style>