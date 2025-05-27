package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsers;

    private String name;
    private String email;
    private String password;
    private String cpf;

    private LocalDate creationDate;
    private TypeUsers role;

    //@OneToMany
    //@JoinColumn(name = "requestion_id")
    //private Requestion requestion;


    public Users(Long idUsers, String name, String email, String password, String cpf, LocalDate creationDate, TypeUsers role) {
        this.idUsers = idUsers;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.creationDate = creationDate;
        this.role = role;
    }

    public Long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Long idUser) {
        this.idUsers = idUser;
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
}
