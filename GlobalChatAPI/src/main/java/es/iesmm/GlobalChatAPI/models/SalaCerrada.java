package es.iesmm.GlobalChatAPI.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table
public class SalaCerrada extends Sala{
    public LocalDateTime fechaVeto;
}
