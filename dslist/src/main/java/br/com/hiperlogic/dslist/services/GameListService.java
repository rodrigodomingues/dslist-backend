package br.com.hiperlogic.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiperlogic.dslist.dto.GameListDTO;
import br.com.hiperlogic.dslist.entities.GameList;
import br.com.hiperlogic.dslist.projections.GameMinProjection;
import br.com.hiperlogic.dslist.repositories.GameListRepository;
import br.com.hiperlogic.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map( x -> new GameListDTO(x)).toList();
        return dto;
        
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex<destinationIndex?sourceIndex:destinationIndex;
        int max = sourceIndex>destinationIndex?sourceIndex:destinationIndex;

        for (int i = min; i<=max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }



}
