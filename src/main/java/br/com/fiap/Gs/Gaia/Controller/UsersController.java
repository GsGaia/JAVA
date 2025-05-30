package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.UsersRequest;
import br.com.fiap.Gs.Gaia.Dto.UsersResponse;
import br.com.fiap.Gs.Gaia.Enum.TypeUsers;
import br.com.fiap.Gs.Gaia.Service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<UsersResponse> create(@RequestBody @Valid UsersRequest usersRequest) {
        UsersResponse response = usersService.create(usersRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<UsersResponse>> getAll() {
        List<UsersResponse> users = usersService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/active")
    public ResponseEntity<List<UsersResponse>> getAllActive() {
        List<UsersResponse> activeUsers = usersService.getAtivos();
        return ResponseEntity.ok(activeUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponse> getById(@PathVariable Long id) {
        return usersService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usersService.delete(id);
        return ResponseEntity.ok("Usuário desativado com sucesso.");
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<UsersResponse> updateEmail(@PathVariable Long id, @RequestBody String newEmail) {
        UsersResponse updatedUser = usersService.updateEmail(id, newEmail);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<UsersResponse> updatePassword(@PathVariable Long id, @RequestBody String newPassword) {
        UsersResponse updatedUser = usersService.updateSenha(id, newPassword);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}/role")
    public ResponseEntity<UsersResponse> updateRole(@PathVariable Long id, @RequestBody TypeUsers newRole) {
        UsersResponse updatedUser = usersService.updateRole(id, newRole);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<UsersResponse> toggleActive(@PathVariable Long id) {
        UsersResponse toggledUser = usersService.toggleActive(id);
        return ResponseEntity.ok(toggledUser);
    }
}

