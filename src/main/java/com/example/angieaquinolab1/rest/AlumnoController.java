package com.example.angieaquinolab1.rest;

import com.example.angieaquinolab1.model.Alumno;
import com.example.angieaquinolab1.services.IAlumnoServices;
import com.example.angieaquinolab1.services.lmpl.AlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {
    private final AlumnoServices alumnoServices;

    @Autowired
    public AlumnoController(IAlumnoServices alumnoServices) {
        this.alumnoServices= (AlumnoServices) alumnoServices;

    }

    @GetMapping("/alumnos")
    public List<Alumno> getAll() {
        return alumnoServices.listarAlumnos();
    }

    @GetMapping("/alumno/{id}")
    public Alumno  getAll(@PathVariable int id) {
        return alumnoServices.buscarAlumnoPorId(id);
    }
    @PostMapping("/alumno")
    public Alumno guardarAlumno(@RequestBody Alumno alumno) {
        return alumnoServices.guardarAlumno(alumno);
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminarAlumno(@PathVariable int id) {
        alumnoServices.eliminarAlumno(id);
    }
    @PutMapping("/actualizar/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumno) {
        return alumnoServices.actualizarAlumno(id, alumno);
    }


}
