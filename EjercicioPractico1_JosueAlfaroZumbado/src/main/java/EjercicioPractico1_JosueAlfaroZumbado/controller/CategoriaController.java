/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.controller;

import EjercicioPractico1_JosueAlfaroZumbado.domain.Categoria;
import EjercicioPractico1_JosueAlfaroZumbado.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.listar());
        return "categoria/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id);
        if (categoria == null) {
            return "redirect:/categorias";
        }
        model.addAttribute("categoria", categoria);
        return "categoria/form";
    }

    @GetMapping("/eliminar/{id}")
public String eliminar(@PathVariable Integer id, RedirectAttributes ra) {
    try {
        categoriaService.eliminar(id);
        ra.addFlashAttribute("mensaje", "Categoría eliminada correctamente.");
    } catch (DataIntegrityViolationException ex) {
        ra.addFlashAttribute("mensaje", "No se puede eliminar la categoría porque tiene servicios asociados.");
    }
    return "redirect:/categorias";
}
}
