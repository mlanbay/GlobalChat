package es.iesmm.GlobalChatAPI.controllers;

import es.iesmm.GlobalChatAPI.models.DTO.Request.CrearSalaPrivadaRequest;
import es.iesmm.GlobalChatAPI.models.DTO.Request.JoinSalaPrivadaRequest;
import es.iesmm.GlobalChatAPI.models.DTO.SalaPrivadaDTO;
import es.iesmm.GlobalChatAPI.models.EPrivacidad;
import es.iesmm.GlobalChatAPI.models.SalaPrivada;
import es.iesmm.GlobalChatAPI.models.Usuario;
import es.iesmm.GlobalChatAPI.services.SalaPrivadaService;
import es.iesmm.GlobalChatAPI.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class SalaPrivadaController {

    private SalaPrivadaService salaPrivadaService;
    private UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;


    @GetMapping("/salas/privadas")
    private List<SalaPrivada> getSalasPrivadas() {
        return salaPrivadaService.findAll();
    }

    @GetMapping("/salas/privadas/filtro")
    private List<SalaPrivada> getSalasPrivadas(@RequestBody String name) {
        return salaPrivadaService.findByName(name);
    }

    @PostMapping("/salas/crearSalaPrivada")
    private SalaPrivada crearSalaPrivada(@RequestBody CrearSalaPrivadaRequest crearSalaPrivadaRequest) {
        SalaPrivadaDTO salaPrivadaDTO = crearSalaPrivadaRequest.getSalaPrivadaDTO();
        Usuario usuario = usuarioService.getUsuarioById(crearSalaPrivadaRequest.getUsuario_id());

        Set<Usuario> participantes = new HashSet<>();
        participantes.add(usuario);

        SalaPrivada salaPrivada = new SalaPrivada();
        salaPrivada.setNombre(salaPrivadaDTO.getNombre());
        salaPrivada.setPassword(passwordEncoder.encode(salaPrivadaDTO.getPassword()));
        salaPrivada.setDescripcion(salaPrivadaDTO.getDescripcion());
        salaPrivada.setPrivacidad(EPrivacidad.PRIVADA);
        salaPrivada.setTopicos(salaPrivadaDTO.getTopicos());
        salaPrivada.setParticipantes(participantes);
        return salaPrivadaService.save(salaPrivada);
    }

    @PostMapping("/salas/privada/join")
    private ResponseEntity<SalaPrivada> joinSalaPrivada(@RequestBody JoinSalaPrivadaRequest joinSalaPrivadaRequest) {
        SalaPrivada salaPrivada = salaPrivadaService.findByID(joinSalaPrivadaRequest.getSalaPrivada_id());
        Usuario usuario = usuarioService.getUsuarioById(joinSalaPrivadaRequest.getUsuario_id());
        String password = joinSalaPrivadaRequest.getPassword();

        if(passwordEncoder.matches(password, salaPrivada.getPassword())){
            Set<Usuario> participantes = salaPrivada.getParticipantes();
            participantes.add(usuario);
            salaPrivada.setParticipantes(participantes);

            return ResponseEntity.ok(salaPrivadaService.save(salaPrivada));
        }else{
            return ResponseEntity.badRequest().build();
        }


    }
}
