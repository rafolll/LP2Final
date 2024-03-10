package com.cibertec.pe.servicio;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.pe.entidades.Libro;
import com.cibertec.pe.repositorio.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    
    public Libro registrarLibro(Libro libro) {
        return libroRepository.save(libro);
    }
    
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }
    
    public List<Libro> obtenerLibrosRegistradosUltimosMeses(int meses) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -meses);
        Date fecha = new Date(calendar.getTimeInMillis());	
        return libroRepository.findByFechaPublicacionAfter(fecha);
    }
}
