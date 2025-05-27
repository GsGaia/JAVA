package br.com.fiap.Gs.Gaia.Dto.Request;

import br.com.fiap.Gs.Gaia.Enum.TypeUser;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class UserResquest {
    @NotNull
    @Size(min = 3, max = 250, message = "O nome está fora dos padrões")
    private String name;

    @Email
    private String email;

    @NotNull
    @Size(min = 3, max = 30, message = "A senha está fora dos padrões")
    private String password;

    @CPF
    private int cpf;

    @FutureOrPresent
    private LocalDate creationDate;

    @NotEmpty
    private TypeUser role;

    public UserResquest() {
    }

    public UserResquest(String name, String email, String password, int cpf, LocalDate creationDate, TypeUser role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.creationDate = creationDate;
        this.role = role;
    }

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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public TypeUser getRole() {
        return role;
    }

    public void setRole(TypeUser role) {
        this.role = role;
    }
}
