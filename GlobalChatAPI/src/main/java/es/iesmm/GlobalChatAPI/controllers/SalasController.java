package es.iesmm.GlobalChatAPI.controllers;

import es.iesmm.GlobalChatAPI.models.DTO.Request.ChangeDescriptionRequest;
import es.iesmm.GlobalChatAPI.models.DTO.Request.ChangeNombreSalaRequest;
import es.iesmm.GlobalChatAPI.models.DTO.Request.MakeSalaPrivateRequest;
import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.services.SalasSevice;
import es.iesmm.GlobalChatAPI.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Controller()
@AllArgsConstructor
public class SalasController {


    private SalasSevice salasSevice;
    private UsuarioService usuarioService;


    @GetMapping("/{username}/salas")
     public Set<Sala> getSalasUser(@PathVariable String username){
         return salasSevice.findUserSalas(usuarioService.getUsuarioByUsername(username));
     }

    @PostMapping("/sala/deleteSala")
    public Sala eliminarSala(@RequestBody Sala sala){
        salasSevice.closeSala(sala);
        return sala;
    }

    @PostMapping("/sala/makePrivate")
    public Sala makeSalaPrivate(@RequestBody MakeSalaPrivateRequest makeSalaPrivateRequest){
        Sala sala= makeSalaPrivateRequest.getSala();
        String password= makeSalaPrivateRequest.getPassword();
        salasSevice.makeSalaPrivate(sala,password);
        return sala;
    }

    @PostMapping("/sala/makePublic")
    public Sala makeSalaPublic(@RequestBody Sala sala){
        salasSevice.makeSalaPublic(sala);
        return sala;
    }

    @PostMapping("/sala/descripcion")
    public Sala changeDescripcion(@RequestBody ChangeDescriptionRequest changeDescriptionRequest){
        Sala sala = changeDescriptionRequest.getSala();
        String descripcion = changeDescriptionRequest.getDescripcion();
        salasSevice.changeDescripcion(sala,descripcion);
        return sala;
    }

    @PostMapping("/sala/nombre")
    public Sala changeNombre(@RequestBody ChangeNombreSalaRequest changeNombreRequest){
        Sala sala = changeNombreRequest.getSala();
        String nombre = changeNombreRequest.getNombre();
        salasSevice.changeNombre(sala, nombre);
        return sala;
    }

}
