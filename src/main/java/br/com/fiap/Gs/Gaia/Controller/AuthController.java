package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.AuthDTO;
import br.com.fiap.Gs.Gaia.Dto.RegisterDTO;
import br.com.fiap.Gs.Gaia.Models.Users;
import br.com.fiap.Gs.Gaia.Repository.UsersRepository;
import br.com.fiap.Gs.Gaia.Service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO authDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var user = (Users) authentication.getPrincipal();
        var token = tokenService.generateToken(user);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (usersRepository.findByEmail(registerDTO.email()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }

        Users newUser = new Users();
        newUser.setName(registerDTO.name());
        newUser.setCpf(registerDTO.cpf());
        newUser.setEmail(registerDTO.email());
        newUser.setPassword(passwordEncoder.encode(registerDTO.password()));
        newUser.setRole(registerDTO.role());
        newUser.setCreationDate(LocalDateTime.now());
        newUser.setActiveUser(true);

        usersRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}