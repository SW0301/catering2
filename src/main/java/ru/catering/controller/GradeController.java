package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.directory.Grade;
import ru.catering.service.GradeService;


@RestController
public class GradeController {
    private GradeService gradeService;

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping(value = "/grade")
    public Long createGrade(@RequestBody Grade gradeFromAdmin) {
        return gradeService.createGrade(gradeFromAdmin);
    }

    @GetMapping(value = "/grade/{id}")
    public Grade getGradeById(@PathVariable Long id) {
        return gradeService.getGrade(id);
    }

    @DeleteMapping(value = "/dish/{gradeId}")
    public void deleteGrade(@PathVariable Long gradeId) {
        gradeService.deleteGrade(gradeId);
    }
}