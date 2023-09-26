package edu.my.wallet.controllers;

import edu.my.wallet.controllers.dto.UserCreate;
import edu.my.wallet.controllers.dto.UserDto;
import edu.my.wallet.services.UserService;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * this {@link RestController} represents our <b>Facade</b>, because it
 * abstracts all complexity of integrations (H2 Database and awesome API) in a
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

  /** This method is responsible for saving a new user in the database.
   *
   * @param user {@link UserCreate} object
   * @return {@link ResponseEntity} with {@link UserDto} object
   */
  @PostMapping()
  public ResponseEntity<UserDto> save(@RequestBody UserCreate user) {
    userService.save(user.toUser());
    UserDto userDto = new UserDto(
        user.toUser().getUsername(),
        user.toUser().getEmail(),
        user.toUser().getImageUrl()
    );
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(user.toUser().getId())
        .toUri();
    return ResponseEntity.created(location).body(userDto);
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
