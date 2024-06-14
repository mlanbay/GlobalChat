package es.iesmm.GlobalChatAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @NotBlank
    @Size(max = 30)
    private String username;

    @Email
    @NotBlank
    @Size(max = 80)
    private String email;

    @NotBlank
    @Size(max = 80)
    private String nombre;

    @NotBlank
    @Size(max = 80)
    private String apellidos;

    @ManyToMany(fetch = FetchType.EAGER , targetEntity = Rol.class,cascade = CascadeType.PERSIST)
    @JoinTable(name = "Usuario_rol",joinColumns = @JoinColumn(name = "Usuario_UUID"),inverseJoinColumns = @JoinColumn(name = "Rol_ID"))
    private Set<Rol> roles;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Sala.class,cascade = CascadeType.PERSIST)
    @JoinTable(name = "Usuario_Sala", joinColumns = @JoinColumn(name = "Usuario_UUID"),inverseJoinColumns = @JoinColumn(name = "Sala_ID"))
    private Set<Sala> salas;



}
