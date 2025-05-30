package br.com.fiap.Gs.Gaia.Dto;

import java.time.LocalDate;

public record RequestionResponse(String title, String description, String unit, LocalDate dataDaRequisicao) {
}
