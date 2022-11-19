package com.example.car.controller;

import com.example.car.model.ExamRecords;
import com.example.car.model.Student;
import com.example.car.model.User;
import com.example.car.service.IExamRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ExamRecordsController {

    @Autowired
    IExamRecordsService examRecordsService;

    @RequestMapping(path="/examRecord",method = RequestMethod.POST)
    public String examRecords(
            @RequestParam(name="id")
            int id, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","您已退出系统，请重新登陆");
            return "login";
        }
        List<ExamRecords> examRecordsList = examRecordsService.getExamRecordsByStudentId(id);
        model.addAttribute("examRecord",examRecordsList);
        return "examRecords";
    }
}
