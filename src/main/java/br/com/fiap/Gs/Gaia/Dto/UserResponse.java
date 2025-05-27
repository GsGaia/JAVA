package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeUser;

import java.time.LocalDate;

public record UserResponse(Long idUsers, String name, String email, String password, int cpf, LocalDate creationDate, TypeUser role) {
}
