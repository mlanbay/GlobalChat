package es.iesmm.GlobalChatAPI.controllers;

import es.iesmm.GlobalChatAPI.models.DTO.Request.ChangeUsernameRequest;
import es.iesmm.GlobalChatAPI.models.DTO.Request.MakeModeratorRequest;
import es.iesmm.GlobalChatAPI.models.DTO.UsuarioDTO;
import es.iesmm.GlobalChatAPI.models.ERol;
import es.iesmm.GlobalChatAPI.models.Rol;
import es.iesmm.GlobalChatAPI.models.Usuario;
import es.iesmm.GlobalChatAPI.services.RolService;
import es.iesmm.GlobalChatAPI.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;
    private RolService rolService;

    @PostMapping("/usuario/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){

            Set<Rol> roles = new HashSet<>();
            Rol rol = rolService.getRol(ERol.USER);
            roles.add(rol);

            Usuario usuario = new Usuario();
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setUsername(usuarioDTO.getUsername());
            usuario.setApellidos(usuarioDTO.getApellidos());
            usuario.setRoles(roles);

            usuarioService.saveUsuario(usuario);
            System.out.println(usuario);
            return ResponseEntity.ok(usuario);
    }

    @GetMapping("/usuario/email/{usuario_email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String usuario_email){
        Usuario usuario = usuarioService.getUsuarioByEmail(usuario_email);
        System.out.println(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/usuario/id/{usuario_id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usuario_id){
        System.out.println(usuario_id);
        Usuario usuario = usuarioService.getUsuarioById(usuario_id);
        System.out.println("USUARIO POR ID "+usuario);
        return ResponseEntity.ok(usuario);
    }


    @PostMapping("/usuario/updateProfile")
    public ResponseEntity<Usuario> changeUsername(@RequestBody ChangeUsernameRequest changeUsernameRequest) {
        Long usuario_id = changeUsernameRequest.getUsuario_id();
        UsuarioDTO usuarioDTO = changeUsernameRequest.getUsuarioDTO();
        Usuario usuario = usuarioService.getUsuarioById(usuario_id);
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setApellidos(usuarioDTO.getApellidos());
        usuario.setNombre(usuarioDTO.getNombre());
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuario/makeModerator")
    public ResponseEntity<Usuario> makeModerator(@RequestBody MakeModeratorRequest makeModeratorRequest){
        Usuario admin = usuarioService.getUsuarioById(makeModeratorRequest.getAdmin_id());
        if(usuarioService.getUsuariosByRol(rolService.getRol(ERol.ADMIN)).contains(admin)){
            Usuario usuario= usuarioService.getUsuarioById(makeModeratorRequest.getUsuario_id());
            Rol rol =rolService.getRol(ERol.MODERATOR);
            Set<Rol> roles = usuario.getRoles();
            roles.add(rol);
            usuario.setRoles(roles);
            usuarioService.saveUsuario(usuario);
            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/usuario/deleteModerator")
    public ResponseEntity<Usuario> deleteModerator(@RequestBody MakeModeratorRequest makeModeratorRequest){
        Usuario admin = usuarioService.getUsuarioById(makeModeratorRequest.getAdmin_id());
        if(usuarioService.getUsuariosByRol(rolService.getRol(ERol.ADMIN)).contains(admin)) {
            Usuario usuario = usuarioService.getUsuarioById(makeModeratorRequest.getUsuario_id());
            Rol rol = rolService.getRol(ERol.MODERATOR);
            Set<Rol> roles = usuario.getRoles();
            roles.remove(rol);
            usuario.setRoles(roles);
            usuarioService.saveUsuario(usuario);
            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/usuarios/lista")
    public ResponseEntity<List<Usuario>> getListaUsuarios(){
        List<Usuario> listaUsuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(listaUsuarios);
    }

    @GetMapping("/usuarios/listaMods")
    public ResponseEntity<List<Usuario>> getListaMods(@RequestBody Long usuario_id){
        Usuario admin = usuarioService.getUsuarioById(usuario_id);
        if(usuarioService.getUsuariosByRol(rolService.getRol(ERol.ADMIN)).contains(admin)) {
            Rol rol = rolService.getRol(ERol.MODERATOR);
            List<Usuario> listaUsuarios = usuarioService.getUsuariosByRol(rol);
            return ResponseEntity.ok(listaUsuarios);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
