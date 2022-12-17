package com.chess.engine.board;

import com.chess.engine.pieces.chessPiece;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class chessTile {
    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for(int i=0; i<64; i++) {
            emptyTileMap.put(i,new EmptyTile(i));
        }
        Collections.unmodifiableMap(emptyTileMap);
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static chessTile createTile(final int tileCoordinate, final chessPiece piece){
    return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    private chessTile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }
    public abstract boolean isTileOccupied();
    public abstract chessPiece getPiece();
    public static final class EmptyTile extends chessTile{
        private EmptyTile(final int coordinate){
            super(coordinate);
        }
        @Override
        public boolean isTileOccupied(){
            return false;

        }
        @Override
        public chessPiece getPiece(){
            return null;
        }
    }

    public static final class OccupiedTile extends chessTile{
        private final chessPiece pieceOnTile;
        private OccupiedTile(int tileCoordinate,chessPiece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public chessPiece getPiece(){
            return this.pieceOnTile;

        }

    }
}
