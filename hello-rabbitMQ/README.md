## rabbitMQ

### 配置
  * 启动rabbitMQ  rabbitmq-server -detached
  * 添加root用户  rabbitmqctl add_user root root
  * 给用户root授权 rabbitmqctl set_permissions -p / root ".*" ".*" ".*"
  * 设置root为管理员角色 rabbitmqctl set_user_tags root administrator
### 平台目录结构说明


```
├─paascloud-master----------------------------父项目，公共依赖
│  │
│  ├─paascloud-eureka--------------------------微服务注册中心
│  │
│  ├─paascloud-discovery-----------------------微服务配置中心
│  │
│  ├─paascloud-monitor-------------------------微服务监控中心
│  │
│  ├─paascloud-zipkin--------------------------微服务日志采集中心
│  │
│  ├─paascloud-gateway--------------------------微服务网关中心
│  │
│  ├─paascloud-provider
│  │  │
│  │  ├─paascloud-provider-mdc------------------数据服务中心
│  │  │
│  │  ├─paascloud-provider-omc------------------订单服务中心
│  │  │
│  │  ├─paascloud-provider-opc------------------对接服务中心
│  │  │
│  │  ├─paascloud-provider-tpc------------------任务服务中心
│  │  │
│  │  └─paascloud-provider-uac------------------用户服务中心
│  │
│  ├─paascloud-provider-api
│  │  │
│  │  ├─paascloud-provider-mdc-api------------------数据服务中心API
│  │  │
│  │  ├─paascloud-provider-omc-api------------------订单服务中心API
│  │  │
│  │  ├─paascloud-provider-opc-api------------------对接服务中心API
│  │  │
│  │  ├─paascloud-provider-tpc-api------------------任务服务中心API
│  │  │
│  │  ├─paascloud-provider-sdk-api------------------可靠消息服务API
│  │  │
│  │  └─paascloud-provider-uac-api------------------用户服务中心API
│  │
│  ├─paascloud-common
│  │  │
│  │  ├─paascloud-common-base------------------公共POJO基础包
│  │  │
│  │  ├─paascloud-common-config------------------公共配置包
│  │  │
│  │  ├─paascloud-common-core------------------微服务核心依赖包
│  │  │
│  │  ├─paascloud-common-util------------------公共工具包
│  │  │
│  │  ├─paascloud-common-zk------------------zookeeper配置
│  │  │
│  │  ├─paascloud-security-app------------------公共无状态安全认证
│  │  │
│  │  ├─paascloud-security-core------------------安全服务核心包
│  │  │
│  │  └─paascloud-security-feign------------------基于auth2的feign配置
│  │
│  ├─paascloud-generator
│  │  │
│  │  ├─paascloud-generator-mdc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─paascloud-generator-omc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─paascloud-generator-opc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─paascloud-generator-tpc------------------数据服务中心Mybatis Generator
│  │  │
│  │  └─paascloud-generator-uac------------------数据服务中心Mybatis Generator




```


### 特殊说明


```
这里做一个解释由于微服务的拆分受制于服务器，这里我做了微服务的合并，比如OAuth2的认证服务中心和用户中心合并，
统一的one service服务中心和用户认证中心合并，支付中心和订单中心合并，其实这也是不得已而为之，
只是做了业务微服务中心的合并，并没有将架构中的 注册中心 监控中心 服务发现中心进行合并。
```


### 作者介绍

```
Spring Cloud 爱好者,现就任于鲜易供应链平台研发部.
```

### QQ群交流
 ①：519587831（满）  
 ②：873283104（满）  
 ③：882458726（满）  
 ④：693445268    
 ⑤：813682656    
 ⑥：797334670    
 ⑦：797876073    
 ⑧：814712305    
 ⑨：……    

### FAQ
* [相关问题](https://github.com/paascloud/paascloud-master/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98)

## 配套项目

```
后端项目：https://github.com/paascloud/paascloud-master 
         https://gitee.com/paascloud/paascloud-master
登录入口：https://github.com/paascloud/paascloud-login-web
         https://gitee.com/paascloud/paascloud-login-web
后端入口：https://github.com/paascloud/paascloud-admin-web
         https://gitee.com/paascloud/paascloud-admin-web
前端入口：https://github.com/paascloud/paascloud-mall-web
         https://gitee.com/paascloud/paascloud-mall-web
```

### 传送门
- 博客入口： http://blog.paascloud.net
- 后端入口： http://admin.paascloud.net (支持微信登录体验)
- 模拟商城: http://mall.paascloud.net (支持微信登录体验)
- 文档手册: http://document.paascloud.net
- github: https://github.com/paascloud
- 操作手册: http://blog.paascloud.net/2018/06/10/paascloud/doc/

### 架构图

![项目架构图](http://img.paascloud.net/paascloud/doc/paascloud-project.png)






