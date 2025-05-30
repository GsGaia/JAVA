package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.RequestionRequest;
import br.com.fiap.Gs.Gaia.Dto.RequestionResponse;
import br.com.fiap.Gs.Gaia.Service.RequestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        requestionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/title")
    public ResponseEntity<RequestionResponse> updateTitle(@PathVariable Long id, @RequestParam String title) {
        return ResponseEntity.ok(requestionService.updateTitle(id, title));
    }

    @PutMapping("/{id}/description")
    public ResponseEntity<RequestionResponse> updateDescription(@PathVariable Long id, @RequestParam String description) {
        return ResponseEntity.ok(requestionService.updateDescription(id, description));
    }

    @PutMapping("/{id}/unit")
    public ResponseEntity<RequestionResponse> updateUnit(@PathVariable Long id, @RequestParam String unit) {
        return ResponseEntity.ok(requestionService.updateUnit(id, unit));
    }

    @PutMapping("/{id}/data")
    public ResponseEntity<RequestionResponse> updateData(@PathVariable Long id, @RequestParam LocalDate dataDaRequisicao) {
        return ResponseEntity.ok(requestionService.updateDataDaRequisicao(id, dataDaRequisicao));
    }

}
