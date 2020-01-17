## rabbitMQ

### 配置
  * 启动rabbitMQ  rabbitmq-server -detached
  * 添加root用户  rabbitmqctl add_user root root
  * 给用户root授权 rabbitmqctl set_permissions -p / root ".*" ".*" ".*"
  * 设置root为管理员角色 rabbitmqctl set_user_tags root administrator
### 平台目录结构说明

 整合springboot博客：https://www.cnblogs.com/linyufeng/p/9885645.html