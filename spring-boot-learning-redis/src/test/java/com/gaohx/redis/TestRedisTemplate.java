package com.gaohx.redis;

import com.gaohx.redis.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
        ValueOperations vo = redisTemplate.opsForValue();
        vo.set("aaa", "222");
        Assert.assertEquals("222", vo.get("aaa"));
    }

    @Test
    public void testUser() {
        User user = new User("张三", "20");
        ValueOperations<String, User> vo = redisTemplate.opsForValue();
        vo.set("myuser", user);
        User u = vo.get("myuser");
        System.out.println(u.toString());
    }

    @Test
    public void testExpire() throws InterruptedException {
        ValueOperations vos = redisTemplate.opsForValue();
        vos.set("ccc", "333", 100, TimeUnit.MILLISECONDS);
        Thread.sleep(1000);
        System.out.println(redisTemplate.hasKey("ccc"));
    }

    @Test
    public void deleteKey() {
        ValueOperations vos = redisTemplate.opsForValue();
        vos.set("ccc", "ccc");
        System.out.println(vos.get("ccc"));
        redisTemplate.delete("ccc");
        System.out.println(vos.get("ccc"));
    }

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hos = redisTemplate.opsForHash();
        hos.put("myhash","name","张三");
        hos.put("myhash","age","30");

        System.out.println(hos.get("myhash","name"));
        System.out.println(hos.get("myhash","age"));
    }

    @Test
    public void testList(){
        ListOperations<String,String> los = redisTemplate.opsForList();
        redisTemplate.delete("mylist");
        los.leftPush("mylist","aaa");
        los.leftPush("mylist","bbb");
        los.leftPush("mylist","ccc");

        String regex = "^list$";
        redisTemplate.keys("mylist").forEach(System.out::println);
    }

    public static void main(String[] args) {
        String regex = ".list$";
        System.out.println("1list".matches(regex));
    }
}
