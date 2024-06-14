package es.iesmm.GlobalChatAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "Usuario_UUID")
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "Sala_ID")
    private Sala sala;

    private String mensaje;

    private LocalDateTime date;


}
