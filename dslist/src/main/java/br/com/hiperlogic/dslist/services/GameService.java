package br.com.hiperlogic.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiperlogic.dslist.dto.GameDTO;
import br.com.hiperlogic.dslist.dto.GameMinDTO;
import br.com.hiperlogic.dslist.entities.Game;
import br.com.hiperlogic.dslist.projections.GameMinProjection;
import br.com.hiperlogic.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map( x -> new GameMinDTO(x)).toList();
        return dto;
        
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId){
        Game result = gameRepository.findById(gameId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map( x -> new GameMinDTO(x)).toList();
        return dto;
        
    }

}
