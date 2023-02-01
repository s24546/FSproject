package com.fs.data.repositories;

import com.fs.data.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Locations,Long> {
    Optional<Locations> findById(Long id);
    List<Locations>  findAllByName(String name);
    List<Locations> findAllByType(String type);

}
