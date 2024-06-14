package es.iesmm.GlobalChatAPI.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class MensajeDTO {
    private String mensaje;
    private LocalDateTime date;
}
