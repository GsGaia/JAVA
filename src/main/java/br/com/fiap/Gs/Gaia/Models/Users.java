package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String name;
    private String email;
    private String password;
    private String cpf;

    private LocalDateTime creationDate;
    private TypeUsers role;
    private Boolean activeUser;

    @OneToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private List<Requestion> requestions = new ArrayList<>();

    public Users() {
    }

    public Users(Long idUser, String name, String email, String password, String cpf, LocalDateTime creationDate, TypeUsers role, Boolean activeUser, List<Requestion> requestions) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.creationDate = creationDate;
        this.role = role;
        this.activeUser = activeUser;
        this.requestions = requestions;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
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

    public List<Requestion> getRequestions() {
        return requestions;
    }

    public void setRequestions(List<Requestion> requestions) {
        this.requestions = requestions;
    }
}
