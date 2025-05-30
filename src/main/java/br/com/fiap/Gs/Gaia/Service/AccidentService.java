package br.com.fiap.Gs.Gaia.Service;

import br.com.fiap.Gs.Gaia.Dto.AccidentRequest;
import br.com.fiap.Gs.Gaia.Dto.AccidentResponse;
import br.com.fiap.Gs.Gaia.Models.Accident;
import br.com.fiap.Gs.Gaia.Models.Location;
import br.com.fiap.Gs.Gaia.Repository.AccidentRepository;
import br.com.fiap.Gs.Gaia.Repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AccidentService {

    private final AccidentRepository accidentRepository;
    private final LocationRepository locationRepository;

    public AccidentService(AccidentRepository accidentRepository, LocationRepository locationRepository) {
        this.accidentRepository = accidentRepository;
        this.locationRepository = locationRepository;
    }

    public AccidentResponse create(AccidentRequest request) {
        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new EntityNotFoundException("Localização com ID " + request.getLocationId() + " não encontrada"));

        Accident accident = new Accident();
        accident.setDateAccidentStart(request.getDateAccidentStart());
        accident.setDateAccidentEnd(request.getDateAccidentEnd());
        accident.setTypeAccident(request.getTypeAccident());
        accident.setSeverityAccident(request.getSeverityAccident());
        accident.setLocation(location);

        accidentRepository.save(accident);
        return toResponse(accident);
    }


    public List<AccidentResponse> listAll() {
        return accidentRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AccidentResponse getById(Long id) {
        return accidentRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Accident not found"));
    }

    public AccidentResponse update(Long id, AccidentRequest request) {
        Accident accident = accidentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Accident not found"));

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Location not found"));

        accident.setDateAccidentStart(request.getDateAccidentStart());
        accident.setDateAccidentEnd(request.getDateAccidentEnd());
        accident.setTypeAccident(request.getTypeAccident());
        accident.setSeverityAccident(request.getSeverityAccident());
        accident.setLocation(location);

        return toResponse(accidentRepository.save(accident));
    }

    public void delete(Long id) {
        accidentRepository.deleteById(id);
    }

    private AccidentResponse toResponse(Accident accident) {
        return new AccidentResponse(
                accident.getIdAccident(),
                accident.getDateAccidentStart(),
                accident.getDateAccidentEnd(),
                accident.getTypeAccident(),
                accident.getSeverityAccident(),
                accident.getLocationId()
        );
    }
}
