package org.example.crudgeneral.repository;

import org.example.crudgeneral.models.UserTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<UserTables, Integer>, CrudRepository<UserTables, Integer> {
}
