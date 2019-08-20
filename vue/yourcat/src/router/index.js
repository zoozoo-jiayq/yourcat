import Vue from 'vue'
import Router from 'vue-router'
import Login from "@/components/login"
import Main from "@/components/main"
import Index from "@/components/index"
import option1 from "@/components/option1"
import option2 from "@/components/option2"

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path:"/main",
      name:"main",
      component:Main,
      children:[
        {
          path:"",
          component:Index
        },{
          path:"option1",
          component:option1
        },{
          path:"option2",
          component:option2
        }
      ]
    }
    
  ]
})
