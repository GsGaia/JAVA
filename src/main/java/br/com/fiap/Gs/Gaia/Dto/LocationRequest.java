package br.com.fiap.Gs.Gaia.Dto;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class LocationRequest {
    @NotNull
    @Size(min = 2, max = 50, message = "O nome da cidade está fora dos padrões")
    private String city;

    @NotNull
    private LocalDate startAccident;

    @NotNull
    private LocalDate endAccident;

    @NotNull
    private TypeStation state;

    @NotNull
    private TypeStatusLocation statusLocation;

    @Column(name = "active")
    private Boolean active = true;


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

    public TypeStation getState() {
        return state;
    }

    public void setState(TypeStation state) {
        this.state = state;
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
}
