# 需求分析课程设计 网络销售系统 Emall

## 后台开发工具
> [IntelliJ IDEA](https://www.jetbrains.com/idea/) 

## 整体后台设计
> 1. 后台系统架构：springboot+mybatis+redis
> 2. springboot：后台业务逻辑支持
> 3. mybatis:数据库操作支持
> 4. redis:缓存支持，减小数据库压力

## 后台架构一览

```
.
├── Emall.iml
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── emall
│   │   │           └── spring
│   │   │               ├── Application.java
│   │   │               ├── controller
│   │   │               │   └── IndexController.java
│   │   │               ├── dao
│   │   │               │   ├── AdminMapper.java
│   │   │               │   ├── CustomerMapper.java
│   │   │               │   ├── DistributeMapper.java
│   │   │               │   ├── OrderMapper.java
│   │   │               │   ├── OrderproductMapper.java
│   │   │               │   ├── ProdisMapper.java
│   │   │               │   ├── ProductMapper.java
│   │   │               │   └── RepertoryMapper.java
│   │   │               ├── entity
│   │   │               │   ├── Admin.java
│   │   │               │   ├── Customer.java
│   │   │               │   ├── Distribute.java
│   │   │               │   ├── Order.java
│   │   │               │   ├── Orderproduct.java
│   │   │               │   ├── Prodis.java
│   │   │               │   ├── Product.java
│   │   │               │   └── Repertory.java
│   │   │               ├── services
│   │   │               │   ├── AdminService.java
│   │   │               │   ├── CustomerService.java
│   │   │               │   ├── DistributeService.java
│   │   │               │   ├── OrderService.java
│   │   │               │   ├── OrderproductService.java
│   │   │               │   ├── ProdisService.java
│   │   │               │   ├── Productservice.java
│   │   │               │   └── RepertoryService.java
│   │   │               └── utils
│   │   ├── log
│   │   │   ├── emall.log
│   │   │   └── emall.log.2018-11-22.0.gz
│   │   └── resources
│   │       ├── application.properties
│   │       ├── generator.properties
│   │       ├── generatorConfig.xml
│   │       ├── sql
│   │       │   ├── AdminMapper.xml
│   │       │   ├── CustomerMapper.xml
│   │       │   ├── DistributeMapper.xml
│   │       │   ├── OrderMapper.xml
│   │       │   ├── OrderproductMapper.xml
│   │       │   ├── ProdisMapper.xml
│   │       │   ├── ProductMapper.xml
│   │       │   └── RepertoryMapper.xml
│   │       ├── static
│   │       │   ├── css
│   │       │   ├── html
│   │       │   │   └── test.html
│   │       │   ├── img
│   │       │   │   └── test.jpg
│   │       │   └── js
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── emall
│                   └── spring
│                       └── ApplicationTests.java
└── target
    ├── classes
    │   ├── application.properties
    │   ├── com
    │   │   └── emall
    │   │       └── spring
    │   │           ├── Application.class
    │   │           ├── controller
    │   │           │   └── IndexController.class
    │   │           ├── dao
    │   │           │   ├── AdminMapper.class
    │   │           │   ├── CustomerMapper.class
    │   │           │   ├── DistributeMapper.class
    │   │           │   ├── OrderMapper.class
    │   │           │   ├── OrderproductMapper.class
    │   │           │   ├── ProdisMapper.class
    │   │           │   ├── ProductMapper.class
    │   │           │   └── RepertoryMapper.class
    │   │           ├── entity
    │   │           │   ├── Admin.class
    │   │           │   ├── Customer.class
    │   │           │   ├── Distribute.class
    │   │           │   ├── Order.class
    │   │           │   ├── Orderproduct.class
    │   │           │   ├── Prodis.class
    │   │           │   ├── Product.class
    │   │           │   └── Repertory.class
    │   │           └── services
    │   │               ├── AdminService.class
    │   │               ├── CustomerService.class
    │   │               ├── DistributeService.class
    │   │               ├── OrderService.class
    │   │               ├── OrderproductService.class
    │   │               ├── ProdisService.class
    │   │               ├── Productservice.class
    │   │               └── RepertoryService.class
    │   ├── generator.properties
    │   ├── generatorConfig.xml
    │   ├── sql
    │   │   ├── AdminMapper.xml
    │   │   ├── CustomerMapper.xml
    │   │   ├── DistributeMapper.xml
    │   │   ├── OrderMapper.xml
    │   │   ├── OrderproductMapper.xml
    │   │   ├── ProdisMapper.xml
    │   │   ├── ProductMapper.xml
    │   │   └── RepertoryMapper.xml
    │   └── static
    │       ├── html
    │       │   └── test.html
    │       └── img
    │           └── test.jpg
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    └── test-classes
        └── com
            └── emall
                └── spring
                    └── ApplicationTests.class

```
## 后台API一览

> [api](https://github.com/Mingmingge/Emall/wiki/API总览)

## 开发日志

### 明明哥的日志
`2018.11.22`

> 初始化项目，后台开发开始


