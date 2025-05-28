package br.com.fiap.Gs.Gaia.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "requestion")
public class Requestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequestion;

    private String title;
    private String description;
    private String unit;
    private LocalDate dataDaRequisicao;
    private Boolean activeRequestion;

    @ManyToOne
    @JoinColumn(name = "id_users")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;
}
