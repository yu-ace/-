package com.example.car.controller;

import com.example.car.model.User;
import com.example.car.service.IExamRecordsService;
import com.example.car.service.IStudentService;
import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class StudentController {

    @Autowired
    IStudentService studentService;
    @Autowired
    IExamRecordsService examRecordsService;

    @RequestMapping(path="/newStudent",method = RequestMethod.POST)
    public String newStudent(
            @RequestParam(name="name")
            String name, Model model, HttpSession session){
        User user =(User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        studentService.newStudent(name);
        return "newStudent";
    }

    @RequestMapping(path="/addGrade",method = RequestMethod.POST)
    public String addGrade(
            @RequestParam(name="id")
            int id,
            @RequestParam(name="n")
            int n,
            @RequestParam(name="grade")
            int grade,Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        examRecordsService.addGrade(id,n,grade);
        studentService.addGrade(id,n,grade);
        return "addGrade";
    }

    @RequestMapping(path="/students",method = RequestMethod.POST)
    public String students(
            @RequestParam(name="status")
            String status, Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        List<Student> studentList = studentService.getStudentByStatus(status);
        model.addAttribute("students",studentList);
        return "student";
    }
}
