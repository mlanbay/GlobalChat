package es.iesmm.GlobalChatAPI.models.DTO;

import es.iesmm.GlobalChatAPI.models.Topico;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class SalaPrivadaDTO {
    private String nombre;
    private String descripcion;
    private String password;
    private Set<Topico> topicos;
}
