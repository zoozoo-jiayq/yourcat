<template>
<span v-if="ctrl">
        <slot></slot>
</span>
</template>
<script>
export default {
    props:{
        menu:{}
    },
    mounted(){
        var userAuths = [];
        if(userAuths.indexOf(menu)>=0){
            this.ctrl = true;
        }else{
            this.ctrl = false;
        }
    }
}
</script>
<style scoped>

</style>