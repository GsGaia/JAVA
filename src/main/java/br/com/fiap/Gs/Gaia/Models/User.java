package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeUser;

import java.time.LocalDate;

public class User {
    private long idUser;

    private String name;
    private String email;
    private String password;
    private int cpf;

    private LocalDate creationDate;
    private TypeUser role;

    private Requestion requestion;
}
