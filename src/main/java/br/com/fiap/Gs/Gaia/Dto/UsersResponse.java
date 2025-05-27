package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;

import java.time.LocalDate;

public record UsersResponse(Long idUsers, String name, String email, String password, String cpf, LocalDate creationDate, TypeUsers role) {
}
