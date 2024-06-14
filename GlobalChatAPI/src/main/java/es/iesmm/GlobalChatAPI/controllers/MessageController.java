package es.iesmm.GlobalChatAPI.controllers;

import es.iesmm.GlobalChatAPI.logic.Traductor;
import es.iesmm.GlobalChatAPI.models.DTO.MensajeDTO;
import es.iesmm.GlobalChatAPI.models.DTO.Request.GetMessageRequest;
import es.iesmm.GlobalChatAPI.models.DTO.Request.SendMessageRequest;
import es.iesmm.GlobalChatAPI.models.Mensaje;
import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.Usuario;
import es.iesmm.GlobalChatAPI.services.MensajesService;
import lombok.AllArgsConstructor;
import net.suuft.libretranslate.Language;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller()
@AllArgsConstructor
public class MessageController {

    private MensajesService mensajesService;

    @GetMapping("/chat/get")
    public List<Mensaje> getMessagesSala(@RequestBody GetMessageRequest getMessageRequest){
        Sala sala = getMessageRequest.getSala();
        String idioma = getMessageRequest.getLocale();

        List<Mensaje> mensajes = mensajesService.getMensajesSala(sala);

        Language language;
        Set<Language> languages= Arrays.stream(Language.values()).filter(l->l.name().equals(idioma)).collect(Collectors.toSet());
        if(languages.size()==1){
            language=languages.iterator().next();
            mensajes.forEach(mensaje -> {
                mensaje.setMensaje(Traductor.translate(mensaje.getMensaje(),language));
            });
        }

        return mensajes;
    }

    @PostMapping("/chat/send")
    public Mensaje sendMessagesSala(@RequestBody SendMessageRequest sendMessageRequest){
        Sala sala = sendMessageRequest.getSala();
        MensajeDTO mensajeDTO = sendMessageRequest.getMensaje();
        Usuario usuario = sendMessageRequest.getUsuario();

        Mensaje mensaje = new Mensaje();
        mensaje.setSala(sala);
        mensaje.setUsuario(usuario);
        mensaje.setMensaje(mensajeDTO.getMensaje());
        mensaje.setDate(mensajeDTO.getDate());
        return mensajesService.saveMensaje(mensaje);
    }



}
