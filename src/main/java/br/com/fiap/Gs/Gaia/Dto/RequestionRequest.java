package br.com.fiap.Gs.Gaia.Dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RequestionRequest {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String unit;

    @NotNull
    private LocalDate dataDaRequisicao;

    @NotNull
    private Long userId;

    @NotNull
    private Long locationId;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDate getDataDaRequisicao() { return dataDaRequisicao; }
    public void setDataDaRequisicao(LocalDate dataDaRequisicao) { this.dataDaRequisicao = dataDaRequisicao; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getLocationId() { return locationId; }
    public void setLocationId(Long locationId) { this.locationId = locationId; }
}
