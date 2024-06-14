package es.iesmm.GlobalChatAPI.repositories;

import es.iesmm.GlobalChatAPI.models.ERol;
import es.iesmm.GlobalChatAPI.models.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<Rol,Long> {

@Query("SELECT r FROM Rol r WHERE r.nombre=?1")
    Rol findByRol(ERol nombre);
}
