package es.iesmm.GlobalChatAPI.models.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearTopicoRequest {
    private String topico_nombre;
    private Long usuario_id;
}
