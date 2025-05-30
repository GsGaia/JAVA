package br.com.fiap.Gs.Gaia.Service;

import br.com.fiap.Gs.Gaia.Dto.LocationRequest;
import br.com.fiap.Gs.Gaia.Dto.LocationResponse;
import br.com.fiap.Gs.Gaia.Dto.RequestionResponse;
import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;
import br.com.fiap.Gs.Gaia.Models.Location;
import br.com.fiap.Gs.Gaia.Models.Requestion;
import br.com.fiap.Gs.Gaia.Repository.LocationRepository;
import br.com.fiap.Gs.Gaia.Repository.RequestionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        location.setActive(request.getActive());

        Location saved = locationRepository.save(location);

        System.out.println("Create com sucesso.");

        return new LocationResponse(
                saved.getIdLocation(),
                saved.getState(),
                saved.getCity(),
                saved.getStartAccident(),
                saved.getEndAccident(),
                saved.getStatusLocation(),
                saved.getActive(),
                saved.getRequestions(),
                saved.getAccident()
        );

    }

    public List<LocationResponse> getAll() {
        System.out.println("GetAll com sucesso.");
        return locationRepository.findAll().stream()
                .map(loc -> new LocationResponse(
                        loc.getIdLocation(),
                        loc.getState(),
                        loc.getCity(),
                        loc.getStartAccident(),
                        loc.getEndAccident(),
                        loc.getStatusLocation(),
                        loc.getActive(),
                        loc.getRequestions(),
                        loc.getAccident()
                ))
                .collect(Collectors.toList());
    }

    public Optional<LocationResponse> getById(Long id) {
        System.out.println("GetById com sucesso.");
        return locationRepository.findById(id)
                .map(loc -> new LocationResponse(
                        loc.getIdLocation(),
                        loc.getState(),
                        loc.getCity(),
                        loc.getStartAccident(),
                        loc.getEndAccident(),
                        loc.getStatusLocation(),
                        loc.getActive(),
                        loc.getRequestions(),
                        loc.getAccident()
                ));
    }

    @Transactional
    public void delete(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Localização com ID " + id + " não encontrada."));

        List<Requestion> relacionadas = requestionRepository.findByLocation(location);
        for (Requestion r : relacionadas) {
            r.setLocation(null);
        }
        System.out.println("Delete com sucesso da Location.");
        locationRepository.delete(location);
    }

    public LocationResponse toggleActive(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Location not found with ID: " + id));

        boolean isActive = Boolean.TRUE.equals(location.getActive());

        location.setActive(!isActive);
        location.setStatusLocation(isActive ? TypeStatusLocation.FINALIZADA : TypeStatusLocation.BOM);

        Location saved = locationRepository.save(location);

        return new LocationResponse(
                saved.getIdLocation(),
                saved.getState(),
                saved.getCity(),
                saved.getStartAccident(),
                saved.getEndAccident(),
                saved.getStatusLocation(),
                saved.getActive(),
                saved.getRequestions(),
                saved.getAccident()
        );
    }

    public LocationResponse updateStatus(Long id, TypeStatusLocation status) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found with ID: " + id));

        location.setStatusLocation(status);

        Location saved = locationRepository.save(location);

        return new LocationResponse(
                saved.getIdLocation(),
                saved.getState(),
                saved.getCity(),
                saved.getStartAccident(),
                saved.getEndAccident(),
                saved.getStatusLocation(),
                saved.getActive(),
                saved.getRequestions(),
                saved.getAccident()
        );
    }

    public List<LocationResponse> getAtivos() {
        return locationRepository.findByActiveTrue().stream()
                .map(loc -> new LocationResponse(
                        loc.getIdLocation(),
                        loc.getState(),
                        loc.getCity(),
                        loc.getStartAccident(),
                        loc.getEndAccident(),
                        loc.getStatusLocation(),
                        loc.getActive(),
                        loc.getRequestions(),
                        loc.getAccident()
                ))
                .collect(Collectors.toList());
    }

    public LocationResponse updateStateAndCity(Long id, String city, TypeStation state) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found with ID: " + id));

        location.setCity(city);
        location.setState(state);

        Location saved = locationRepository.save(location);

        return new LocationResponse(
                saved.getIdLocation(),
                saved.getState(),
                saved.getCity(),
                saved.getStartAccident(),
                saved.getEndAccident(),
                saved.getStatusLocation(),
                saved.getActive(),
                saved.getRequestions(),
                saved.getAccident()
        );
    }

    public LocationResponse updateDates(Long id, LocalDate start, LocalDate end) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found with ID: " + id));

        location.setStartAccident(start);
        location.setEndAccident(end);

        Location saved = locationRepository.save(location);

        return new LocationResponse(
                saved.getIdLocation(),
                saved.getState(),
                saved.getCity(),
                saved.getStartAccident(),
                saved.getEndAccident(),
                saved.getStatusLocation(),
                saved.getActive(),
                saved.getRequestions(),
                saved.getAccident()
        );
    }


}
