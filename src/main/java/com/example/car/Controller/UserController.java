package com.example.car.Controller;

import com.example.car.Service.IUserService;
import com.example.car.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(path = "register",method = RequestMethod.POST)
    public String register(
            @RequestParam(name="name")
            String name,
            @RequestParam(name="password")
            String password){
        userService.register(name,password);
        return "login";
    }

    @RequestMapping(path = "login",method = RequestMethod.POST)
    public String login(
            @RequestParam(name="name")
            String name,
            @RequestParam(name="password")
            String password, Model model){
        User user = userService.getUser(name);
        if(user == null){
            model.addAttribute("error","该用户不存在！");
            return "login";
        }
        if(user.getPassword().equals(password)){
            model.addAttribute("user",user);
            return "driveBoard";
        }else{
            model.addAttribute("error","密码错误！");
            return "login";
        }
    }
}
