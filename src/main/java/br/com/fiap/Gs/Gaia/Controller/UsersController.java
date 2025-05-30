package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.UsersRequest;
import br.com.fiap.Gs.Gaia.Dto.UsersResponse;
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
    public ResponseEntity<UsersResponse> createUser(@RequestBody @Valid UsersRequest usersRequest) {
        UsersResponse response = usersService.create(usersRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<UsersResponse>> getAllUsers() {
        List<UsersResponse> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponse> getUserById(@PathVariable Long id) {
        return usersService.getUserById(id)
                .map(userResponse -> ResponseEntity.ok(userResponse))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersResponse> updateUser(
            @PathVariable Long id,
            @RequestBody @Valid UsersRequest usersRequest) {
        UsersResponse updatedUser = usersService.updateUser(id, usersRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<UsersResponse> toggleActiveUser(@PathVariable Long id) {
        UsersResponse toggledUser = usersService.toggleActiveUser(id);
        return ResponseEntity.ok(toggledUser);
    }
}
