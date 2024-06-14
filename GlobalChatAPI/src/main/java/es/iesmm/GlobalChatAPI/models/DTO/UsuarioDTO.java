package es.iesmm.GlobalChatAPI.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsuarioDTO {
    private String username;
    private String email;
    private String nombre;
    private String apellidos;
}
