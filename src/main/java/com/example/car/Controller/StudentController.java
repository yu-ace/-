package com.example.car.Controller;

import com.example.car.Service.IStudentService;
import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class StudentController {

    @Autowired
    IStudentService studentService;

    @RequestMapping(path="/newStudent",method = RequestMethod.POST)
    public String newStudent(
            @RequestParam(name="name")
            String name){
        studentService.newStudent(name);
        return "newStudent";
    }

    @RequestMapping(path="/addGrade",method = RequestMethod.POST)
    public String addGrade(
            @RequestParam(name="id")
            int id,
            @RequestParam(name="n")
            String number,
            @RequestParam(name="grade")
            int grade){
        studentService.addGrade(id,number,grade);
        return "addGrade";
    }

    @RequestMapping(path="/students",method = RequestMethod.POST)
    public String students(
            @RequestParam(name="status")
            String status, Model model){
        List<Student> studentList = studentService.getStudentByPassed(status);
        model.addAttribute("students",studentList);
        return "student";
    }
}
