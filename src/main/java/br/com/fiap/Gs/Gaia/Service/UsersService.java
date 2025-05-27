package br.com.fiap.Gs.Gaia.Service;

import br.com.fiap.Gs.Gaia.Models.Users;
import br.com.fiap.Gs.Gaia.Repository.UsersRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Users create(Users users) {
        return usersRepository.save(users);
    }

    @Transactional
    public List<Users> readAll() {
        return usersRepository.findAll();
    }

    @Transactional
    public Optional<Users> readById(Long id) {
        return usersRepository.findById(id);
    }

    @Transactional
    public Optional<Users> update(Long id, Users updatedUser) {
        return usersRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            return usersRepository.save(user);
        });
    }

    @Transactional
    public boolean delete(Long id) {
        return usersRepository.findById(id).map(user -> {
            usersRepository.deleteById(id);
            return true;
        }).orElse(false);
    }


}
