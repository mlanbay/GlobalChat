package es.iesmm.GlobalChatAPI.controllers;

import es.iesmm.GlobalChatAPI.models.DTO.Request.CrearSalaRequest;
import es.iesmm.GlobalChatAPI.models.DTO.Request.JoinSalaPublicRequest;
import es.iesmm.GlobalChatAPI.models.DTO.SalaPublicaDTO;
import es.iesmm.GlobalChatAPI.models.EPrivacidad;
import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.SalaPublica;
import es.iesmm.GlobalChatAPI.models.Usuario;
import es.iesmm.GlobalChatAPI.services.SalaPublicaService;
import es.iesmm.GlobalChatAPI.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller()
@AllArgsConstructor
public class SalasPublicasController {
    private final UsuarioService usuarioService;
    private SalaPublicaService salasPublicasSevice;

    @GetMapping("/salas/publicas")
    public ResponseEntity<Set<SalaPublica>> getSalasPublicas(){
        return ResponseEntity.ok(salasPublicasSevice.findPublicSalas());
    }

    @PostMapping("/sala/crearSalaPublica")
    public SalaPublica crearSala(@RequestBody CrearSalaRequest request){
        Long usuario_id = request.getUsuario_id();
        SalaPublicaDTO sala=request.getSala();

        if(sala.hadValues()){
            SalaPublica salaPublica = new SalaPublica();
            salaPublica.setNombre(sala.getNombre());
            salaPublica.setDescripcion(sala.getDescripcion());
            salaPublica.setPrivacidad(EPrivacidad.PUBLICA);
            salaPublica.setParticipantes(new HashSet<>());
            salaPublica.setTopicos(sala.getTopicos());

            Usuario usuario=usuarioService.getUsuarioById(usuario_id);
            Set<Sala> salas =usuario.getSalas();
            salas.add(salaPublica);
            usuario.setSalas(salas);
            System.out.println(usuario);
            System.out.println(salaPublica);
            return salasPublicasSevice.saveSalaPublica(salaPublica,usuario);
        }else{
            return null;
        }


    }

    @PostMapping("/sala/publica/join")
    private ResponseEntity<SalaPublica> joinSalaPublica(@RequestBody JoinSalaPublicRequest joinSalaPublicRequest){
        SalaPublica sala= joinSalaPublicRequest.getSalaPublica();
        Long usuario_id = joinSalaPublicRequest.getUsuario_id();
        Usuario usuario = usuarioService.getUsuarioById(usuario_id);
        if(sala!=null && usuario!=null){
            if (!salasPublicasSevice.usuarioPertenece(sala,usuario)){
                return ResponseEntity.ok(salasPublicasSevice.join(sala,usuario));
            }else{
                return ResponseEntity.badRequest().build();
            }
        }else {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/sala/publica/leave")
    private ResponseEntity<SalaPublica> leaveSalaPublica(@RequestBody JoinSalaPublicRequest joinSalaPublicRequest){
        SalaPublica salaPublica = joinSalaPublicRequest.getSalaPublica();
        Long usuario_id= joinSalaPublicRequest.getUsuario_id();
        Usuario usuario = usuarioService.getUsuarioById(usuario_id);
        return ResponseEntity.ok(salasPublicasSevice.leave(salaPublica,usuario));
    }


}
