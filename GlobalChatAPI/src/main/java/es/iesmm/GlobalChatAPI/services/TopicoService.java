
package es.iesmm.GlobalChatAPI.services;

import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.Topico;
import es.iesmm.GlobalChatAPI.repositories.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicosRepository topicosRepository;

    public Topico crearTopico(Topico topico){
        topicosRepository.save(topico);
        return topico;
    }


    public List<Topico> getTopicos() {
        return (List<Topico>) topicosRepository.findAll();
    }

    public List<Topico> getTopicos(Sala sala) {
        return topicosRepository.findBySala(sala);
    }

    public Topico getTopicoByName(String topicoNombre) {
        return topicosRepository.findByName(topicoNombre);
    }

    public Topico eliminarTopico(Topico topico) {
        topicosRepository.delete(topico);
        return topico;
    }
}

