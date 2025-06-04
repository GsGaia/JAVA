package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;

    private TypeStation state;
    private String city;
    private LocalDate startAccident;
    private LocalDate endAccident;
    private TypeStatusLocation statusLocation;
    private Boolean active;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Requestion> requestions = new ArrayList<>();

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private Accident accident;

    public Location() {
    }

    public Location(Long idLocation, TypeStation state, String city, LocalDate startAccident, LocalDate endAccident, TypeStatusLocation statusLocation, Boolean active, List<Requestion> requestions, Accident accident) {
        this.idLocation = idLocation;
        this.state = state;
        this.city = city;
        this.startAccident = startAccident;
        this.endAccident = endAccident;
        this.statusLocation = statusLocation;
        this.active = active;
        this.requestions = requestions;
        this.accident = accident;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public TypeStation getState() {
        return state;
    }

    public void setState(TypeStation state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStartAccident() {
        return startAccident;
    }

    public void setStartAccident(LocalDate startAccident) {
        this.startAccident = startAccident;
    }

    public LocalDate getEndAccident() {
        return endAccident;
    }

    public void setEndAccident(LocalDate endAccident) {
        this.endAccident = endAccident;
    }

    public TypeStatusLocation getStatusLocation() {
        return statusLocation;
    }

    public void setStatusLocation(TypeStatusLocation statusLocation) {
        this.statusLocation = statusLocation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Requestion> getRequestions() {
        return requestions;
    }

    public void setRequestions(List<Requestion> requestions) {
        this.requestions = requestions;
    }

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }
}
