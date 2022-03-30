package chess.model.command;

import java.util.Arrays;
import java.util.List;

public class Move extends Command {

    private static final String EMPTY_DELIMITER = " ";

    public Move(String input) {
        super(input);
    }

    @Override
    public Command turnState(String input) {
        if (Command.END.equals(input)) {
            return new End(input);
        }
        if (input.contains(Command.MOVE)) {
            return new Move(input);
        }
        throw new IllegalArgumentException("command has only move or end ");
    }

    @Override
    public Command turnFinalState(String input) {
        if (Command.STATUS.equals(input)) {
            return new Status(input);
        }
        return new End(input);
    }

    @Override
    public boolean isMove() {
        return true;
    }

    @Override
    public String getSourcePosition() {
        return getCommandPosition().get(0);
    }

    @Override
    public String getTargetPosition() {
        return getCommandPosition().get(1);
    }

    private List<String> getCommandPosition() {
        String[] split = input.split(EMPTY_DELIMITER);
        validateSplit(split);
        return Arrays.asList(split[1], split[2]);
    }

    private void validateSplit(String[] split) {
        if (split.length != 3) {
            throw new IllegalArgumentException("move의 형식이 올바르지 않습니다.");
        }
    }
}
