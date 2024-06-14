package es.iesmm.GlobalChatAPI.models.DTO.Request;

import es.iesmm.GlobalChatAPI.models.SalaPublica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinSalaPublicRequest {
    private SalaPublica salaPublica;
    private Long usuario_id;
}
