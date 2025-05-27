package br.com.fiap.Gs.Gaia.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Requestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequestion;

    private String title;
    private String description;
    private String unit;

    private LocalDate dataDaRequisicao;

    //@ManyToOne
    //@JoinColumn(name = "user_id")
   // private User user;


    public Requestion() {
    }

    public Requestion(Long idRequestion, String title, String description, String unit, LocalDate dataDaRequisicao) {
        this.idRequestion = idRequestion;
        this.title = title;
        this.description = description;
        this.unit = unit;
        this.dataDaRequisicao = dataDaRequisicao;
    }

    public Long getIdRequestion() {
        return idRequestion;
    }

    public void setIdRequestion(Long idRequestion) {
        this.idRequestion = idRequestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDate getDataDaRequisicao() {
        return dataDaRequisicao;
    }

    public void setDataDaRequisicao(LocalDate dataDaRequisicao) {
        this.dataDaRequisicao = dataDaRequisicao;
    }
}
