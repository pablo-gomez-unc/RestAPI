package com.example.restapi.controller;

import com.example.restapi.entity.Alumno;
import com.example.restapi.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/alumnos")
    public Alumno save(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    // Read operation
    @GetMapping("/alumnos")
    public List<Alumno> fetch()
    {
        return alumnoService.fetchList();
    }

    // Update operation
    @PutMapping("/alumnos/{id}")
    public Alumno update (@RequestBody Alumno alumno,
                     @PathVariable("id") Long alumnoId) {
        return alumnoService.update(
                alumno, alumnoId);
    }

    // Delete operation
    @DeleteMapping("/alumnos/{id}")
    public String delete(@PathVariable("id") Long alumnoId) {
        alumnoService.deleteById(alumnoId);
        return "Deleted Successfully";
    }
}
