package com.example.car.Controller;

import com.example.car.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {

    @Autowired
    IStudentService studentService;

    @RequestMapping(path="/newStudent",method = RequestMethod.POST)
    public String xia(
            @RequestParam(name="name")
            String name){
        studentService.newStudent(name);
        return "newStudent";
    }

    @RequestMapping(path="/addGrade",method = RequestMethod.POST)
    public String xie(
            @RequestParam(name="id")
            int id,
            @RequestParam(name="n")
            String number,
            @RequestParam(name="grade")
            int grade){
        studentService.addGrade(id,number,grade);
        return "addGrade";
    }
}
