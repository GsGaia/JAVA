package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;

import java.time.LocalDate;

public record LocationResponse(String city, LocalDate startAccident, LocalDate endAccident, TypeStation state, TypeStatusLocation statusLocation) {
}
