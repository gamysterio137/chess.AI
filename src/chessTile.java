public abstract class chessTile {

    int tileCoordinate;
    chessTile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }
    public abstract boolean isTileOccupied();
    public abstract chessPiece getPiece();
    public static final class EmptyTile extends chessTile{
        EmptyTile(int coordinate){
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
        chessPiece pieceOnTile;
        OccupiedTile(int tileCoordinate,chessPiece pieceOnTile) {
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
