package com.gaohx.springbootlearningjdbc.controller;

import com.gaohx.springbootlearningjdbc.domain.City;
import com.gaohx.springbootlearningjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public City user(@PathVariable String id){
        return userService.getUser(id);
    }

    /*@GetMapping("/saveUser")
    public Object saveUser(User user){
        boolean bool = userService.saveUser(user);
        return ResponseEntity.ok(bool);
    }*/

    /*public void getUser(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from dual");
            while(resultSet.next()){
                String string = resultSet.getString("column");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/

    /*public void addUser(User user){
        userService.saveUser(user); // 此处打断点，按F7,进入JdkDynamicAopProxy.java中
        // 在197行对得到一个拦截器 List<Object> chain = ... 这个拦截器就是TransactionInterceptor.java
        //往下看，在212行 retVal = invocation.proceed(); 事务执行完毕。
        //把断点打到TransactionInterceptor.invoke()方法中，可以看详细的执行细节。
        //创建事务之后会把事务绑定到ThreadLocal中。线程安全。

    }*/

}
