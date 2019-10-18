<template>
    <Select @on-change="change" :value="rl">
        <Option value="">--请选择--</Option>
        <Option v-for="r in roles" :value="r.code" :key="r.id">{{r.name}}</Option>
    </Select>
</template>
<script>
import {getRoleList} from "@/api/role.js"
export default {
    props:{
        defaultRole:{
            type:String
        }
    },
    computed:{
        rl:function(){
            return this.defaultRole
        }
    },
    data:function(){
        return {
            roles:[]
        }
    },
    methods:{
        change(val){
            this.$emit("on-change",val)
        }
    },
    mounted(){
        getRoleList().then(res=>{
            this.roles = res.data;
        })
    }
}
</script>