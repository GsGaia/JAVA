package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.Request.UsersResquest;
import br.com.fiap.Gs.Gaia.Dto.UsersResponse;
import br.com.fiap.Gs.Gaia.Models.Users;
import br.com.fiap.Gs.Gaia.Service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody @Valid Users user) {
        return ResponseEntity.status(201).body(usersService.create(user));
    }

    @GetMapping
    public ResponseEntity<List<Users>> readUsers() {
        return ResponseEntity.ok(usersService.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> readUsersById(@PathVariable Long id) {
        return usersService.readById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody @Valid Users usersData) {
        return usersService.update(id, usersData)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = usersService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
