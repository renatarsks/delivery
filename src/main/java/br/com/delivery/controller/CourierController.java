package br.com.delivery.controller;

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

import br.com.delivery.entity.Courier;
import br.com.delivery.service.CourierService;

@RestController
@RequestMapping("/courier")
public class CourierController {
	
		@Autowired
	    private CourierService courierService;

	    @PostMapping("/include")
	    public ResponseEntity<Courier> insertCourier(@RequestBody Courier courier) {
	        Courier courierCreated = courierService.insertCourier(courier);
	        return ResponseEntity.status(HttpStatus.CREATED).body(courierCreated);
	    }
	    
	    @GetMapping("/getByCpf/{cpf}")
	    public ResponseEntity<Courier> getCourierByCpf(@PathVariable String cpf) {
	        Courier courier = courierService.getCourierByCpf(cpf);

	        if (courier != null) {
	            return ResponseEntity.ok(courier);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }

	    @GetMapping("/getAll")
	    public ResponseEntity<List<Courier>> getAllCouriers() {
	        List<Courier> couriers = courierService.getAllCouriers();
	        return ResponseEntity.ok(couriers);
	    }

	    @DeleteMapping("/delete/{cpf}")
	    public ResponseEntity<String> deleteCourier(@PathVariable String cpf) {
	        courierService.deleteCourier(cpf);
	        return ResponseEntity.ok("Courier with CPF " + cpf + " deleted successfully");
	    }

	    @PutMapping("/update/{cpf}")
	    public ResponseEntity<Courier> updateCourier(@PathVariable String cpf, @RequestBody Courier updatedCourier) {
	        
	    	Courier updatedCourierEntity = courierService.updateCourier(cpf, updatedCourier);

	        if (updatedCourierEntity != null) {
	            return ResponseEntity.ok(updatedCourierEntity);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }
	}