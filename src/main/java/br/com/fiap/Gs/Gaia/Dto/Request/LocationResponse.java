package br.com.fiap.Gs.Gaia.Dto.Request;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;

import java.time.LocalDate;

public record LocationResponse(Long idLocation, TypeStation state, String city, LocalDate startAccident, LocalDate endAccident, TypeStatusLocation statusLocation) {
}
