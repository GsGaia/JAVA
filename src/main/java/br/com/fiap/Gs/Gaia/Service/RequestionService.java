package br.com.fiap.Gs.Gaia.Service;

import br.com.fiap.Gs.Gaia.Dto.RequestionRequest;
import br.com.fiap.Gs.Gaia.Dto.RequestionResponse;
import br.com.fiap.Gs.Gaia.Models.Location;
import br.com.fiap.Gs.Gaia.Models.Requestion;
import br.com.fiap.Gs.Gaia.Models.Users;
import br.com.fiap.Gs.Gaia.Repository.LocationRepository;
import br.com.fiap.Gs.Gaia.Repository.RequestionRepository;
import br.com.fiap.Gs.Gaia.Repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestionService {

    @Autowired
    private RequestionRepository requestionRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private LocationRepository locationRepository;

    public RequestionResponse create(RequestionRequest request) {
        Users user = usersRepository.findById(request.getUserId()).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        Location location = locationRepository.findById(request.getLocationId()).orElseThrow(() -> new EntityNotFoundException("Localização não encontrada"));

        Requestion req = new Requestion();
        req.setTitle(request.getTitle());
        req.setDescription(request.getDescription());
        req.setUnit(request.getUnit());
        req.setRequestDate(request.getRequestDate());
        req.setActiveRequestion(true);
        req.setUsers(user);
        req.setLocation(location);

        Requestion saved = requestionRepository.save(req);

        System.out.println("Create com sucesso.\n");

        return new RequestionResponse(
                saved.getTitle(),
                saved.getDescription(),
                saved.getUnit(),
                saved.getRequestDate()
        );
    }

    public List<RequestionResponse> getAll() {
        System.out.println("GetAll com sucesso.\n");
        return requestionRepository.findAll().stream()
                .map(req -> new RequestionResponse(
                        req.getTitle(),
                        req.getDescription(),
                        req.getUnit(),
                        req.getRequestDate()
                )).collect(Collectors.toList());
    }

    public Optional<RequestionResponse> getById(Long id) {
        System.out.println("GetById com sucesso.\n");

        return requestionRepository.findById(id)
                .map(req -> new RequestionResponse(
                        req.getTitle(),
                        req.getDescription(),
                        req.getUnit(),
                        req.getRequestDate()
                ));
    }

    public void delete(Long id) {
        Requestion req = requestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requisição não encontrada"));

        req.setActiveRequestion(false);
        System.out.println("Deletado com sucesso.\n");
        requestionRepository.save(req);
    }


    public RequestionResponse updateTitle(Long id, String title) {
        Requestion req = requestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requisição não encontrada"));

        req.setTitle(title);
        Requestion updated = requestionRepository.save(req);

        return new RequestionResponse(updated.getTitle(), updated.getDescription(), updated.getUnit(), updated.getRequestDate());
    }

    public RequestionResponse updateDescription(Long id, String description) {
        Requestion req = requestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requisição não encontrada"));

        req.setDescription(description);
        Requestion updated = requestionRepository.save(req);

        return new RequestionResponse(updated.getTitle(), updated.getDescription(), updated.getUnit(), updated.getRequestDate());
    }

    public RequestionResponse updateUnit(Long id, String unit) {
        Requestion req = requestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requisição não encontrada"));

        req.setUnit(unit);
        Requestion updated = requestionRepository.save(req);

        return new RequestionResponse(updated.getTitle(), updated.getDescription(), updated.getUnit(), updated.getRequestDate());
    }

    public RequestionResponse updateRequestDate(Long id, LocalDate RequestDate) {
        Requestion req = requestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requisição não encontrada"));

        req.setRequestDate(RequestDate);
        Requestion updated = requestionRepository.save(req);

        return new RequestionResponse(updated.getTitle(), updated.getDescription(), updated.getUnit(), updated.getRequestDate());
    }

}
