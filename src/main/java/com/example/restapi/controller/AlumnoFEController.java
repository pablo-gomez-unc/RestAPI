package com.example.restapi.controller;

import com.example.restapi.entity.Alumno;
import com.example.restapi.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlumnoFEController {
    @Autowired
    AlumnoService service;
    @GetMapping("/fe/alumnos")
    public String showAddForm(Alumno alumno)
    {
        return "alumnoForm";
    }

    @PostMapping("/fe/alumnos/addAlumno")
    public String addAlumno(Alumno alumno, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            return "alumnoForm";
        }

        service.save(alumno);
        return "redirect:/fe/alumnos/list";
    }

    @GetMapping("/fe/alumnos/list")
    public String showList(Model model) {
        model.addAttribute("alumnos", service.fetchList());
        return "alumnoList";
    }

    @GetMapping("/fe/alumnos/updateAlumno/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Alumno alumno = service.fetchById(id);
        model.addAttribute("alumno", alumno);
        return "alumnoUpdate";
    }

    @PostMapping("/fe/alumnos/update/{id}")
    public String update(@PathVariable("id") long id, Alumno alumno,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            alumno.setId(id);
            return "alumnoUpdate";
        }
        service.update(alumno,id);
        return "redirect:/fe/alumnos/list";
    }

    @GetMapping("/fe/alumnos/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        service.deleteById(id);
        return "redirect:/fe/alumnos/list";
    }

}
