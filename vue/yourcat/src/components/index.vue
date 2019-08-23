<template>
        <h1>INDEX</h1>
</template>
<script>
export default {
    methods:{
        
    },
    mounted(){
        console.log(this)
        this.axios.get("/getLoginUserInfo").then(res=>{
                // console.log(res.data)
        })
    }
}
</script>