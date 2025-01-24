package br.com.hiperlogic.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiperlogic.dslist.dto.GameListDTO;
import br.com.hiperlogic.dslist.entities.GameList;
import br.com.hiperlogic.dslist.repositories.GameListRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map( x -> new GameListDTO(x)).toList();
        return dto;
        
    }

}
