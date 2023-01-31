package com.fs.data.repositories;

import com.fs.data.model.Episodes;
import com.fs.data.model.Locations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EpisodeRepository extends CrudRepository<Episodes,Long> {
    Optional<Episodes> findById(Long id);
    List<Episodes> findAllByName(String name);
    List<Episodes>  findAllByAirDate(String airDate);
    List<Episodes>  findAllByDirector(String director);
    List<Episodes> findAllByWriter(String writer);



}
