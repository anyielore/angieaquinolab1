package com.example.angieaquinolab1.services.lmpl;

import com.example.angieaquinolab1.model.Alumno;
import com.example.angieaquinolab1.respository.IAlumnoRepository;
import com.example.angieaquinolab1.services.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServices implements IAlumnoServices {

    IAlumnoRepository _alumnoRepository;
    @Autowired
    public AlumnoServices(IAlumnoRepository alumnoRepository) {
        _alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Alumno> listarAlumnos() {

        return _alumnoRepository.findAll();

    }

    @Override
    public Alumno buscarAlumnoPorId(int id) {
        Optional<Alumno> rowInDB = _alumnoRepository.findById(id);
        if (rowInDB.isPresent())
            return rowInDB.get();
        else
            return new Alumno();
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        Alumno guardarAlumno = _alumnoRepository.save(alumno);
        return guardarAlumno;
    }

    @Override
    public void eliminarAlumno(int id) {
        _alumnoRepository.deleteById(id);

    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumno) {
        Optional<Alumno> alumnoOptional = _alumnoRepository.findById(id);
        if (alumnoOptional.isPresent()) {
            Alumno alumnoEnDB = alumnoOptional.get();
            alumnoEnDB.setPrimernombre(alumno.getPrimernombre());
            alumnoEnDB.setSegundonombre(alumno.getSegundonombre());
            alumnoEnDB.setApellidop(alumno.getApellidop());
            alumnoEnDB.setApellidom(alumno.getApellidom());
            alumnoEnDB.setEdad(alumno.getEdad());
            alumnoEnDB.setDireccion(alumno.getDireccion());
            alumnoEnDB.setTel(alumno.getTel());
            return _alumnoRepository.save(alumnoEnDB);
        } else {
            return null;
        }
    }
}
