package com.cibertec.pe.controlador;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.pe.entidades.Libro;
import com.cibertec.pe.servicio.LibroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/listar")
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.obtenerTodosLosLibros();
        model.addAttribute("libros", libros);
        return "listarLibros";
    }
    
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("libro", new Libro());
        return "registroLibro";
    }
    
    @PostMapping("/registro")
    public String registrarLibro(@Valid @ModelAttribute("libro") Libro libro, 
                                 BindingResult result, 
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "registroLibro";
        }
        
        libroService.registrarLibro(libro);
        redirectAttributes.addFlashAttribute("mensaje", "¡Libro registrado exitosamente!");
        return "redirect:/libros/registro";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(text).getTime()));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });
    }
}
