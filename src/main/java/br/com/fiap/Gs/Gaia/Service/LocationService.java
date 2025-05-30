package br.com.fiap.Gs.Gaia.Service;

import br.com.fiap.Gs.Gaia.Dto.LocationRequest;
import br.com.fiap.Gs.Gaia.Dto.LocationResponse;
import br.com.fiap.Gs.Gaia.Dto.RequestionResponse;
import br.com.fiap.Gs.Gaia.Models.Location;
import br.com.fiap.Gs.Gaia.Models.Requestion;
import br.com.fiap.Gs.Gaia.Repository.LocationRepository;
import br.com.fiap.Gs.Gaia.Repository.RequestionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final RequestionRepository requestionRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, RequestionRepository requestionRepository) {
        this.locationRepository = locationRepository;
        this.requestionRepository = requestionRepository;
    }

    public LocationResponse create(@Valid LocationRequest request) {
        Location location = new Location();
        location.setCity(request.getCity());
        location.setStartAccident(request.getStartAccident());
        location.setEndAccident(request.getEndAccident());
        location.setState(request.getState());
        location.setStatusLocation(request.getStatusLocation());

        Location saved = locationRepository.save(location);

        return new LocationResponse(
                saved.getCity(),
                saved.getStartAccident(),
                saved.getEndAccident(),
                saved.getState(),
                saved.getStatusLocation()
        );
    }

    public List<LocationResponse> getAll() {
        return locationRepository.findAll().stream()
                .map(loc -> new LocationResponse(
                        loc.getCity(),
                        loc.getStartAccident(),
                        loc.getEndAccident(),
                        loc.getState(),
                        loc.getStatusLocation()
                )).collect(Collectors.toList());
    }

    public Optional<LocationResponse> getById(Long id) {
        return locationRepository.findById(id)
                .map(loc -> new LocationResponse(
                        loc.getCity(),
                        loc.getStartAccident(),
                        loc.getEndAccident(),
                        loc.getState(),
                        loc.getStatusLocation()
                ));
    }

    @Transactional
    public void delete(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Localização com ID " + id + " não encontrada."));

        List<Requestion> relacionadas = requestionRepository.findByLocation(location);
        for (Requestion r : relacionadas) {
            r.setLocation(null);
        }

        locationRepository.delete(location);
    }


    public LocationResponse update(Long id, LocationRequest request) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Localização não encontrada"));

        location.setCity(request.getCity());
        location.setStartAccident(request.getStartAccident());
        location.setEndAccident(request.getEndAccident());
        location.setState(request.getState());
        location.setStatusLocation(request.getStatusLocation());

        Location updated = locationRepository.save(location);

        return new LocationResponse(
                updated.getCity(),
                updated.getStartAccident(),
                updated.getEndAccident(),
                updated.getState(),
                updated.getStatusLocation()
        );
    }
}
