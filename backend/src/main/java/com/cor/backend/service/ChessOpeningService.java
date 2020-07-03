package com.cor.backend.service;

import com.cor.backend.model.ChessOpening;
import com.cor.backend.model.enums.PlayerType;
import com.cor.backend.repository.ChessOpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessOpeningService {
    @Autowired
    private ChessOpeningRepository chessOpeningRepository;

    public List<ChessOpening> findAllForPlayerType(PlayerType playerType) {
        return this.chessOpeningRepository.findAllForPlayerType(playerType);
    }

    public List<ChessOpening> findAll() {
        return this.chessOpeningRepository.findAll();
    }
}
