package es.iesmm.GlobalChatAPI.controllers;

import es.iesmm.GlobalChatAPI.models.DTO.Request.CrearTopicoRequest;
import es.iesmm.GlobalChatAPI.models.ERol;
import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.Topico;
import es.iesmm.GlobalChatAPI.models.Usuario;
import es.iesmm.GlobalChatAPI.services.RolService;
import es.iesmm.GlobalChatAPI.services.TopicoService;
import es.iesmm.GlobalChatAPI.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class TopicController {

    private TopicoService topicoService;
    private UsuarioService usuarioService;
    private RolService rolService;

    @GetMapping("/topics/lista")
    public ResponseEntity<List<Topico>> getListaTopico(){
        return ResponseEntity.ok(topicoService.getTopicos());
    }

    @GetMapping("/topics/sala")
    public ResponseEntity<List<Topico>> getListaTopicoSala(@RequestBody Sala sala){
        return ResponseEntity.ok(topicoService.getTopicos(sala));
    }

    @PostMapping("/topics/crearTopico")
    public ResponseEntity<Topico> crearTopico(@RequestBody CrearTopicoRequest crearTopicoRequest){
        String topico_nombre = crearTopicoRequest.getTopico_nombre();
        Usuario usuario = usuarioService.getUsuarioById(crearTopicoRequest.getUsuario_id());
        if(usuario.getRoles().contains(rolService.getRol(ERol.MODERATOR))){
            Topico topico = new Topico();
            topico.setNombre(topico_nombre);
            return ResponseEntity.ok(topicoService.crearTopico(topico));
        }else{
            return ResponseEntity.badRequest().build();
        }


    }

    @PostMapping("/topics/eliminarTopico")
    public ResponseEntity<Topico> eliminarTopico(@RequestBody CrearTopicoRequest crearTopicoRequest){
        String topico_nombre = crearTopicoRequest.getTopico_nombre();
        Usuario usuario = usuarioService.getUsuarioById(crearTopicoRequest.getUsuario_id());
        if(usuario.getRoles().contains(rolService.getRol(ERol.MODERATOR))) {
            Topico topico = topicoService.getTopicoByName(topico_nombre);
            return ResponseEntity.ok(topicoService.eliminarTopico(topico));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
