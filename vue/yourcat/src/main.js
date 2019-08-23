// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import iView from 'iview';
import axios from 'axios'
import VueAxios from 'vue-axios'
import 'iview/dist/styles/iview.css';

var vueInstance;

/*axios全局配置*/
axios.defaults.baseURL = process.env.server;
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.withCredentials = true
// 添加请求拦截器
axios.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  console.log(config)
  return config;
}, function (error) {
  // 对请求错误做些什么
  vueInstance.$Notice.warning({
      title: '请求错误,请稍后重试!',
      desc: ''
  });
  return Promise.reject(error);
});

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    var data = response.data;
    console.log(data)
    console.log("00000000000")
    if(data instanceof Object){
      console.log("222")
      if(data.status!=200){ //自定义异常
          vueInstance.$Notice.warning({
            title: data.data
          });
          return Promise.reject();
      }else if(data.status == 200){//放行
        return response;
      }
    }else{
      console.log("to here 1111")
      gvue.$router.push("/");
    }
}, function (error) {
  // 对响应错误做点什么
  vueInstance.$Notice.warning({
      title: '服务错误,请稍后重试!',
      desc: ''
  });
  return Promise.reject(error);
});

Vue.config.productionTip = false
Vue.use(VueAxios, axios)
Vue.use(iView);

/* eslint-disable no-new */
vueInstance = new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})




