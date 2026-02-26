/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.service.impl;
import EjercicioPractico1_JosueAlfaroZumbado.domain.Servicio;
import EjercicioPractico1_JosueAlfaroZumbado.repository.ServicioRepository;
import EjercicioPractico1_JosueAlfaroZumbado.service.ServicioService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author jalfa
 */
@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio obtenerPorId(Integer id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Servicio guardar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        servicioRepository.deleteById(id);
    }
}
