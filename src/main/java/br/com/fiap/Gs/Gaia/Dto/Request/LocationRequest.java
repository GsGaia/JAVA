package br.com.fiap.Gs.Gaia.Dto.Request;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class LocationRequest {
    @NotNull
    @Size(min= 2, max=50, message = "O nome da cidade está fora dos padrões")
    private String city;

    private LocalDate startAccident;
    private LocalDate endAccident;

    @NotEmpty
    private TypeStation state;

    @NotEmpty
    private TypeStatusLocation statusLocation;

    public LocationRequest() {
    }

    public LocationRequest(TypeStation state, String city, LocalDate startAccident, LocalDate endAccident, TypeStatusLocation statusLocation) {
        this.state = state;
        this.city = city;
        this.startAccident = startAccident;
        this.endAccident = endAccident;
        this.statusLocation = statusLocation;
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
}
