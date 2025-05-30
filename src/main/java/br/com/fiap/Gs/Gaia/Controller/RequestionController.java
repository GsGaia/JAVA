package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.RequestionRequest;
import br.com.fiap.Gs.Gaia.Dto.RequestionResponse;
import br.com.fiap.Gs.Gaia.Service.RequestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requestion")
public class RequestionController {

    @Autowired
    private RequestionService requestionService;

    @PostMapping
    public ResponseEntity<RequestionResponse> create(@RequestBody @Valid RequestionRequest request) {
        return ResponseEntity.ok(requestionService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<RequestionResponse>> getAll() {
        return ResponseEntity.ok(requestionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestionResponse> getById(@PathVariable Long id) {
        return requestionService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestionResponse> update(@PathVariable Long id, @RequestBody @Valid RequestionRequest request) {
        return ResponseEntity.ok(requestionService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        requestionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
