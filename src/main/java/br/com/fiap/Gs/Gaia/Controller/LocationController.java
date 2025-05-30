package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.LocationRequest;
import br.com.fiap.Gs.Gaia.Dto.LocationResponse;
import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import br.com.fiap.Gs.Gaia.Models.Location;
import br.com.fiap.Gs.Gaia.Models.Requestion;
import br.com.fiap.Gs.Gaia.Repository.LocationRepository;
import br.com.fiap.Gs.Gaia.Repository.RequestionRepository;
import br.com.fiap.Gs.Gaia.Service.LocationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private LocationRepository locationRepository;
    private LocationService locationService;
    private RequestionRepository requestionRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository, LocationService locationService, RequestionRepository requestionRepository) {
        this.locationRepository = locationRepository;
        this.locationService = locationService;
        this.requestionRepository = requestionRepository;
    }

    @PostMapping
    public ResponseEntity<LocationResponse> create(@RequestBody @Valid LocationRequest request) {
        return ResponseEntity.ok(locationService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> getById(@PathVariable Long id) {
        return locationService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<LocationResponse> toggleActive(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.toggleActive(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<LocationResponse> updateStatus(@PathVariable Long id, @RequestParam TypeStatusLocation status) {
        return ResponseEntity.ok(locationService.updateStatus(id, status));
    }

    @PutMapping("/{id}/datas")
    public ResponseEntity<LocationResponse> updateDates(@PathVariable Long id, @RequestParam LocalDate start, @RequestParam LocalDate end) {
        return ResponseEntity.ok(locationService.updateDates(id, start, end));
    }

    @PutMapping("/{id}/localizacao")
    public ResponseEntity<LocationResponse> updateStateAndCity(@PathVariable Long id, @RequestParam String city, @RequestParam TypeStation state) {
        return ResponseEntity.ok(locationService.updateStateAndCity(id, city, state));
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<LocationResponse>> getAtivos() {
        return ResponseEntity.ok(locationService.getAtivos());
    }

}
