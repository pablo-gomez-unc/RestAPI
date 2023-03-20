package com.example.restapi.service;

import com.example.restapi.entity.Alumno;
import com.example.restapi.repository.AlumnoRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AlumnoServiceTest {
    @Test
    void testFetch () {
        AlumnoRepository alumnoRepository = mock(AlumnoRepository.class);
        AlumnoService alumnoService = new AlumnoServiceImpl(alumnoRepository);
        when(alumnoRepository.findAll()).thenReturn(new ArrayList<>());
        List<Alumno> result =  alumnoService.fetchList();
        assertNotNull(result);
    }

}