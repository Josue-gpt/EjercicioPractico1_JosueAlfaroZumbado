/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.service;
import EjercicioPractico1_JosueAlfaroZumbado.domain.Servicio;
import java.util.List;
/**
 *
 * @author jalfa
 */
public interface ServicioService {
    List<Servicio> listar();
    Servicio obtenerPorId(Integer id);
    Servicio guardar(Servicio servicio);
    void eliminar(Integer id);
}
