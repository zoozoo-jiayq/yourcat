## 1,springboot初始化项目地址:
	[spring init](https://start.spring.io/)

## 2,vue初始化
	npm install vue-cli -g
	vue init webapck {projectname}

## 3,iView
	[View官网](https://www.iviewui.com/docs/guide/install)

## 4,spring-security配置

#### 1,passwordEncoder
	PasswordEncoder bc = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	使用该加密器加密，不用配置其它相关参数

#### 2,userDetailService
	返回的userDetails实现中的权限集合权限必须以ROLE_开头，在@Secured注解中的配置才能生效

#### 3,方法权限控制
	//全局配置
	@EnableGlobalMethodSecurity(securedEnabled = true)
	//具体方法配置
	@Secured("ROLE_ADMIN")
	public Object xxxx(){
		....
	}

## 5,服务端集群配置
	负载均衡
	session
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-redis</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.session</groupId>
		<artifactId>spring-session-data-redis</artifactId>
	</dependency>

## 6,消息队列
	
## 7,MYSQL分表分库

## 8,服务治理

## 9,监控/日志

## 10,JVM性能监控常用命令
	JPS
	jstat -gcutil pid 1000 1000
	jmap -heap pid

## 11,大数量复杂报表的实时统计

## 12,统一异常处理

	已经
### 12.1 前后台交互数据协议
	{status:200/500/...,data:""}

### 12.2 后台处理
	后台通过封装baseController基类，在基类中定义以下方法实现:
	@ExceptionHandler
	@ResponseBody
	public Object exception(Exception e) {
		log.error(e.getMessage());
		return ERROR(e.getMessage());
	}
	//正常业务返回调用该方法
	protected Object SUCCESS(Object data) {
		Map<String,Object> result = new HashMap<>();
		result.put("status", HttpServletResponse.SC_OK);
		result.put("data",data);
		return result;
	}
	//异常业务返回调用该方法
	protected Object ERROR(Object data) {
		Map<String,Object> result = new HashMap<>();
		result.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		result.put("data", data);
		return result;
	}

### 12.3 前台处理
	前台异常处理，通过定义axios的拦截器来实现
