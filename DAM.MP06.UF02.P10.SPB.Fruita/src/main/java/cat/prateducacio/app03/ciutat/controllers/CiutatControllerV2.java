package cat.prateducacio.app03.ciutat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.prateducacio.app03.ciutat.model.domain.Ciutat;
import cat.prateducacio.app03.ciutat.model.service.ICiutatService;

@RestController
//http://localhost:8080/fruitav2
@RequestMapping("/fruitav2")
public class CiutatControllerV2 {

	@Autowired
	ICiutatService fruitaService;

	// http://localhost:8080/fruitav2/add
	@PostMapping("/add")
	public ResponseEntity<?> addFruita(@RequestBody Ciutat fruita) {

		ResponseEntity<?> result = null;

		try {
			Ciutat fruitaDb = fruitaService.add(fruita);
			result = ResponseEntity.status(HttpStatus.OK).body(fruitaDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/fruitav2/update
	@PutMapping("/update")
	public ResponseEntity<?> updateFruita(@RequestBody Ciutat fruita) {

		ResponseEntity<?> result = null;

		try {
			Ciutat fruitaDb = fruitaService.update(fruita);

			result = ResponseEntity.status(HttpStatus.OK).body(fruitaDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/fruitav2/delete/id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFruita(@PathVariable int id) {

		ResponseEntity<String> result = null;

		try {
			fruitaService.delete(id);

			result = ResponseEntity.status(HttpStatus.OK).body("Operació realitzada");

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;
	}

	// http://localhost:8080/fruitav2/getOne/23
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getFruita(@PathVariable int id) {

		ResponseEntity<?> result = null;

		try {
			Ciutat fruitaDb = fruitaService.findById(id);

			if (fruitaDb != null) {
				result = ResponseEntity.status(HttpStatus.OK).body(fruitaDb);
			} else {
				result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(fruitaDb);
			}

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/fruitav2/getAll
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> result = null;

		try {
			List<Ciutat> fruitaDb = fruitaService.getAll();
			result = ResponseEntity.status(HttpStatus.OK).body(fruitaDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

}
