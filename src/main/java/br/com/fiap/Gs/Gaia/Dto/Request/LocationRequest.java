package br.com.fiap.Gs.Gaia.Dto.Request;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class LocationRequest {
    @NotNull
    @Size(min = 2, max = 50, message = "O nome da cidade está fora dos padrões")
    private String city;

    private LocalDate startAccident;
    private LocalDate endAccident;

    @NotEmpty
    private TypeStation state;

    @NotEmpty
    private TypeStatusLocation statusLocation;

}
