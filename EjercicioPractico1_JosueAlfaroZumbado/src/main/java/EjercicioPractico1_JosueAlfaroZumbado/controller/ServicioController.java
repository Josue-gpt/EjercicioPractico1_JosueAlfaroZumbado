/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.controller;

import EjercicioPractico1_JosueAlfaroZumbado.domain.Servicio;
import EjercicioPractico1_JosueAlfaroZumbado.service.CategoriaService;
import EjercicioPractico1_JosueAlfaroZumbado.service.ServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService servicioService;
    private final CategoriaService categoriaService;

    public ServicioController(ServicioService servicioService, CategoriaService categoriaService) {
        this.servicioService = servicioService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicios", servicioService.listar());
        return "servicio/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("categorias", categoriaService.listar());
        return "servicio/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Servicio servicio) {
        servicioService.guardar(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Servicio servicio = servicioService.obtenerPorId(id);
        if (servicio == null) {
            return "redirect:/servicios";
        }
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categoriaService.listar());
        return "servicio/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            servicioService.eliminar(id);
            ra.addFlashAttribute("mensaje", "Servicio eliminado correctamente.");
        } catch (DataIntegrityViolationException ex) {
            ra.addFlashAttribute("mensaje", "No se puede eliminar el servicio porque tiene reservas asociadas.");
        }
        return "redirect:/servicios";
    }
}
