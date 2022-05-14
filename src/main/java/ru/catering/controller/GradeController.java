package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Grade;
import ru.catering.service.GradeService;


@RestController
public class GradeController {
    private GradeService gradeService;

    @Autowired
    public void setGradeService(GradeService gradeService){
        this.gradeService = gradeService;
    }

    @PostMapping(value = "/grade/create")
    public void createGrade(@RequestBody Grade gradeFromAdmin){
        gradeService.createGrade(gradeFromAdmin);
    }

    @GetMapping(value = "/grade/get")
    public Grade getGradeById(@RequestParam Long id){return gradeService.getGrade(id);}
}
