package chess.model.command;

import java.util.Arrays;
import java.util.List;

public class Move extends Command {

    private static final String EMPTY_DELIMITER = " ";

    public Move(String input) {
        super(input);
    }

    @Override
    public List<String> getCommandPosition() {
        String[] split = input.split(EMPTY_DELIMITER);
        return Arrays.asList(split[1], split[2]);
    }

    @Override
    public Command turnState(String input) {
        if ("end".equals(input)) {
            return new End(input);
        }
        if (input.contains("move")) {
            return new Move(input);
        }
        throw new IllegalArgumentException("command has only move or end ");
    }

    public Command turnFinalState(String input) {
        if ("status".equals(input)) {
            return new Status(input);
        }
        return new End(input);
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public boolean isMove() {
        return true;
    }
}
