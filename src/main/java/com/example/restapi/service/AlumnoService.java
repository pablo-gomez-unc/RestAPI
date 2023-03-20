package com.example.restapi.service;

import com.example.restapi.entity.Alumno;
import java.util.List;

public interface AlumnoService {

    // Save operation
    Alumno save(Alumno alumno);

    // Read operation
    List<Alumno> fetchList();

    // Update operation
    Alumno update(Alumno alumno, Long alumnoId);

    // Delete operation
    void deleteById(Long alumnoId);

    Alumno fetchById(long id);
}
