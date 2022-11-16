package com.example.car.Controller;

import com.example.car.Service.IStudentService;
import com.example.car.Service.IUserService;
import com.example.car.model.Student;
import com.example.car.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    IStudentService studentService;

    @Autowired
    IUserService userService;

    @RequestMapping(path = "/reg" , method = RequestMethod.GET)
    public String sha(){
        return "register";
    }

    @RequestMapping(path ="/log",method = RequestMethod.GET)
    public String dou(){
        return "login";
    }

    @RequestMapping(path = "/new",method = RequestMethod.GET)
    public String ke(){
        return "newStudent";
    }

    @RequestMapping(path = "/add",method = RequestMethod.GET)
    public String yi(){
        return "addGrade";
    }

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public String xie(Model model){
        List<Student> studentList = studentService.getStudentGradeList();
        model.addAttribute("list",studentList);
        return "studentList";
    }

    @RequestMapping(path="/student",method = RequestMethod.GET)
    public String jiu(Model model){
        studentService.changePassed();
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("student",studentList);
        return "student";
    }

    @RequestMapping(path="/userList",method = RequestMethod.GET)
    public String sui(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("user",userList);
        return "userList";
    }

    @RequestMapping(path = "/change",method = RequestMethod.GET)
    public String bin(){
        return "changePassword";
    }

    @RequestMapping(path = "/delete",method = RequestMethod.GET)
    public String la(){
        return "delete";
    }

    @RequestMapping(path="/students",method = RequestMethod.GET)
    public String laa(){
        return "student";
    }
}
