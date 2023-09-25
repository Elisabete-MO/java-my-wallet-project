package edu.my.wallet.controllers;

import edu.my.wallet.controllers.dto.UserCreate;
import edu.my.wallet.controllers.dto.UserDto;
import edu.my.wallet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this {@link RestController} represents our <b>Facade</b>, because it
 * abstracts all complexity of integrations (H2 Database and ViaCEP API) in a
 * simple and cohesive interface (REST API).
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public ResponseEntity<List<UserDto>> findAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/{username}")
  public ResponseEntity<UserDto> findByUsername(@PathVariable String username) {
    return ResponseEntity.ok(userService.findByUsername(username));
  }

  @PostMapping()
  public ResponseEntity<UserDto> save(@RequestBody UserCreate user) {
    userService.save(user.toUser());
    UserDto userDto = new UserDto(
        user.toUser().getUsername(),
        user.toUser().getEmail(),
        user.toUser().getImageUrl()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
  }

  @PutMapping()
  public ResponseEntity<UserDto> update(@RequestBody UserDto user) {
    userService.update(user);
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{username}")
  public ResponseEntity<Void> delete(@PathVariable String username) {
    userService.delete(username);
    return ResponseEntity.ok().build();
  }
}
