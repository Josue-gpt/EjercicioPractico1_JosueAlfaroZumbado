/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.service;
import EjercicioPractico1_JosueAlfaroZumbado.domain.Categoria;
import java.util.List;
/**
 *
 * @author jalfa
 */
public interface CategoriaService {
    List<Categoria> listar();
    Categoria obtenerPorId(Integer id);
    Categoria guardar(Categoria categoria);
    void eliminar(Integer id);
}
