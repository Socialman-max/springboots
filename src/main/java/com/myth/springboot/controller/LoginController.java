package com.myth.springboot.controller;

import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.User;
import com.myth.springboot.service.LoginService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.ibatis.annotations.Mapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "login";
    }
    @RequestMapping("/loginIn")
    public ModelAndView login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv;
        User u = loginService.login(username);
        System.out.println(BCrypt.checkpw(password,u.getU_password()));

        System.out.println(u.getType_id());
        try {
            if (u != null){
                if (BCrypt.checkpw(password,u.getU_password())){
                    if (u.getType_id().equals("1")){
                        System.out.println("进入1");
                        mv = new ModelAndView("index");
                        HttpSession session = request.getSession();
                        session.setAttribute("user",u.getU_name());
                        session.setAttribute("u_id",u.getU_id());
                        session.setMaxInactiveInterval(300);
                        mv.addObject("user",u);
                    }
                    else if (u.getType_id().equals("2")){
                        System.out.println("进入2");
                        mv = new ModelAndView("teacher");
                        HttpSession session = request.getSession();
                        session.setAttribute("user",u.getU_name());
                        session.setAttribute("u_id",u.getU_id());
                        mv.addObject("user",u);
                    }
                    else if (u.getType_id().equals("3")){
                        System.out.println("进入3");
                        mv = new ModelAndView("student");
                        HttpSession session = request.getSession();
                        session.setAttribute("user",u.getU_name());
                        session.setAttribute("u_id",u.getU_id());
                        mv.addObject("user",u);
                    }else {
                        mv = new ModelAndView("login");
                    }
                }else {
                    mv = new ModelAndView("login");
                }
            }else {
                mv = new ModelAndView("login");
            }
        }catch (Exception e){
            System.out.println("出现错误");
            mv = new ModelAndView("login");
        }


        return mv;
    }
    @RequestMapping("/updatePassword")
    @ResponseBody
    public Msg updatePassword(@PathParam("password") String password, @PathParam("u_password") String u_password,HttpServletRequest request){
        String name=request.getSession().getAttribute("user").toString();
        System.out.println(password);
        System.out.println(u_password);
        if(password.equals(u_password)) {
            String newPassword = BCrypt.hashpw(u_password, BCrypt.gensalt());
            int i = loginService.updatePassword(newPassword, name);
            if (i > 0) {
                return Msg.success().add("msg", "修改密码成功");
            } else {
                return Msg.success().add("mag", "修改密码失败");
            }
        }else {
            return Msg.success().add("msg","两次密码不一致");
        }
    }
}
