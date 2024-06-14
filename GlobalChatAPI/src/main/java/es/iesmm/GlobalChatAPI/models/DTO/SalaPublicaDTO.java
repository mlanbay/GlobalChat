package es.iesmm.GlobalChatAPI.models.DTO;

import es.iesmm.GlobalChatAPI.models.Topico;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class SalaPublicaDTO {
    private String nombre;
    private String descripcion;
    private Set<Topico> topicos;

    public boolean hadValues() {
        if(nombre!=null){
            return true;
        }
        return false;
    }
}
