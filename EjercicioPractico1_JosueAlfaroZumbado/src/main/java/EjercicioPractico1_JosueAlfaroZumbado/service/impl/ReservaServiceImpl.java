/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico1_JosueAlfaroZumbado.service.impl;
import EjercicioPractico1_JosueAlfaroZumbado.domain.Reserva;
import EjercicioPractico1_JosueAlfaroZumbado.repository.ReservaRepository;
import EjercicioPractico1_JosueAlfaroZumbado.service.ReservaService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author jalfa
 */
@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva obtenerPorId(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        reservaRepository.deleteById(id);
    }
}
