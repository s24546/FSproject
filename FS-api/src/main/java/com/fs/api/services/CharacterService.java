package com.fs.api.services;

import com.fs.client.contracts.CharacterDto;
import com.fs.data.model.Characters;
import com.fs.data.repositories.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CharacterService {
    CharacterRepository characterRepository;
    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;

    }
    public List<Characters>  getCharacterByName(String name){return characterRepository.findAllByName(name);}
    public List<Characters>  getCharacterByStatusAndGender(String status,String Gender){return characterRepository.findAllByStatusAndGender(status, Gender);}
    public List<Characters>  getCharacterByHair(String hair){return characterRepository.findAllByHair(hair);}
    public List<Characters> getCharactersByGender(String gender){return characterRepository.findAllByGender(gender);}
    public void addCharacter(Characters character) {
        characterRepository.save(character);
    }
    public List<Characters> addAllCharacters(List<Characters> characters) {
        return characterRepository.saveAll(characters);
    }
    public void delete(Characters character) { characterRepository.delete(character);}
    public List<Characters> findAll() {
        return characterRepository.findAll();
    }

}
