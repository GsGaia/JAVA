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
        Users user = usersRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new EntityNotFoundException("Localização não encontrada"));

        Requestion req = new Requestion();
        req.setTitle(request.getTitle());
        req.setDescription(request.getDescription());
        req.setUnit(request.getUnit());
        req.setDataDaRequisicao(request.getDataDaRequisicao());
        req.setActiveRequestion(true);
        req.setUsers(user);
        req.setLocation(location);

        Requestion saved = requestionRepository.save(req);

        return new RequestionResponse(
                saved.getTitle(),
                saved.getDescription(),
                saved.getUnit(),
                saved.getDataDaRequisicao()
        );
    }

    public List<RequestionResponse> getAll() {
        return requestionRepository.findAll().stream()
                .map(req -> new RequestionResponse(
                        req.getTitle(),
                        req.getDescription(),
                        req.getUnit(),
                        req.getDataDaRequisicao()
                )).collect(Collectors.toList());
    }

    public Optional<RequestionResponse> getById(Long id) {
        return requestionRepository.findById(id)
                .map(req -> new RequestionResponse(
                        req.getTitle(),
                        req.getDescription(),
                        req.getUnit(),
                        req.getDataDaRequisicao()
                ));
    }

    public void delete(Long id) {
        if (!requestionRepository.existsById(id)) {
            throw new EntityNotFoundException("Requisição não encontrada");
        }
        requestionRepository.deleteById(id);
    }

    public RequestionResponse update(Long id, RequestionRequest request) {
        Requestion req = requestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requisição não encontrada"));

        Users user = usersRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new EntityNotFoundException("Localização não encontrada"));

        req.setTitle(request.getTitle());
        req.setDescription(request.getDescription());
        req.setUnit(request.getUnit());
        req.setDataDaRequisicao(request.getDataDaRequisicao());
        req.setUsers(user);
        req.setLocation(location);

        Requestion updated = requestionRepository.save(req);

        return new RequestionResponse(
                updated.getTitle(),
                updated.getDescription(),
                updated.getUnit(),
                updated.getDataDaRequisicao()
        );
    }
}
