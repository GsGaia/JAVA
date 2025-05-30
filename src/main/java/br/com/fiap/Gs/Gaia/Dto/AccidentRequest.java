package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeAccident;
import br.com.fiap.Gs.Gaia.Enum.TypeSeverity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccidentRequest {

    @NotNull
    private LocalDate dateAccidentStart;

    @NotNull
    private LocalDate dateAccidentEnd;

    @NotNull
    private TypeAccident typeAccident;

    @NotNull
    private TypeSeverity severityAccident;

    @NotNull
    private Long locationId;

    public LocalDate getDateAccidentStart() {
        return dateAccidentStart;
    }

    public void setDateAccidentStart(LocalDate dateAccidentStart) {
        this.dateAccidentStart = dateAccidentStart;
    }

    public LocalDate getDateAccidentEnd() {
        return dateAccidentEnd;
    }

    public void setDateAccidentEnd(LocalDate dateAccidentEnd) {
        this.dateAccidentEnd = dateAccidentEnd;
    }

    public TypeAccident getTypeAccident() {
        return typeAccident;
    }

    public void setTypeAccident(TypeAccident typeAccident) {
        this.typeAccident = typeAccident;
    }

    public TypeSeverity getSeverityAccident() {
        return severityAccident;
    }

    public void setSeverityAccident(TypeSeverity severityAccident) {
        this.severityAccident = severityAccident;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
