package es.iesmm.GlobalChatAPI.models.DTO.Request;

import es.iesmm.GlobalChatAPI.models.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeDescriptionRequest {
    private Sala sala;
    private String descripcion;
}
