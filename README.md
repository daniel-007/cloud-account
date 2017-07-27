# 云记账

## 模块划分

- cloud-frontend  : 前端页面
- cloud-handler   : 云记账请求处理服务
- cloud-common    : 公共模块
- cloud-data      : 数据访问模块

## 编译打包

    mvn clean package
    
## 运行

    java -jar cloud-handler/target/cloud-handler.jar
    
## 在线API地址

    http://<部署机器IP>:9000/swagger-ui.html
