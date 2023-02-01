package com.fs.api.controllers;


import com.fs.api.services.CharacterService;
import com.fs.client.contracts.CharacterDto;
import com.fs.client.contracts.FsClient;
import com.fs.data.model.Characters;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("character")
@Controller
public class CharacterController {
    CharacterService characterService;
    FsClient fsClient;

    @Autowired
    public CharacterController(CharacterService characterService, FsClient fsClient) {
        this.characterService = characterService;
        this.fsClient = fsClient;
    }

    @GetMapping("show")
    public String showCharacters(Model model) {
        List<Characters> charactersList = characterService.findAll();
        model.addAttribute("characters", charactersList);
        return "characters";
    }

    @GetMapping("add/form")
    public String addForm(Model model) {
        model.addAttribute("characters", new Characters());
        return "form1";
    }

    @PostMapping("add")
    public String addSubmit(@ModelAttribute Characters character) {
        characterService.addCharacter(character);
        return "redirect:/character/show";
    }

    @GetMapping("bygender/{gender}")
    public ResponseEntity<List<Object>> getCharactersByGender(@PathVariable String gender) {
        var characters = characterService.getCharactersByGender(gender);
        if (characters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }

    @GetMapping("byname/{name}")
    public ResponseEntity<List<Object>> getCharacterByName(@PathVariable String name) {
        var characters = characterService.getCharacterByName(name);
        if (characters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }

    @GetMapping("bystatusandgender/{status}/{gender}")
    public ResponseEntity<List<Object>> getCharacterByStatusAndGender(@PathVariable String status, @PathVariable String gender) {     ///listaaaa
        var characters = characterService.getCharacterByStatusAndGender(status, gender);
        if (characters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }

    @GetMapping("byhair/{hair}")
    public ResponseEntity<List<Object>> getCharacterByHair(@PathVariable String hair) {
        var characters = characterService.getCharacterByHair(hair);
        if (characters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }

    @GetMapping("update/form")
    public String updateCharacterForm(Model model, Long id) {
        model.addAttribute("characters", id);
        return "form4";
    }

    @PostMapping("update")
    public String submitUpdateForm(@ModelAttribute Characters character) {
        characterService.addCharacter(character);
        return "redirect:/character/show";
    }

    @GetMapping("delete/form")
    public String deleteCharacterForm(Model model, Long id) {
        model.addAttribute("characters", id);
        return "del1";
    }

    @PostMapping("delete")
    public String submitDeleteForm(@ModelAttribute Characters character) {
        characterService.delete(character);
        return "redirect:/character/show";
    }

    @GetMapping("addAll/form")
    public String addAllForm(Model model) {
        model.addAttribute("characters", new Characters());
        return "form7";
    }

    @PostMapping("addAll")
    public String addAllSubmit() {
        List<CharacterDto> CharactersDtoList = fsClient.getAllCharacters();
        ModelMapper mapper = new ModelMapper();
        Characters[] asArray = mapper.map(CharactersDtoList, Characters[].class);
        characterService.addAllCharacters(List.of(asArray));
        return "redirect:/character/show";
    }

}




