package com.fs.api.controllers;

import com.fs.api.services.LocationService;
import com.fs.client.contracts.CharacterDto;
import com.fs.client.contracts.FsClient;
import com.fs.client.contracts.LocationDto;
import com.fs.data.model.Characters;
import com.fs.data.model.Episodes;
import com.fs.data.model.Locations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RequestMapping("location")
@Controller
public class LocationController {
LocationService locationService;
FsClient fsClient;
    @Autowired
    public LocationController(LocationService locationService, FsClient fsClient) {
        this.locationService = locationService;
        this.fsClient = fsClient;
    }
    @GetMapping("show")
    public String showLocations(Model model){
        List<Locations> locationsList = (List<Locations>) locationService.findAll();
        model.addAttribute("locations", locationsList);
        return "locations";
    }

    @GetMapping("add/form")
    public String addForm(Model model) {
        model.addAttribute("locations", new Locations());
        return "form3";
    }
    @PostMapping("add")
    public String addSubmit(@ModelAttribute Locations location) {
        locationService.addLocation(location);
        return "redirect:/location/show";
    }
    @GetMapping("update/form")
    public String updateLocationForm(Model model, Long id){
        model.addAttribute("locations", id);
        return "form6";
    }
    @PatchMapping("update")
    public String submitUpdateForm (@ModelAttribute Locations location){
       locationService.addLocation(location);
        return "redirect:/location/show";
    }
    @GetMapping("byname/{name}")
    public ResponseEntity<List<Object>> getLocationByName(@PathVariable String name) {
        var locations = locationService.getLocationByName(name);
        if (locations.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(locations.toArray()), HttpStatus.OK);
    }
    @GetMapping("bytype/{type}")
    public ResponseEntity<List<Object>> getLocationsByType(@PathVariable String type) {
        var locations = locationService.getAllLocationsByType(type);
        if (locations.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(locations.toArray()), HttpStatus.OK);
    }
    @GetMapping("delete/form")
    public String deleteEpisodeForm(Model model, Long id){
        model.addAttribute("locations", id);
        return "del3";
    }
    @PostMapping("delete")
    public String submitDeleteForm (@ModelAttribute Locations location){
        locationService.delete(location);
        return "redirect:/location/show";
    }

    @GetMapping("addAll/form")
    public String addAllForm(Model model) {
        model.addAttribute("locations", new Locations());
        return "form9";
    }

    @PostMapping("addAll")
    public String addAllSubmit() {
        List<LocationDto> LocationsDtoList = fsClient.getAllLocations();
        ModelMapper mapper = new ModelMapper();
        Locations[] asArray = mapper.map(LocationsDtoList, Locations[].class);
        locationService.addAllLocations(List.of(asArray));
        return "redirect:/location/show";
    }
}
