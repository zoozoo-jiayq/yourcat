## 1 springboot初始化项目地址:
	[spring init](https://start.spring.io/)

##2 vue初始化
	npm install vue-cli -g
	vue init webapck {projectname}

##3 iView
	[View官网](https://www.iviewui.com/docs/guide/install)

##4 spring-security配置

####1 passwordEncoder
	PasswordEncoder bc = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	使用该加密器加密，不用配置其它相关参数

####2 userDetailService
	返回的权限必须以ROLE_开头

####3 权限控制
	@EnableGlobalMethodSecurity(securedEnabled = true)
	@Secured("ROLE_ADMIN")

##5 服务端集群配置
	负载均衡
	session

##6 消息队列
	
##7 MYSQL分表分库

##8 服务治理

##9 监控/日志

##10 JVM性能监控常用命令
	JPS
	jstat -gcutil pid 1000 1000
	jmap -heap pid

##11 大数量复杂报表的实时统计
