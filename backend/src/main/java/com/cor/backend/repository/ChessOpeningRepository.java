package com.cor.backend.repository;

import com.cor.backend.model.ChessOpening;
import com.cor.backend.model.enums.PlayerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChessOpeningRepository extends JpaRepository<ChessOpening, Long> {
    @Query("SELECT co from ChessOpening co WHERE :openingType = co.openingType")
    List<ChessOpening> findAllForPlayerType(@Param("openingType") PlayerType openingType);
}
