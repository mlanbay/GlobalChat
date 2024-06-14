package es.iesmm.GlobalChatAPI.repositories;

import es.iesmm.GlobalChatAPI.models.Mensaje;
import es.iesmm.GlobalChatAPI.models.Sala;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajesRepository extends CrudRepository<Mensaje ,Long> {

    @Query("SELECT m FROM Mensaje m WHERE m.sala=?1")
    List<Mensaje> findBySala(Sala sala);
}
