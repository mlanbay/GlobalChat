package es.iesmm.GlobalChatAPI.services;

import es.iesmm.GlobalChatAPI.models.Mensaje;
import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.repositories.MensajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajesService {

    @Autowired
    private MensajesRepository mensajesRepository;

    public Mensaje saveMensaje(Mensaje mensaje){
        mensajesRepository.save(mensaje);
        return mensaje;
    }

    public List<Mensaje> getMensajesSala(Sala sala){
        return mensajesRepository.findBySala(sala);
    }

}
