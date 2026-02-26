/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.service.impl;
import EjercicioPractico1_JosueAlfaroZumbado.domain.Categoria;
import EjercicioPractico1_JosueAlfaroZumbado.repository.CategoriaRepository;
import EjercicioPractico1_JosueAlfaroZumbado.service.CategoriaService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria obtenerPorId(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
