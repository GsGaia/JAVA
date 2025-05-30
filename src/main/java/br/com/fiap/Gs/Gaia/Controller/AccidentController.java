package br.com.fiap.Gs.Gaia.Controller;

import br.com.fiap.Gs.Gaia.Dto.AccidentRequest;
import br.com.fiap.Gs.Gaia.Dto.AccidentResponse;
import br.com.fiap.Gs.Gaia.Enum.TypeAccident;
import br.com.fiap.Gs.Gaia.Enum.TypeSeverity;
import br.com.fiap.Gs.Gaia.Service.AccidentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/accidents")
public class AccidentController {

    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AccidentResponse> create(@RequestBody @Valid AccidentRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<AccidentResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccidentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccidentResponse> update(@PathVariable Long id, @RequestBody @Valid AccidentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Acidente deletado com sucesso.");
    }

    @PatchMapping("/{id}/type")
    public ResponseEntity<AccidentResponse> updateType(@PathVariable Long id, @RequestBody TypeAccident typeAccident) {
        return ResponseEntity.ok(service.updateTypeAccident(id, typeAccident));
    }

    @PatchMapping("/{id}/severity")
    public ResponseEntity<AccidentResponse> updateSeverity(@PathVariable Long id, @RequestBody TypeSeverity severityAccident) {
        return ResponseEntity.ok(service.updateSeverityAccident(id, severityAccident));
    }

    @PutMapping("/{id}/date-start")
    public ResponseEntity<AccidentResponse> updateDateStart(@PathVariable Long id, @RequestBody LocalDate dateAccidentStart) {
        return ResponseEntity.ok(service.updateDateAccidentStart(id, dateAccidentStart));
    }

    @PutMapping("/{id}/date-end")
    public ResponseEntity<AccidentResponse> updateDateEnd(@PathVariable Long id, @RequestBody LocalDate dateAccidentEnd) {
        return ResponseEntity.ok(service.updateDateAccidentEnd(id, dateAccidentEnd));
    }

}