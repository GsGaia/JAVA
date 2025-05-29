package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeAccident;
import br.com.fiap.Gs.Gaia.Enum.TypeSeverity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccident;


    private LocalDate dateAccidentStart;
    private LocalDate dateAccidentEnd;

    private TypeAccident typeAccident;
    private TypeSeverity severityAccident;

    @OneToOne
    @JoinColumn(name = "id_location")
    private Location location;
}
