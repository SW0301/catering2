package ru.catering.service;

import ru.catering.model.Grade;
import ru.catering.repository.GradeRepository;

public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Long createGrade(Grade gradeFromAdmin){
        Grade grade = new Grade();
        grade.setName(gradeFromAdmin.getName());
        grade.setDeleted(false);
        gradeRepository.save(grade);
        return grade.getId();
    }

    public Grade getGrade(Long id){
        return gradeRepository.getById(id);
    }

    public void deleteGrade(Long id){
        Grade grade = gradeRepository.getById(id);
        grade.setDeleted(true);
        gradeRepository.save(grade);
    }
}
