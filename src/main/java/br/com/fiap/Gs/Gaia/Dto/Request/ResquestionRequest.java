package br.com.fiap.Gs.Gaia.Dto.Request;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class ResquestionRequest {
    private String title;
    private String description;
    private String unit;

    @NotEmpty
    private LocalDate dataDaRequisicao;
}
