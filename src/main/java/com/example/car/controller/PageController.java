package com.example.car.controller;

import com.example.car.model.ExamRecords;
import com.example.car.service.IExamRecordsService;
import com.example.car.service.IStudentService;
import com.example.car.service.IUserService;
import com.example.car.model.Student;
import com.example.car.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    IStudentService studentService;

    @Autowired
    IUserService userService;

    @Autowired
    IExamRecordsService examRecordsService;

    @RequestMapping(path = "/reg" , method = RequestMethod.GET)
    public String reg(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user==null) {
            model.addAttribute("error", "您已退出系统，请重新登陆！");
            return "redirect:/login";
        }
        return "register";
    }

    @RequestMapping(path ="/",method = RequestMethod.GET)
    public String index1(){
        return "login";
    }
    @RequestMapping(path ="/index",method = RequestMethod.GET)
    public String index(){
        return "login";
    }
    @RequestMapping(path ="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(path = "/new",method = RequestMethod.GET)
    public String newStudent(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user==null) {
            model.addAttribute("error", "您已退出系统，请重新登陆！");
            return "redirect:/login";
        }
        return "newStudent";
    }

    @RequestMapping(path = "/add",method = RequestMethod.GET)
    public String add(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user==null) {
            model.addAttribute("error", "您已退出系统，请重新登陆！");
            return "redirect:/login";
        }
        return "addGrade";
    }

    @RequestMapping(path = "/driveBoard",method = RequestMethod.GET)
    public String driveBoard(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user==null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "redirect:/login";
        }else {
            model.addAttribute("user",user);
            return "driveBoard";
        }
    }

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public String list(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user==null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "login";
        }else {
            PageRequest of = PageRequest.of(0, 10);
            Page<Student> studentList = studentService.getStudentList(of);
            model.addAttribute("list", studentList);
            return "studentList";
        }
    }

    @RequestMapping(path="/student",method = RequestMethod.GET)
    public String student(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "login";
        }
        PageRequest of = PageRequest.of(0, 10);
        Page<Student> studentList = studentService.getStudentList(of);
        model.addAttribute("student",studentList);
        return "student";
    }

    @RequestMapping(path="/userList",method = RequestMethod.GET)
    public String userList(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "login";
        }
        List<User> userList = userService.getUserList();
        model.addAttribute("user",userList);
        return "userList";
    }

    @RequestMapping(path = "/change",method = RequestMethod.GET)
    public String change(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "login";
        }
        return "changePassword";
    }

    @RequestMapping(path = "/delete",method = RequestMethod.GET)
    public String delete(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "login";
        }
        return "delete";
    }

    @RequestMapping(path="/students",method = RequestMethod.GET)
    public String students(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "login";
        }
        return "student";
    }

    @RequestMapping(path="/examRecords",method = RequestMethod.GET)
    public String examRecords(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆！");
            return "login";
        }
        PageRequest of = PageRequest.of(0, 10);
        Page<ExamRecords> examRecords = examRecordsService.getExamRecords(of);
        model.addAttribute("examRecords",examRecords);
        return "examRecords";
    }

}
