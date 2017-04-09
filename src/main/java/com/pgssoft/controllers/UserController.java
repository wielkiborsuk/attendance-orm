package com.pgssoft.controllers;

import com.pgssoft.dto.UserDto;
import com.pgssoft.model.User;
import com.pgssoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.pgssoft.controllers.converter.Converter.fromUserDto;
import static com.pgssoft.controllers.converter.Converter.toUserDto;

/**
 * Created by jpiecuch on 2017-02-13.
 */
@RestController
@RequestMapping(path = "/users")
@CrossOrigin
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "/")
  public Long create(@RequestBody @Valid UserDto user) {
    return userService.createuser(fromUserDto(user));
  }

  @GetMapping(path = "/{id}")
  public HttpEntity<UserDto> unique(@PathVariable(name = "id") long id) {
    User user = userService.unique(id);
    if (user != null) {
      return new ResponseEntity<>(toUserDto(user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/")
  public List<UserDto> get() {
    return userService.getStudents().stream().map(user -> toUserDto(user)).collect(Collectors.toList());
  }

  @PutMapping(path = "/{id}")
  public void update(@PathVariable(name = "id") long id, @RequestBody @Valid UserDto user) {
    userService.update(id, user.getFirstName(), user.getLastName(), user.getEmail());
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable(name = "id") long id) throws Exception {
    userService.deleteStudent(id);
  }
}