package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeAccident;
import br.com.fiap.Gs.Gaia.Enum.TypeSeverity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccident;


    private LocalDate dateAccidentStart;
    private LocalDate dateAccidentEnd;

    private TypeAccident typeAccident;
    private TypeSeverity severityAccident;

    private Long locationId; // novo campo

    @OneToOne
    @JoinColumn(name = "id_location")
    private Location location;

    public Accident() {
    }

    public Accident(Long idAccident, LocalDate dateAccidentStart, LocalDate dateAccidentEnd, TypeAccident typeAccident, TypeSeverity severityAccident, Long locationId, Location location) {
        this.idAccident = idAccident;
        this.dateAccidentStart = dateAccidentStart;
        this.dateAccidentEnd = dateAccidentEnd;
        this.typeAccident = typeAccident;
        this.severityAccident = severityAccident;
        this.locationId = locationId;
        this.location = location;
    }

    public Long getIdAccident() {
        return idAccident;
    }

    public void setIdAccident(Long idAccident) {
        this.idAccident = idAccident;
    }

    public LocalDate getDateAccidentStart() {
        return dateAccidentStart;
    }

    public void setDateAccidentStart(LocalDate dateAccidentStart) {
        this.dateAccidentStart = dateAccidentStart;
    }

    public LocalDate getDateAccidentEnd() {
        return dateAccidentEnd;
    }

    public void setDateAccidentEnd(LocalDate dateAccidentEnd) {
        this.dateAccidentEnd = dateAccidentEnd;
    }

    public TypeAccident getTypeAccident() {
        return typeAccident;
    }

    public void setTypeAccident(TypeAccident typeAccident) {
        this.typeAccident = typeAccident;
    }

    public TypeSeverity getSeverityAccident() {
        return severityAccident;
    }

    public void setSeverityAccident(TypeSeverity severityAccident) {
        this.severityAccident = severityAccident;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
