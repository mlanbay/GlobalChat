package es.iesmm.GlobalChatAPI.repositories;

import es.iesmm.GlobalChatAPI.models.Rol;
import es.iesmm.GlobalChatAPI.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

    @Query("SELECT u FROM Usuario u WHERE u.username=?1")
    Usuario findByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE u.email=?1")
    Usuario findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.ID=?1")
    Usuario findByid(Long id);

    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r = ?1")
    List<Usuario> findUserByRol(Rol rol);
}
