1、Profiles 属性文件
Properties 属性
Environment
ConfigurableEnvironment extends Environment

ConfigFileApplicationListener 加载配置文件的监听器，灰常重要。

2、Bootstrap的配置文件：
加载配置文件必然有一个监听，BootstrapApplicationListener
spring.cloud.bootstrap.enabled 控制bootstrap的配置上下文

2、加载顺序
application.properties和bootstrap.properties的加载顺序
bootstrap先加载，application后加载
原因：
ConfigFileApplicationListener：public static final int DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 10;
BootstrapApplicationListener：public static final int DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 5;
所以配置属性的时候要注意这个规则。

4、自定义Bootstrap配置文件 Customizing the Bootstrap Configuration

5、自定义Bootstrap的属性源 Customizing the Bootstrap Property Sources
通过API的方式加载的属性会覆盖在properties中配置的属性内容

6、日志不要配置application.properties或者bootstrap.properties中，就好是使用默认的配置spring-logback.xml

7、这一节的源码分析的使用场景：可以结合zookeeper或阿波罗实现配置。抛弃SpringCloud的git配置方式。

8、






