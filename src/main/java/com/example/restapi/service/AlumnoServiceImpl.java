package com.example.restapi.service;

import com.example.restapi.entity.Alumno;
import com.example.restapi.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    private AlumnoRepository alumnoRepository;


    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    // Save operation
    @Override
    public Alumno save(Alumno alumno)
    {
        return alumnoRepository.save(alumno);
    }

    // Read operation
    @Override public List<Alumno> fetchList()
    {
        return alumnoRepository.findAll();
    }

    // Update operation
    @Override
    public Alumno update(Alumno alumno, Long alumnoId)
    {
        Alumno alumnoDb = alumnoRepository.findById(alumnoId).get();
        if (Objects.nonNull(alumno.getName()) && !"".equalsIgnoreCase(alumno.getName())) {
            alumnoDb.setName(alumno.getName());
        }

        if (Objects.nonNull(alumno.getEmail()) && !"".equalsIgnoreCase(alumno.getEmail())) {
            alumnoDb.setEmail(alumno.getEmail());
        }

        return alumnoRepository.save(alumnoDb);
    }

    // Delete operation
    @Override
    public void deleteById(Long alumnoId)
    {
        alumnoRepository.deleteById(alumnoId);
    }

    @Override
    public Alumno fetchById(long id) {
        return alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid alumno Id:" + id));
    }
}