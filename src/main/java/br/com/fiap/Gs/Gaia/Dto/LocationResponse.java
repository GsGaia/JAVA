package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import br.com.fiap.Gs.Gaia.Models.Accident;
import br.com.fiap.Gs.Gaia.Models.Requestion;

import java.time.LocalDate;
import java.util.List;

public record LocationResponse(Long idLocation, TypeStation state, String city, LocalDate startAccident, LocalDate endAccident, TypeStatusLocation statusLocation, Boolean active, List<Requestion> requestions, Accident accident) {
}
