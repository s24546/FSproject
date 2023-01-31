package com.fs.client.contracts;

import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FsClient client = new FsClient(new RestTemplate());
//        client.getAllCharacters().forEach(characterDto -> System.out.println(characterDto));
//        client.getAllEpisodes().forEach(episodeDto -> System.out.println(episodeDto));
//        client.getAllLocations().forEach(locationDto -> System.out.println(locationDto));
          getCharacters(client);
          getEpisodes(client);
          getLocations(client);
    }

    public static List<CharacterDto> getCharacters(FsClient fsClient) {
        List<CharacterDto> resultCharacters = fsClient.getAllCharacters();
        return resultCharacters;
    }
    public static List<EpisodeDto> getEpisodes(FsClient fsClient) {
        List<EpisodeDto> resultEpisodes = fsClient.getAllEpisodes();
        return resultEpisodes;
    }
    public static List<LocationDto> getLocations(FsClient fsClient) {
        List<LocationDto> resultLocations = fsClient.getAllLocations();
        return resultLocations;
    }
}