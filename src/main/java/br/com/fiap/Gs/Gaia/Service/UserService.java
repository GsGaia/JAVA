package br.com.fiap.Gs.Gaia.Service;

import br.com.fiap.Gs.Gaia.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
   UserRepository userRepository;


}
