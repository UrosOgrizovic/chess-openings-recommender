package com.cor.backend.repository;

import com.cor.backend.model.ChessGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChessGameRepository extends JpaRepository<ChessGame, Long> {

}
