package com.fs.api.services;

import com.fs.client.contracts.FsClient;
import com.fs.data.model.Characters;
import com.fs.data.model.Episodes;
import com.fs.data.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EpisodeService {
    EpisodeRepository episodeRepository;
    @Autowired
    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
     //   client.getAllEpisodes().forEach(episodeDto -> episodeRepository.save(new Episodes(episodeDto)));
    }

    public void updateEpisodeById(long id, Episodes episode) {
        episodeRepository.save(
                episodeRepository.findById(id)
                        .get()
                        .update(episode)
        );
    }
    public Optional<Episodes> getEpisodeById(long id) {
        return episodeRepository.findById(id);
    }
    public List<Episodes> getEpisodeByName(String name) {
        return episodeRepository.findAllByName(name);
    }
    public List<Episodes> getEpisodeByAirDate(String airDate) {
        return episodeRepository.findAllByAirDate(airDate);
    }
    public List<Episodes> getEpisodeByDirector(String director) {
        return episodeRepository.findAllByDirector(director);
    }
    public List<Episodes> getEpisodeByWriter(String writter) {
        return episodeRepository.findAllByWriter(writter);
    }
    public void save(Episodes episode) {
        episodeRepository.save(episode);
    }
    public void delete(Episodes episode) { episodeRepository.delete(episode);}
    public Iterable<Episodes> findAll() {
        return episodeRepository.findAll();
    }
}
