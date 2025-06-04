package br.com.fiap.Gs.Gaia.Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "requestion")
public class Requestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequestion;

    private String title;
    private String description;
    private String unit;
    private LocalDate RequestDate;
    private Boolean activeRequestion;

    @ManyToOne
    @JoinColumn(name = "id_users")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

    public Requestion() {
    }

    public Requestion(Long idRequestion, String title, String description, String unit, LocalDate RequestDate, Boolean activeRequestion, Users users, Location location) {
        this.idRequestion = idRequestion;
        this.title = title;
        this.description = description;
        this.unit = unit;
        this.RequestDate = RequestDate;
        this.activeRequestion = activeRequestion;
        this.users = users;
        this.location = location;
    }

    public Long getIdRequestion() {
        return idRequestion;
    }

    public void setIdRequestion(Long idRequestion) {
        this.idRequestion = idRequestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDate getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(LocalDate RequestDate) {
        this.RequestDate = RequestDate;
    }

    public Boolean getActiveRequestion() {
        return activeRequestion;
    }

    public void setActiveRequestion(Boolean activeRequestion) {
        this.activeRequestion = activeRequestion;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
