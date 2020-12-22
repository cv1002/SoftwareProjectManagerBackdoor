# 这是本项目的帮助文档
## 本项目的分工安排
> 本项目使用了MVC设计模式，其中M、V、C三个模块以及测试的分工如下：
- M - Mybatis 2同学
- V - 前端 3个同学
- C - SpringBoot的RestController 2同学
- 测试 - 2同学
## 我们需要建造很多POJO类
> 因为Java里面所有的数据都必须对应一个类，前后端的通信依赖于JSON格式
> 而对象最好是一个对象对应一个JSON，否则，代码非常不好写。
> 所以我们需要构造许多POJO类
- POJO类是plain ordinary Java object的意思，其实就是纯数据类
- 相当于C写一个struct
>即bean下的数据库对象
##数据库连接改成自己的（调试用）
- 连接信息在springboot配置文件application.yml中
- 之后肯定是要连统一的数据库的
##一些配置信息
- Oracle openjdk11 GA，应该是自动配，不行的话从http://jdk.java.net/archive/
- File-project structure修改项目jdk
##编写帮助
- bean下类即对应数据库对象，类属性对应字段名
- 一个bean类对应一个mapper
- 注意命名规范
- 目录结构参考分层思想，mapper等于数据操作层，bean即数据对象层，service即业务层，controller即与前端的交互层
- 每个mapper中的方法都只需要定义接口，每个mapper对应resources.mapping下的一个mapping.xml配置文件
- 配置文件头固定，namespace对应目标mapper类，其中多个select，每个select对应mapper下一个方法接口，id即接口名，resultType即对应的数据类
- select下直接写sql语句，参数参考示例，#{arg0}代表方法入参的第一个参数
- controller下有一些注释
- 运行入口是core包下的 项目名Application主方法