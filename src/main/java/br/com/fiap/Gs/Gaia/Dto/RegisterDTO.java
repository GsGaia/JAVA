package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank String name,
        @NotBlank String password,
        @NotBlank String cpf,
        @NotBlank String email,
        @NotNull TypeUsers role
) {
}
