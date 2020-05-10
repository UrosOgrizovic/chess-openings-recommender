package com.cor.backend.service;

import com.cor.backend.model.ChessGame;
import com.cor.backend.model.dto.ChessGameDTO;
import com.cor.backend.model.enums.PlayerType;
import com.cor.backend.repository.ChessGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessGameService {
    @Autowired
    private ChessGameRepository chessGameRepository;

    public ChessGame create(ChessGameDTO chessGameDTO) {
        ChessGame cg = new ChessGame();
        cg.setGameType(PlayerType.valueOf(chessGameDTO.getGameType()));
        cg.setPgn(chessGameDTO.getPgn());
        return this.chessGameRepository.save(cg);
    }

    public List<ChessGame> findAll() {
        return this.chessGameRepository.findAll();
    }

    public List<ChessGame> findAllForPlayerType(PlayerType playerType) {
        return this.chessGameRepository.findAllForPlayerType(playerType);
    }

}
