package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.List;

public abstract class chessPiece {
    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    chessPiece(final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance=pieceAlliance;
        this.piecePosition=piecePosition;      /*takes a position and an alliance*/
    }

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);      /*method to calculate legal moves*/

}
