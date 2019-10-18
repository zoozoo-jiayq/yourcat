<template>
    <RadioGroup @on-change="change" v-model="state">
        <Radio :label="100">正常</Radio>
        <Radio :label="200">禁用</Radio>
    </RadioGroup>
</template>
<script>
export default {
    props:{
        defaultState:{
        }
    },
    data:function(){
        return {
            states:[{
                code:"100",
                name:"正常"
            },{
                code:"200",
                name:"禁用"
            }]
        }
    },
    computed:{
        state:{
            get:function(){
                return this.defaultState
            },
            set:function(v){
                
            }
        }
    },
    methods:{
        change(val){
            this.$emit("on-change",val)
        }
    }
}
</script>