package es.iesmm.GlobalChatAPI.services;

import es.iesmm.GlobalChatAPI.models.ERol;
import es.iesmm.GlobalChatAPI.models.Rol;
import es.iesmm.GlobalChatAPI.models.Usuario;
import es.iesmm.GlobalChatAPI.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(Long id){
        return usuarioRepository.findByid(id);
    }


    public Usuario getUsuarioByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }


    public List<Usuario> getUsuariosByRol(Rol rol) {
        return usuarioRepository.findUserByRol(rol);
    }
}
