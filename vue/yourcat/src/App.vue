<template>
  <div id="app">
    <H1>hello</H1>
    <router-view />
  </div>
</template>

<script>
var config = require("./config.js");
console.log(config.server)
console.log(process.env.server)
console.log(process.env.a)
export default {
  name: 'App'
}
</script>

<style>
#app {
  /* font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px; */
}
</style>
