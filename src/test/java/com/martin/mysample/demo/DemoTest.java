package com.martin.mysample.demo;

import com.martin.mysample.demo.model.Animal;
import com.martin.mysample.demo.model.Dog;
import com.martin.mysample.demo.model.PuppyDog;
import com.martin.mysample.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * DemoTest
 *
 * @author Martin
 * @since 2023-10-09 17:17
 **/

@Slf4j
public class DemoTest {

    @Test
    public void testUnboxing() {
//        Integer i = null;
//        boolean flag = false;
//        System.out.println(flag ? new Integer(0) : i);
        Object result = new Integer(5) * new Integer(7);
        System.out.println(result.getClass());
    }

//    @Test
//    public void testExtends() {
//        Animal dog = new Dog();
//        dog.bark();
//        System.out.println("stop");
//        Animal puppyDog = new PuppyDog();
//        puppyDog.bark();
//    }

    @Test
    public void testImpl() {
        UserServiceImpl userService = new UserServiceImpl();
//        testBoxing();
        System.out.println("UserServiceImpl.str = " + UserServiceImpl.str);
    }

    @Test
    public void testString() {
//        char[] charArray = {};
//        char charArray1[] = new char[5];
//        String str = Arrays.toString(charArray);
        StringBuilder stringBuilder = new StringBuilder("aaa");
        String NULL = null;
        stringBuilder.append(NULL);
    }

    @Test
    public void testJoin() {
        long t1 = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("stringbuilder");
        String string = "string";
        //这里是初始字符串定义
        for (int i = 0; i < 50000; i++) {
            //这里是字符串拼接代码
            stringBuilder.append(i);
            StringUtils.join(string, i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("cost:" + (t2 - t1));
    }

    @Test
    public void testStringSwitch() {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }
    }

    @Test
    public void testOptional() {
        Optional optional = Optional.ofNullable(null);
    }

    //测试 修改值类型
    public int f() {
        int ret = 0;
        try {
            return ret;
        } finally {
            // 返回 0，finally 内的修改效果不起作用
            ret++;
            System.out.println("finally 执行:" + ret);
        }

    }

    // 测试 修改引用类型
    public int[] f2() {

        int[] ret = new int[]{0};
        try {
            return ret; // 返回 [1]，finally 内的修改效果起了作用
        } finally {
            ret[0]++;
            System.out.println("finally 执行:" + ret[0]);
        }
    }

    @Test
    public void testFinally() {
        System.out.println("f() = " + f());
        System.out.println("f2() = " + f2()[0]);
    }

    public void testBoxing() {
        Integer inte = 10;  //装箱
        int n = inte;   //拆箱

        boolean flag = true;
        Integer i = null;
        int j = 1;
        System.out.println(flag ? i : j);

        Map<String, Boolean> map = new HashMap<String, Boolean>();
        Boolean b = (map != null ? map.get("test") : false);
    }

    @Test
    public void testGenerics() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "martin");
        map.put("age", "24");
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
    }

    @Test
    public void testExtends() {
        List<Dog> list = new ArrayList<>();
        Dog dog = new Dog();
        Dog puppyDog = new PuppyDog();
        list.add(dog);
        list.add(puppyDog);

        Dog dog1 = list.get(0);
    }

    @Test
    public void testSuper() {
        List<? super Dog> list = new ArrayList<>();
        Dog dog = new Dog();
        Animal animal = new Animal();
        list.add(dog);
//        list.add(animal);

        Object object = list.get(0);
        System.out.println(object.getClass());
    }

    @Test
    public void testList(){
        List<String> list =new ArrayList<>();
        String[] array = list.toArray(new String[0]);
//        String[] strings = new String[]{"ss"};
        List<Character> list1 = Arrays.asList(new Character[]{'s','b'});

    }

    @Test
    public void testShort(){
        short s1 = 1;
        s1 += 1;
        System.out.println("s1 = " + s1);

    }

}
