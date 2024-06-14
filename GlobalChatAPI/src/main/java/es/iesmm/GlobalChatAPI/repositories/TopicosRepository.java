package es.iesmm.GlobalChatAPI.repositories;

import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.Topico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicosRepository extends CrudRepository<Topico,Long> {

    @Query("SELECT t FROM Topico t JOIN t.salas s WHERE s=?1")
    List<Topico> findBySala(Sala sala);

    @Query("SELECT t FROM Topico t WHERE t.nombre=?1")
    Topico findByName(String topicoNombre);
}
