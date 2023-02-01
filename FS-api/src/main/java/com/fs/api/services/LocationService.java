package com.fs.api.services;

import com.fs.client.contracts.FsClient;
import com.fs.data.model.Characters;
import com.fs.data.model.Episodes;
import com.fs.data.model.Locations;
import com.fs.data.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationService {
    LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
      //  client.getAllLocations().forEach(locationDto -> locationRepository.save(new Locations(locationDto)));
    }
//    public void updateLocationById(long id, Locations location) {
//        locationRepository.save(
//                locationRepository.findById(id)
//                        .get()
//                        .update(location)
//        );
//    }
    public Optional<Locations> getLocationById(long id) {
        return locationRepository.findById(id);
    }
    public List<Locations> getLocationByName(String name) {
        return locationRepository.findAllByName(name);
    }
    public List<Locations> getAllLocationsByType(String type) {
        return locationRepository.findAllByType(type);
    }
    public void addLocation(Locations location) {
        locationRepository.save(location);
    }
    public void delete(Locations location) { locationRepository.delete(location);}
    public Iterable<Locations> findAll() {return locationRepository.findAll();
    }
}
