package br.com.fiap.Gs.Gaia.Models;

import java.time.LocalDate;

public class Requestion {

    private Long idRequestion;

    private String title;
    private String description;
    private String unit;

    private LocalDate dataDaRequisicao;

    private User user;
}
