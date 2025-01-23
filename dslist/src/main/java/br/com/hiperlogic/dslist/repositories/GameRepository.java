package br.com.hiperlogic.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hiperlogic.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
