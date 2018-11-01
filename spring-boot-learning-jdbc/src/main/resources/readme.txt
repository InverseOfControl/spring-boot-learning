JDBC规范：
java.sql.Driver
java.sql.DriverManager
java.sql.Connection
java.sql.Statement
java.sql.ResultSet

DML Datasource Manager Lanaguage  数据库操作语句
DDL Datasource Definition Lanaguage 数据库定义语句

事务：本地事务、分布式事务

脏读、幻读、不可重复读

事务解析：
TransactionInterceptor
当执行事务方法时，接口会变成一个代理对象，例如UserService的代理对象是$Proxy57@5878.
很明显它使用的JDK的动态代理。代理接口。

分布式事务：
bitronix
