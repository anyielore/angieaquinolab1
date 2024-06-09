package com.example.angieaquinolab1.respository;


import com.example.angieaquinolab1.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno,Integer> {
}
