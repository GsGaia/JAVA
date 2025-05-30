package br.com.fiap.Gs.Gaia.Service;

import br.com.fiap.Gs.Gaia.Dto.UsersRequest;
import br.com.fiap.Gs.Gaia.Dto.UsersResponse;
import br.com.fiap.Gs.Gaia.Models.Users;
import br.com.fiap.Gs.Gaia.Repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public UsersResponse create(@Valid UsersRequest usersRequest) {
        boolean emailExistente = usersRepository.findAll().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(usersRequest.getEmail()));

        boolean cpfExistente = usersRepository.findAll().stream()
                .anyMatch(u -> u.getCpf().equals(usersRequest.getCpf()));

        if (emailExistente) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        if (cpfExistente) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        Users user = new Users(
                null,
                usersRequest.getName(),
                usersRequest.getEmail(),
                usersRequest.getPassword(),
                usersRequest.getCpf(),
                usersRequest.getCreationDate().atStartOfDay(),
                usersRequest.getRole(),
                usersRequest.getActiveUser(),
                usersRequest.getRequestions()
        );

        Users savedUser = usersRepository.save(user);

        return new UsersResponse(
                savedUser.getIdUser(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getPassword(),
                savedUser.getCpf(),
                savedUser.getCreationDate(),
                savedUser.getRole(),
                savedUser.getActiveUser(),
                savedUser.getRequestions()
        );
    }


    public List<UsersResponse> getAll() {
        List<Users> usersList = usersRepository.findAll();
        System.out.println("GetAll com sucesso.\n");
        return usersList.stream()
                .map(user -> new UsersResponse(
                        user.getIdUser(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getCpf(),
                        user.getCreationDate(),
                        user.getRole(),
                        user.getActiveUser(),
                        user.getRequestions()
                ))
                .collect(Collectors.toList());
    }


    public Optional<UsersResponse> getById(Long id) {
        System.out.println("GetById com sucesso.\n");
        return usersRepository.findById(id)
                .map(user -> new UsersResponse(
                        user.getIdUser(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getCpf(),
                        user.getCreationDate(),
                        user.getRole(),
                        user.getActiveUser(),
                        user.getRequestions()
                ));
    }

    public void delete(Long id) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário com ID " + id + " não encontrado."));
        user.setActiveUser(false);
        usersRepository.save(user);
    }


    public UsersResponse update(Long id, UsersRequest usersRequest) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setName(usersRequest.getName());
        user.setEmail(usersRequest.getEmail());
        user.setPassword(usersRequest.getPassword());
        user.setCpf(usersRequest.getCpf());
        user.setCreationDate(usersRequest.getCreationDate().atStartOfDay());
        user.setRole(usersRequest.getRole());
        user.setActiveUser(usersRequest.getActiveUser());
        user.setRequestions(usersRequest.getRequestions());

        Users updatedUser = usersRepository.save(user);

        System.out.println("Update com sucesso.\n");

        return new UsersResponse(
                updatedUser.getIdUser(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getPassword(),
                updatedUser.getCpf(),
                updatedUser.getCreationDate(),
                updatedUser.getRole(),
                updatedUser.getActiveUser(),
                updatedUser.getRequestions()
        );
    }

    public UsersResponse toggleActive(Long id) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setActiveUser(!user.getActiveUser());  // inverte o valor

        Users updatedUser = usersRepository.save(user);

        System.out.println("Desativado com sucesso.\n");

        return new UsersResponse(
                updatedUser.getIdUser(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getPassword(),
                updatedUser.getCpf(),
                updatedUser.getCreationDate(),
                updatedUser.getRole(),
                updatedUser.getActiveUser(),
                updatedUser.getRequestions()
        );
    }
    public List<UsersResponse> getAtivos() {
        List<Users> usersList = usersRepository.findAll().stream()
                .filter(Users::getActiveUser)
                .collect(Collectors.toList());

        return usersList.stream()
                .map(user -> new UsersResponse(
                        user.getIdUser(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getCpf(),
                        user.getCreationDate(),
                        user.getRole(),
                        user.getActiveUser(),
                        user.getRequestions()
                ))
                .collect(Collectors.toList());
    }

    public UsersResponse updateEmail(Long id, String newEmail) {
        if (usersRepository.findAll().stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(newEmail))) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        user.setEmail(newEmail);
        Users updated = usersRepository.save(user);

        return new UsersResponse(
                updated.getIdUser(),
                updated.getName(),
                updated.getEmail(),
                updated.getPassword(),
                updated.getCpf(),
                updated.getCreationDate(),
                updated.getRole(),
                updated.getActiveUser(),
                updated.getRequestions()
        );
    }

    public UsersResponse updateSenha(Long id, String newPassword) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        user.setPassword(newPassword);
        Users updated = usersRepository.save(user);

        return new UsersResponse(
                updated.getIdUser(),
                updated.getName(),
                updated.getEmail(),
                updated.getPassword(),
                updated.getCpf(),
                updated.getCreationDate(),
                updated.getRole(),
                updated.getActiveUser(),
                updated.getRequestions()
        );
    }

}
