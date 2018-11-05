参考Spring Cloud官方配置方式
@EnableConfigServer

1、配置方式配置方式
a.基于文件系统的配置
b.基于git版本控制

2、理解${user.dir},也就是工程目录。 G:\workspace\spring-boot-learning

3、Cannot clone or checkout repository: G:\workspace\spring-boot-learning/spring-cloud-learning-config-server/configs
当出现上的问题是因为本地git仓库没有正确创建。

4、当修改完配置文件，不用重启服务，只需提交git，配置即可生效。

5、基于git版本控制
a.git clone
b.创建配置文件
c.提交到git服务端

6、客户端配置 查看spring-cloud-learning-config-client工程

7、动态配置Bean

8、通过Postman动态修改属性

9（主要）、修改了服务端的配置，客户端不能及时获取到服务端的最新配置，怎么办？
客户端通过短点refresh去刷新一下。

10、动态刷新配置信息
RefreshEndpoint#refresh()

11、每一个endpoint都有一个XxxEndpoint.java类，可以通过看源码了解是原理。

12、自行整合spring-cloud-config-monitor




