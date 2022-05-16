package ru.catering.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.catering.model.directory.Grade;
import ru.catering.repository.GradeRepository;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Long createGrade(Grade gradeFromAdmin) {
        Grade grade = new Grade();
        grade.setName(gradeFromAdmin.getName());
        grade.setDeleted(false);
        return gradeRepository.save(grade).getId();
    }

    public Grade getGrade(Long id) {
        return gradeRepository.getById(id);
    }

    public void deleteGrade(Long id) {
        Grade grade = gradeRepository.getById(id);
        grade.setDeleted(true);
        gradeRepository.save(grade);
    }
}