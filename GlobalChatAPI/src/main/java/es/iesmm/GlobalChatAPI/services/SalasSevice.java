package es.iesmm.GlobalChatAPI.services;

import es.iesmm.GlobalChatAPI.models.*;
import es.iesmm.GlobalChatAPI.repositories.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class SalasSevice {

    @Autowired
    private SalasRepository salasRepository;
    

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void makeSalaPublic(Sala sala) {
        if(sala.getClass()!=SalaPublica.class){
            SalaPublica salaPublica = (SalaPublica) sala;
            salasRepository.save(salaPublica);
        }
    }

    public void makeSalaPrivate(Sala sala,String password) {
        if(sala.getClass()== SalaPrivada.class){

            SalaPrivada salaPrivada = (SalaPrivada) sala;

            salaPrivada.setPassword(passwordEncoder.encode(password));

            salasRepository.save(salaPrivada);
        }
    }

    public void closeSala(Sala sala) {
        if(sala.getClass()!=SalaCerrada.class){
            SalaCerrada salaCerrada = (SalaCerrada) sala;

            salasRepository.save(salaCerrada);
        }
    }



    public Set<Sala> findUserSalas(Usuario usuario){
        return usuario.getSalas();
    }

    public void changeDescripcion(Sala sala,String descipcion){
        sala.setDescripcion(descipcion);
        salasRepository.save(sala);
    }

    public void changeNombre(Sala sala, String nombre){
        sala.setNombre(nombre);
        salasRepository.save(sala);
    }

    public Optional<Sala> findSalaById(Long sala_id){
        return salasRepository.findById(sala_id);
    }

}
