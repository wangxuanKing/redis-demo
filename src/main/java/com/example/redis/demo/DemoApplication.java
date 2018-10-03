package com.example.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        RedisUtil redisUtil = (RedisUtil) SpringContextUtils.getBeanById("redisUtil");
        redisUtil.set("name","Mr Wang ");
        System.out.printf("姓名："+redisUtil.get("name"));
        User user = new User("程丫丫","上海");
        redisUtil.set("user-test",user);
        User u = (User) redisUtil.get("user-test");
        System.out.printf("user-test:"+u.toString());
    }



    static class User{
        String name;
        String address;

        public User() {
        }

        public User(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
