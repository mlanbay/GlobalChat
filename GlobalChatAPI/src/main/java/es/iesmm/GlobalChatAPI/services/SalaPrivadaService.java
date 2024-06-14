package es.iesmm.GlobalChatAPI.services;

import es.iesmm.GlobalChatAPI.models.SalaPrivada;
import es.iesmm.GlobalChatAPI.repositories.SalasPrivadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaPrivadaService {

    @Autowired
    private SalasPrivadasRepository salasPrivadasRepository;


    public List<SalaPrivada> findAll() {
        return (List<SalaPrivada>) salasPrivadasRepository.findAll();
    }

    public List<SalaPrivada> findByName(String name) {
        return salasPrivadasRepository.findByName(name);
    }

    public SalaPrivada save(SalaPrivada salaPrivada) {
        salasPrivadasRepository.save(salaPrivada);
        return salaPrivada;
    }

    public SalaPrivada findByID(Long salaPrivadaId) {
        return salasPrivadasRepository.findById(salaPrivadaId).orElse(null);
    }
}
