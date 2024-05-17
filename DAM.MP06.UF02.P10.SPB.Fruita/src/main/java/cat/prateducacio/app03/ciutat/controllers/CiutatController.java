package cat.prateducacio.app03.ciutat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.prateducacio.app03.ciutat.model.domain.Ciutat;
import cat.prateducacio.app03.ciutat.model.service.ICiutatService;

import java.util.List;

@RestController
@RequestMapping("/ciutats")
public class CiutatController {

    @Autowired
    private ICiutatService ciutatService;

    // Obtener todas las ciudades
    @GetMapping
    public ResponseEntity<List<Ciutat>> getAllCiutats() {
        return new ResponseEntity<>(ciutatService.findAll(), HttpStatus.OK);
    }

    // Obtener una ciudad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ciutat> getCiutatById(@PathVariable int id) {
        Ciutat ciutat = ciutatService.findById(id);
        return ciutat != null ? ResponseEntity.ok(ciutat) : ResponseEntity.notFound().build();
    }

    // Crear una nueva ciudad
    @PostMapping
    public ResponseEntity<Ciutat> createCiutat(@RequestBody Ciutat ciutat) {
        return new ResponseEntity<>(ciutatService.save(ciutat), HttpStatus.CREATED);
    }

    // Actualizar una ciudad existente
    @PutMapping("/{id}")
    public ResponseEntity<Ciutat> updateCiutat(@PathVariable int id, @RequestBody Ciutat ciutat) {
        Ciutat existingCiutat = ciutatService.findById(id);
        if (existingCiutat != null) {
            ciutat.setId(id);
            return new ResponseEntity<>(ciutatService.save(ciutat), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una ciudad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiutat(@PathVariable int id) {
        Ciutat ciutat = ciutatService.findById(id);
        if (ciutat != null) {
            ciutatService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
