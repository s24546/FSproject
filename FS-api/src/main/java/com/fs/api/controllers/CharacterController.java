package com.fs.api.controllers;

import com.fs.api.services.CharacterService;
import com.fs.data.model.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RequestMapping("character")
@Controller
public class CharacterController {
    CharacterService characterService;
    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
    @GetMapping("show")
    public String showCharacters(Model model){
        List<Characters> charactersList = (List<Characters>) characterService.findAll();
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
    public ResponseEntity <List<Object>> getCharactersByGender(@PathVariable String gender) {
        var characters = characterService.getCharactersByGender(gender);
        if (characters.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

    }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }
    @GetMapping("byname/{name}")
    public ResponseEntity <List<Object>> getCharacterByName(@PathVariable String name) {
        var characters = characterService.getCharacterByName(name);
        if (characters.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }
    @GetMapping("bystatusandgender/{status}/{gender}")
    public ResponseEntity <List<Object>>  getCharacterByStatusAndGender(@PathVariable String status,@PathVariable String gender) {     ///listaaaa
        var characters = characterService.getCharacterByStatusAndGender(status,gender);
        if (characters.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }
    @GetMapping("byhair/{hair}")
    public ResponseEntity <List<Object>> getCharacterByHair(@PathVariable String hair) {     ///listaaaa
        var characters = characterService.getCharacterByHair(hair);
        if (characters.isEmpty())
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Arrays.asList(characters.toArray()), HttpStatus.OK);
    }
    @PatchMapping(value = "update/{id}")
    public String updateCharacterById(@RequestBody Characters character, @PathVariable long id){
        if(characterService.getCharacterById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterService.updateCharacterById(id,character);
        return "form";
    }
    @GetMapping("delete/form")
    public String deleteCharacterForm(Model model, Long id){
        model.addAttribute("characters", id);
        return "del1";
    }
    @PostMapping("delete")
    public String submitDeleteForm (@ModelAttribute Characters character){
        characterService.delete(character);
        return "redirect:/character/show";
    }

}



