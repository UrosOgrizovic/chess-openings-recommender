package com.cor.backend.repository;

import com.cor.backend.model.ChessBook;
import com.cor.backend.model.enums.PlayerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChessBookRepository extends JpaRepository<ChessBook, Long> {
    @Query("SELECT cb from ChessBook cb WHERE :bookType = cb.bookType")
    List<ChessBook> findAllForPlayerType(@Param("bookType") PlayerType bookType);

    @Query(value = "SELECT cb from ChessBook cb WHERE :title = cb.title")
    ChessBook findForTitle(@Param("title") String title);
}
