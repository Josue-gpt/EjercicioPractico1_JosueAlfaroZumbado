/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.service;
import EjercicioPractico1_JosueAlfaroZumbado.domain.Reserva;
import java.util.List;
/**
 *
 * @author jalfa
 */
public interface ReservaService {
    List<Reserva> listar();
    Reserva obtenerPorId(Integer id);
    Reserva guardar(Reserva reserva);
    void eliminar(Integer id);
}
