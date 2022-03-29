package chess.model.piece;

import chess.model.Position;
import chess.model.Team;

import java.util.List;

public class Empty extends Piece {

    private static final String NAME = ".";
    private static final double SCORE = 0D;

    public Empty(Position position) {
        super(position, Team.NONE);
    }

    @Override
    public boolean isMovable(Position position) {
        return false;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double getScore() {
        return SCORE;
    }

    @Override
    public List<Position> getIntervalPosition(Piece targetPiece) {
        return null;
    }

    @Override
    public boolean isKill(Piece piece) {
        return false;
    }
}
