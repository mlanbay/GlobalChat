package es.iesmm.GlobalChatAPI.models.DTO.Request;

import es.iesmm.GlobalChatAPI.models.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.suuft.libretranslate.Language;

import java.util.Locale;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMessageRequest {
    private Sala sala;
    private String locale;
}
