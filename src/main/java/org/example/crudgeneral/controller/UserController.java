package org.example.crudgeneral.controller;


import org.example.crudgeneral.dto.UserDTO;
import org.example.crudgeneral.rootSercice.UserRootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRootService userRootService;


    // Ma'lumotni bazaga yo'llovchi qism
    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveToBase(@RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = userRootService.createUsers(userDTO);
        return ResponseEntity.ok(userDTO1);
    }

    // Ma'lumotni hammasini olish qismi
    @GetMapping("/takes")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> getUsers = userRootService.getAllUsers();
        return ResponseEntity.ok(getUsers);
    }

    // Bazadan id bilan oslish qismi
    @GetMapping("/take/{ids}")
    public ResponseEntity<UserDTO> takeWithId(@PathVariable(value = "ids") int ids) {
        UserDTO userDTO = userRootService.getUserById(ids);
        return (userDTO != null) ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
    }

    // Bazadagi ma'lumotlarni o'zgartirish qismi bilan ishlash
    @PutMapping("/update/{ids}")
    public ResponseEntity<UserDTO> updateUsers(@PathVariable(value = "ids") int ids, @RequestBody UserDTO userDTO) {
        UserDTO getWithId = userRootService.updateUsers(ids, userDTO);
        return (getWithId != null) ? ResponseEntity.ok(getWithId) : ResponseEntity.notFound().build();
    }

    // Id bilan o'chirish qismi
    @DeleteMapping("/delete/{ids}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "ids") int ids) {
        userRootService.deleteUser(ids);
        return ResponseEntity.noContent().build();
    }

}
