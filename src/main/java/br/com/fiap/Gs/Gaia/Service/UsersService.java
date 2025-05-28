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

}
