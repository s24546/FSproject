package com.fs.api.controllers;

import com.fs.api.services.EpisodeService;
import com.fs.data.model.Episodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("episode")
@Controller
public class EpisodeController {

EpisodeService episodeService;

@Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("show")
    public String showEpisodes(Model model){
        List<Episodes> episodesList = (List<Episodes>) episodeService.findAll();
        model.addAttribute("episodes", episodesList);
        return "episodes";
    }

    @GetMapping("add/form")
    public String addForm(Model model) {
        model.addAttribute("episodes", new Episodes());
        return "form2";
    }
    @PostMapping("add")
    public String addSubmit(@ModelAttribute Episodes episode) {
        episodeService.save(episode);
        return "redirect:/episode/show";
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateEpisodeById(@RequestBody Episodes episode, @PathVariable long id){
        if(episodeService.getEpisodeById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        episodeService.updateEpisodeById(id,episode);
        return null;
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<List<Object>> getEpisodeByName(@PathVariable String name) {
        var episodes = episodeService.getEpisodeByName(name);
        if (episodes.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(episodes.toArray()), HttpStatus.OK);
    }
    @GetMapping("/byairdate/{airDate}")
    public ResponseEntity <List<Object>> getEpisodeByAirDate(@PathVariable String airDate) {
        var episodes = episodeService.getEpisodeByAirDate(airDate);
        if (episodes.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(episodes.toArray()), HttpStatus.OK);
    }
    @GetMapping("/bydirector/{director}")
    public ResponseEntity<List<Object>> getEpisodeByDirector(@PathVariable String director) {
        var episodes = episodeService.getEpisodeByDirector(director);
        if (episodes.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(episodes.toArray()), HttpStatus.OK);
    }
    @GetMapping("/bywriter/{writer}")
    public ResponseEntity <List<Object>> getEpisodeByWriter(@PathVariable String writer) {
        var episodes = episodeService.getEpisodeByWriter(writer);
        if (episodes.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(episodes.toArray()), HttpStatus.OK);
    }
    @GetMapping("/delete/form")
    public String deleteEpisodeForm(Model model,Long id){
        model.addAttribute("episodes", id);
        return "del2";
    }
    @PostMapping("/delete")
    public String submitDeleteForm (@ModelAttribute Episodes episode){
        episodeService.delete(episode);
        return "redirect:/episode/show";
    }
}
