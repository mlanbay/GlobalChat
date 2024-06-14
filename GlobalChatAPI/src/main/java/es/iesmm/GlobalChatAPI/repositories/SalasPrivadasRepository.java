package es.iesmm.GlobalChatAPI.repositories;

import es.iesmm.GlobalChatAPI.models.SalaPrivada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalasPrivadasRepository extends CrudRepository<SalaPrivada, Long> {


    @Query("SELECT sp FROM SalaPrivada sp WHERE sp.nombre=?1")
    List<SalaPrivada> findByName(String name);
}
