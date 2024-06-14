package es.iesmm.GlobalChatAPI.models.DTO.Request;

import es.iesmm.GlobalChatAPI.models.DTO.MensajeDTO;
import es.iesmm.GlobalChatAPI.models.Mensaje;
import es.iesmm.GlobalChatAPI.models.Sala;
import es.iesmm.GlobalChatAPI.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageRequest {
private Sala sala;
private MensajeDTO mensaje;
private Usuario usuario;
}
