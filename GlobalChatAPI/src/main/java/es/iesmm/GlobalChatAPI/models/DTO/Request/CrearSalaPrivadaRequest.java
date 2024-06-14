package es.iesmm.GlobalChatAPI.models.DTO.Request;

import es.iesmm.GlobalChatAPI.models.DTO.SalaPrivadaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearSalaPrivadaRequest {
    private SalaPrivadaDTO salaPrivadaDTO;
    private Long usuario_id;
}
