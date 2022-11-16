package com.example.car.Controller;

import com.example.car.Service.IStudentService;
import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    IStudentService studentService;

    @RequestMapping(path = "/reg" , method = RequestMethod.GET)
    public String sha(){
        return "register";
    }

    @RequestMapping(path ="log",method = RequestMethod.GET)
    public String dou(){
        return "login";
    }

    @RequestMapping(path = "new",method = RequestMethod.GET)
    public String ke(){
        return "newStudent";
    }

    @RequestMapping(path = "add",method = RequestMethod.GET)
    public String yi(){
        return "addGrade";
    }

    @RequestMapping(path = "list",method = RequestMethod.GET)
    public String xie(Model model){
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("list",studentList);
        return "studentList";
    }
}
