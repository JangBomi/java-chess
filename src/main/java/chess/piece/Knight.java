package chess.piece;

import chess.Position;
import chess.Team;

import java.util.List;

public class Knight extends Piece {
    private static final String BLACK_NAME = "N";
    private static final String WHITE_NAME = "n";

    public Knight(Position position, Team team) {
        super(position, team);
    }

    @Override
    public boolean isMovable(Position position) {
        return this.position.isKnightDirection(position);
    }

    @Override
    public String getName() {
        if (Team.BLACK.equals(team)) {
            return BLACK_NAME;
        }
        return WHITE_NAME;
    }

    @Override
    public List<Position> getIntervalPosition(Piece targetPiece) {
        return null;
    }
}
