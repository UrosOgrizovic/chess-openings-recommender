package com.cor.backend.repository;

import com.cor.backend.model.ChessGame;
import com.cor.backend.model.enums.PlayerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChessGameRepository extends JpaRepository<ChessGame, Long> {
    @Query("SELECT cg from ChessGame cg WHERE :gameType = cg.gameType")
    List<ChessGame> findAllForPlayerType(@Param("gameType") PlayerType gameType);
}
