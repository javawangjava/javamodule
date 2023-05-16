package com.wang.json;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
    public static void main(String[] args) {
    //1.将Java对象转换为JSON字符串
        User user=new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("6666");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

    //    2.将JSON字符串转换为Java对象
        String jsonStr="{\"id\":1,\"password\":\"6666\",\"username\":\"zhangsan\"}";
        User user2=JSON.parseObject(jsonStr,User.class);
        System.out.println(user2);

    }
}
