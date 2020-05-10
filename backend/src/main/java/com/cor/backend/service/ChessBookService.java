package com.cor.backend.service;

import com.cor.backend.model.ChessBook;
import com.cor.backend.model.Player;
import com.cor.backend.model.enums.PlayerType;
import com.cor.backend.repository.ChessBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessBookService {
    @Autowired
    private ChessBookRepository chessBookRepository;

    public List<ChessBook> findAllForPlayerType(PlayerType playerType) {
        return this.chessBookRepository.findAllForPlayerType(playerType);
    }
}
