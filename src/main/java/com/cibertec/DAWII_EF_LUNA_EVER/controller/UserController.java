package com.cibertec.DAWII_EF_LUNA_EVER.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.DAWII_EF_LUNA_EVER.model.User;
import com.cibertec.DAWII_EF_LUNA_EVER.service.UserService;

@RestController
@RequestMapping("/url/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/listaUser")
	@ResponseBody
	public ResponseEntity<List<User>> list(){
		
		return new ResponseEntity<>(userService.list(), HttpStatus.OK);
	}
	
	@PostMapping("/registraUser")
	@ResponseBody
	public ResponseEntity<User> add(@RequestBody User u) {
		return new ResponseEntity<>(userService.add(u), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaUser")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody User u) {
	    Map<String, Object> response = new HashMap<>();

	    try {
	        // Verificar si el usuario existe en la base de datos
	        User existingUser = userService.getUserByID(u.getId());
	        if (existingUser == null) {
	            response.put("error", "El usuario con ID " + u.getId() + " no existe");
	            return ResponseEntity.badRequest().body(response);
	        }

	        // Verificar si algún atributo importante ha cambiado
	        if (!isEqual(existingUser.getUsername(), u.getUsername()) ||
	            !isEqual(existingUser.getName(), u.getName()) ||
	            !isEqual(existingUser.getLastname(), u.getLastname()) ||
	            !isEqual(existingUser.getEmail(), u.getEmail())) {
	            // Realizar la actualización del usuario
	            User updatedUser = userService.update(u);
	            response.put("message", "Usuario actualizado con éxito");
	            response.put("user", updatedUser);
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("message", "No se realizaron cambios en el usuario");
	            return ResponseEntity.ok(response);
	        }
	    } catch (Exception e) {
	        response.put("error", "Hubo un error al actualizar el usuario");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	// Método para comparar dos objetos y verificar si son iguales
	private boolean isEqual(Object obj1, Object obj2) {
	    return Objects.equals(obj1, obj2);
	}
	
	@DeleteMapping("/eliminaUser/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
