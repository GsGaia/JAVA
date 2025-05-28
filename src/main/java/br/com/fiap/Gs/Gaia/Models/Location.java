package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;

    private TypeStation state;
    private String city;
    private LocalDate startAccident;
    private LocalDate endAccident;
    private TypeStatusLocation statusLocation;

    @OneToMany(mappedBy = "location")
    private List<Requestion> requestions = new ArrayList<>();

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private Accident accident;

}
