package com.raghu.spring_data_jpa_ex.controller;

import com.raghu.spring_data_jpa_ex.model.Student;
import com.raghu.spring_data_jpa_ex.repository.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepo repo;

    public StudentController(StudentRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> all() {
        return repo.findAll();
    }

    @PostMapping
    public Student save(@RequestBody Student s) {
        return repo.save(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
