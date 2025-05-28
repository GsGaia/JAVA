package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import br.com.fiap.Gs.Gaia.Models.Requestion;

import java.time.LocalDate;

public record UsersResponse(Long idUser, String name, String email, String password, String cpf, LocalDate creationDate, TypeUsers role, Boolean activeUser, Requestion requestion) {
}
