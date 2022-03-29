package chess.model.piece;

import chess.model.Board;
import chess.model.Position;
import chess.model.Team;
import chess.model.Turn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BishopTest {

    @Test
    @DisplayName("비숍의 진행 방향이 맞는다면 true 반환")
    void correctMove() {
        Bishop bishop = new Bishop(Position.of('a', '1'), Team.WHITE);

        assertThat(bishop.isMovable(Position.of('f', '6'))).isTrue();
    }

    @Test
    @DisplayName("비숍의 target위치에 아군 말이 없으면 움직임에 성공한다")
    void moveKingTest() {
        List<Piece> pieces = List.of(
                new Bishop(Position.of('a', '8'), Team.BLACK),
                new Pawn(Position.of('b', '7'), Team.WHITE)
        );
        Board board = Board.create(Pieces.of(pieces));
        String source = "a8";
        String target = "b7";

        assertDoesNotThrow(
                () -> board.move(source, target, new Turn(Team.BLACK))
        );
    }

    @Test
    @DisplayName("비숍의 target위치가 빈칸이면 움직임에 성공한다")
    void moveKingTest2() {
        List<Piece> pieces = List.of(
                new Bishop(Position.of('a', '8'), Team.BLACK),
                new Empty(Position.of('b', '7')),
                new Empty(Position.of('c', '6'))
        );
        Board board = Board.create(Pieces.of(pieces));
        String source = "a8";
        String target = "c6";

        assertDoesNotThrow(
                () -> board.move(source, target, new Turn(Team.BLACK))
        );
    }

    @Test
    @DisplayName("비숍의 target위치에 아군 말이 있으면 예외처리")
    void moveFailureKingTest() {
        List<Piece> pieces = List.of(
                new Bishop(Position.of('c', '6'), Team.WHITE),
                new Empty(Position.of('d', '7')),
                new Pawn(Position.of('e', '8'), Team.WHITE)
        );
        Board board = Board.create(Pieces.of(pieces));
        String source = "c6";
        String target = "e8";

        assertThatThrownBy(
                () -> board.move(source, target, new Turn(Team.WHITE))
        ).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("source와 target사이의 position들을 얻는다.")
    void getIntervalPositionTest(){
        Piece bishop = new Bishop(Position.of('h','8'),Team.BLACK);
        Piece king = new King(Position.of('e','5'),Team.BLACK);
        List<Position> intervalPosition = bishop.getIntervalPosition(king);

        assertThat(intervalPosition.contains(Position.of('f','6'))).isTrue();
        assertThat(intervalPosition.contains(Position.of('g','7'))).isTrue();
    }
}
