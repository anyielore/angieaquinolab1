package com.example.angieaquinolab1.services;

import com.example.angieaquinolab1.model.Alumno;

import java.util.List;

public interface IAlumnoServices {
    // Listar todos los alumnos
    List<Alumno> listarAlumnos();

    // Buscar alumno por ID
    Alumno buscarAlumnoPorId(int id);

    // Grabar un nuevo alumno
    Alumno guardarAlumno(Alumno alumno);

    // Eliminar un alumno
    void eliminarAlumno(int id);

    // Actualizar un alumno
    Alumno actualizarAlumno(int id, Alumno alumno);
}
