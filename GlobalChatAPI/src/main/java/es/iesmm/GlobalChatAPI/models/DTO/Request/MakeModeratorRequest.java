package es.iesmm.GlobalChatAPI.models.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeModeratorRequest {
    private Long usuario_id;
    private Long admin_id;
}
