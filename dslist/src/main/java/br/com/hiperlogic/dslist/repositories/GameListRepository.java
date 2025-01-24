package br.com.hiperlogic.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hiperlogic.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
