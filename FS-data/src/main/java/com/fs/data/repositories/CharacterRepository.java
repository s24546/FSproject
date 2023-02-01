package com.fs.data.repositories;

import com.fs.data.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Characters,Long> {
    Optional<Characters> findById(Long id);
    List<Characters> findAllByName(String name);
    List<Characters>  findAllByStatusAndGender(String status,String gender);
    List<Characters>  findAllByHair(String hair);
    List<Characters> findAllByGender(String gender);
}
