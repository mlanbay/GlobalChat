package es.iesmm.GlobalChatAPI.services;

import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.SalaPublica;
import es.iesmm.GlobalChatAPI.models.Usuario;
import es.iesmm.GlobalChatAPI.repositories.SalasPublicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SalaPublicaService {

    @Autowired
    private SalasPublicasRepository salasPublicasRepository;

    public Set<SalaPublica> findPublicSalas(){
        Set<SalaPublica> result = Collections.emptySet();
        result = StreamSupport.stream(salasPublicasRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
        System.out.println(result.size());
        return result;
    }

    public SalaPublica saveSalaPublica(SalaPublica salaPublica, Usuario usuario){
        Set<Usuario> participantes = salaPublica.getParticipantes();
        participantes.add(usuario);
        salaPublica.setParticipantes(participantes);
        salasPublicasRepository.save(salaPublica);
        return salaPublica;
    }

    public boolean usuarioPertenece(SalaPublica sala, Usuario usuario) {
        Set<Usuario> participantes = sala.getParticipantes();
        return participantes.contains(usuario);

    }

    public SalaPublica join(SalaPublica salaPublica, Usuario usuario) {
        Set<Usuario> participantes= salaPublica.getParticipantes();
        participantes.add(usuario);
        salaPublica.setParticipantes(participantes);
        salasPublicasRepository.save(salaPublica);
        return salaPublica;
    }

    public SalaPublica leave(SalaPublica salaPublica, Usuario usuario){
        Set<Usuario> participantes=salaPublica.getParticipantes();
        participantes.remove(usuario);
        salaPublica.setParticipantes(participantes);
        salasPublicasRepository.save(salaPublica);
        return salaPublica;
    }
}
