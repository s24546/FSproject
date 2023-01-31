package com.fs.client.contracts;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FsClient {

    public FsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;

    public List<CharacterDto> getAllCharacters() {
        CharacterDto[] characters = restTemplate.getForEntity("https://finalspaceapi.com/api/v0/character", CharacterDto[].class).getBody();
       return new ArrayList<CharacterDto>(List.of(characters));
    }
    public List<EpisodeDto> getAllEpisodes() {
        EpisodeDto[] episodes = restTemplate.getForEntity("https://finalspaceapi.com/api/v0/episode", EpisodeDto[].class).getBody();
        return new ArrayList<EpisodeDto>(List.of(episodes));
    }
    public List<LocationDto> getAllLocations() {
        LocationDto[] locations = restTemplate.getForEntity("https://finalspaceapi.com/api/v0/location", LocationDto[].class).getBody();
        return new ArrayList<LocationDto> (List.of( locations));
    }

}
