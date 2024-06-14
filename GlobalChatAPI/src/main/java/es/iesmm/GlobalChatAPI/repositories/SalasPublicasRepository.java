package es.iesmm.GlobalChatAPI.repositories;

import es.iesmm.GlobalChatAPI.models.SalaPublica;
import es.iesmm.GlobalChatAPI.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalasPublicasRepository extends CrudRepository<SalaPublica, Long> {

}
