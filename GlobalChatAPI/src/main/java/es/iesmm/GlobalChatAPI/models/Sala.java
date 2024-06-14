package es.iesmm.GlobalChatAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EPrivacidad privacidad;

    @ManyToMany(mappedBy = "salas")
    private Set<Usuario> participantes;

    @ManyToMany(mappedBy = "salas")
    private Set<Topico> topicos;

}
