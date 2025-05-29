package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import br.com.fiap.Gs.Gaia.Models.Requestion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record UsersResponse(Long idUser, String name, String email, String password, String cpf, LocalDateTime creationDate, TypeUsers role, Boolean activeUser, List<Requestion> requestions) {
}
