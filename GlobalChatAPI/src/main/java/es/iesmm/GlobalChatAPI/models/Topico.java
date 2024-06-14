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

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Sala.class,cascade = CascadeType.PERSIST)
    @JoinTable(name = "Topico_Sala", joinColumns = @JoinColumn(name = "topico_id"),inverseJoinColumns = @JoinColumn(name = "Sala_ID"))
    private Set<Sala> salas;
}
