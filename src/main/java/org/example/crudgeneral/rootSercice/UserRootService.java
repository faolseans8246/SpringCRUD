package org.example.crudgeneral.rootSercice;

import org.example.crudgeneral.dto.UserDTO;

import java.util.List;

public interface UserRootService {

    UserDTO createUsers(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(int ids);
    UserDTO updateUsers(int ids, UserDTO userDTO);
    void deleteUser(int ids);

}
