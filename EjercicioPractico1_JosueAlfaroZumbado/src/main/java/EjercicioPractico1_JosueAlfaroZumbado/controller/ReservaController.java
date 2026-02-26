/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.controller;
import EjercicioPractico1_JosueAlfaroZumbado.domain.Reserva;
import EjercicioPractico1_JosueAlfaroZumbado.service.ReservaService;
import EjercicioPractico1_JosueAlfaroZumbado.service.ServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author jalfa
 */
@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ServicioService servicioService;

    public ReservaController(ReservaService reservaService, ServicioService servicioService) {
        this.reservaService = reservaService;
        this.servicioService = servicioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listar());
        return "reserva/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("servicios", servicioService.listar());
        return "reserva/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}
