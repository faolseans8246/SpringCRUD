package org.example.crudgeneral.service;

import org.example.crudgeneral.dto.UserDTO;
import org.example.crudgeneral.models.UserTables;
import org.example.crudgeneral.repository.UserRepos;
import org.example.crudgeneral.rootSercice.UserRootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserRootService {

    @Autowired
    private UserRepos userRepos;

    // Jadvalga ma'lumotni saqlash qismi bilan ishlash
    @Override
    public UserDTO createUsers(UserDTO userDTO) {
        UserTables userTables = changeDtoToTable(userDTO);
        UserTables saveUsers = userRepos.save(userTables);
        return changeTableToDto(saveUsers);
    }

    // Jadvaldagi hamma ma'lumotlarni olish qismi
    @Override
    public List<UserDTO> getAllUsers() {
        return userRepos.findAll().stream().map(this::changeTableToDto).collect(Collectors.toList());
    }

    // Id bilan elementlarni tanlab olish qismi
    @Override
    public UserDTO getUserById(int ids) {
        Optional<UserTables> takeById = userRepos.findById(ids);
        return takeById.map(this::changeTableToDto).orElse(null);
    }

    // Ma'lumotlarni bazadn o'zgartirish qismi
    @Override
    public UserDTO updateUsers(int ids, UserDTO userDTO) {
        Optional<UserTables> updateById = userRepos.findById(ids);

        if (updateById.isPresent()) {
            UserTables userTables = updateById.get();

            userTables.setLogin(userDTO.getLogin());
            userTables.setParol(userDTO.getParol());
            userTables.setEmail(userDTO.getEmail());
            userTables.setAddress(userDTO.getAddress());
            userTables.setYear(userDTO.getYear());
            userTables.setDescription(userDTO.getDescription());

            UserTables saveNotes = userRepos.save(userTables);
            return changeTableToDto(saveNotes);
        }
        return null;
    }

    // ma'lumotlarni id bilan o'chirish qismi
    @Override
    public void deleteUser(int ids) {
        userRepos.deleteById(ids);
    }



    /**
     * Convert methods
     */

    // dto -> table
    private UserTables changeDtoToTable(UserDTO userDTO) {
        UserTables userTables = new UserTables();
        userTables.setId(userDTO.getId());
        userTables.setLogin(userDTO.getLogin());
        userTables.setParol(userDTO.getParol());
        userTables.setEmail(userDTO.getEmail());
        userTables.setAddress(userDTO.getAddress());
        userTables.setYear(userDTO.getYear());
        userTables.setDescription(userDTO.getDescription());

        return userTables;
    }

    // table -> dto
    private UserDTO changeTableToDto(UserTables userTables) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userTables.getId());
        userDTO.setLogin(userTables.getLogin());
        userDTO.setParol(userTables.getParol());
        userDTO.setEmail(userTables.getEmail());
        userDTO.setAddress(userTables.getAddress());
        userDTO.setYear(userTables.getYear());
        userDTO.setDescription(userTables.getDescription());

        return userDTO;
    }
}
