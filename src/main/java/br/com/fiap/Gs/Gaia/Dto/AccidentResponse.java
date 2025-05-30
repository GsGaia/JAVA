package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeAccident;
import br.com.fiap.Gs.Gaia.Enum.TypeSeverity;

import java.time.LocalDate;

public record AccidentResponse(Long idAccident, LocalDate dateAccidentStart, LocalDate dateAccidentEnd, TypeAccident typeAccident, TypeSeverity severityAccident, Long locationId) {}
