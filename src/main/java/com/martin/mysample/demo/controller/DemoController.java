package com.martin.mysample.demo.controller;

import com.martin.mysample.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DemoController
 *
 * @author Martin
 * @since 2023-10-24 20:58
 **/

@Controller
@RequestMapping
public class DemoController {

    @Autowired
    private User user;

    @GetMapping("/getUser")
    public User getUser1() {
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        return "GET-马丁";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser() {
        return "POST-马丁";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "PUT-马丁";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-马丁";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") String id) {
        System.out.println("id = " + id);
        return null;
    }

    @GetMapping("/user/{id}/{username}")
    public Map<String, String> getUserByMap(@PathVariable("id") Integer id,
                                            @PathVariable String username,
                                            @PathVariable Map<String, String> map,
                                            @RequestParam()
                                            @Param("") String name) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);
        System.out.println("map = " + map);
        return null;
    }


    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {

        request.setAttribute("msg", "成功了...");
        request.setAttribute("code", 200);

        // 通过forward:将该请求转发到 "/success"
        return "forward:/success1";
    }

    @ResponseBody
    @GetMapping("/success1")
    public Map success1(@RequestAttribute("msg") String msg,
                        @RequestAttribute("code") Integer code, @CookieValue
                        HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();
        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);
        return map;
    }

    @GetMapping("/user/{id}/name/{username}")
    public Map<String, Object> getUser1(@PathVariable("id") Integer id,
                                        @PathVariable("username") String name,
                                        @PathVariable Map<String, String> pv,
                                        @RequestHeader("User-Agent") String userAgent,
                                        @RequestHeader Map<String, String> header,
                                        @RequestParam("age") Integer age,
                                        @RequestParam("inters") List<String> inters,
                                        @RequestParam Map<String, String> params,
                                        @CookieValue("_ga") String _ga,
                                        @CookieValue("_ga") Cookie cookie
    ) {


        Map<String, Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("_ga", _ga);
        System.out.println(cookie.getName() + "===>" + cookie.getValue());
        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        map.put("hello", "hello111");
        model.addAttribute("world", "world222");
        request.setAttribute("message", "Helloworld333");

        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);

        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute(value = "msg", required = false) String msg,
                                       @RequestAttribute(value = "code", required = false) Integer code,
                                       HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");
        map.put("reaMethod msg", msg1);
        map.put("hello", hello);
        map.put("world msg", world);
        map.put("message", message);

        return map;
    }

}
