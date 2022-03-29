package chess.model.command;

public class Start extends Command {

    public Start(String input) {
        super(input);
    }

    @Override
    public Command turnState(String input) {
        if ("end".equals(input)) {
            return new End(input);
        }
        if (input.contains("move")) {
            return new Move(input);
        }
        throw new IllegalArgumentException("없는 명령어입니다.");
    }

    @Override
    public boolean isEnd() {
        return false;
    }

}
