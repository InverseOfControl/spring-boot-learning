1.要禁止Spring Secutiry
@SpringBootApplication(exclude=SecurityAutoConfiguration.class)

2.基于内存的认证
启动输入用户名和密码会报如下错误：
java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
这是因为Spring Security 5.0中新增了加密方式

3.基于内存的角色授权
@EnableGlobalMethodSecurity(prePostEnabled = true)
方法上添加：@PreAuthorize("hasAnyRole('ADMIN')")