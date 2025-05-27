package br.com.fiap.Gs.Gaia.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Requestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequestion;

    private String title;
    private String description;
    private String unit;

    private LocalDate dataDaRequisicao;

    private User user;
}
