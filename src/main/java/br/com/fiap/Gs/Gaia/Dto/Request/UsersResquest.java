package br.com.fiap.Gs.Gaia.Dto.Request;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class UsersResquest {

    @NotNull
    @Size(min = 3, max = 250, message = "O nome está fora dos padrões")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotNull
    @Size(min = 3, max = 30, message = "A senha está fora dos padrões")
    private String password;

    @CPF
    private String cpf;

    @FutureOrPresent
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @NotNull(message = "O tipo de usuário é obrigatório.")
    @Enumerated(EnumType.STRING)
    private TypeUsers role;

    @NotNull
    private Boolean activeUser;

}
