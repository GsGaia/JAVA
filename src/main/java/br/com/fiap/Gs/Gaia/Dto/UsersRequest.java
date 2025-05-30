package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import br.com.fiap.Gs.Gaia.Models.Requestion;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public class UsersRequest {

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

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @NotNull(message = "O tipo de usuário é obrigatório.")
    @Enumerated(EnumType.STRING)
    private TypeUsers role;

    @NotNull(message = "activeUser não pode ser nulo")
    private Boolean activeUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public TypeUsers getRole() {
        return role;
    }

    public void setRole(TypeUsers role) {
        this.role = role;
    }

    public Boolean getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Boolean activeUser) {
        this.activeUser = activeUser;
    }

    private List<Requestion> requestions;

    public List<Requestion> getRequestions() {
        return requestions;
    }

    public void setRequestions(List<Requestion> requestions) {
        this.requestions = requestions;
    }

}
