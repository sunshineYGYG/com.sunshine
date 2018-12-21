package com.sunshine.shine.controller;

import com.sunshine.shine.dao.UserMapper;
import com.sunshine.shine.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(names = {"user"},types = Integer.class)
public class SessionController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/test/testSession")
    public String testSession(HttpSession session, Model model){
        Object id = session.getAttribute("id");
        if (id == null){
            id=2;
        }
        User user = userMapper.selectOneUser(Integer.parseInt(id+""));
        model.addAttribute("id_new",id);
        model.addAttribute("user",user);
        return "sessionTest";
    }
}
