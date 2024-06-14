package es.iesmm.GlobalChatAPI.services;

import es.iesmm.GlobalChatAPI.models.ERol;
import es.iesmm.GlobalChatAPI.models.Rol;
import es.iesmm.GlobalChatAPI.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Rol getRol(ERol eRol) {


        Rol rol = rolRepository.findByRol(eRol);

        if (rol==null){
            rol=new Rol();
            rol.setNombre(ERol.USER);

            rolRepository.save(rol);
        }

        return rol;
    }
}
