package br.com.hiperlogic.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hiperlogic.dslist.dto.GameMinDTO;
import br.com.hiperlogic.dslist.entities.Game;
import br.com.hiperlogic.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map( x -> new GameMinDTO(x)).toList();
        return dto;
        
    }
}
