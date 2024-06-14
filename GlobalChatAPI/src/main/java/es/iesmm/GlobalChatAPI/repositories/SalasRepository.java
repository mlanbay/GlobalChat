package es.iesmm.GlobalChatAPI.repositories;

import es.iesmm.GlobalChatAPI.models.EPrivacidad;
import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.SalaPublica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SalasRepository extends CrudRepository<Sala, Long> {

    @Query("SELECT s FROM Sala s WHERE s.privacidad=?1")
    Set<SalaPublica> findByPrivacity(EPrivacidad privacidad);
}
