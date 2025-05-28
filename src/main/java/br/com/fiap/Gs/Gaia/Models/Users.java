package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import jakarta.persistence.*;

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

}
