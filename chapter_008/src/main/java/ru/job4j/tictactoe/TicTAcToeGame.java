package ru.job4j.tictactoe;

public class TicTAcToeGame {

    private final Game game;

    private final ConsoleView consoleView = new ConsoleView();

    private final Controller controller = new Controller();

    public TicTAcToeGame(Game game) {
        this.game = game;
    }

    /**
     * Start the game.
     */
    public void start() {
        boolean isContinue = true;
        Player player1 = this.game.getPlayer1();
        Player player2 = this.game.getPlayer2();
        Field gameField = this.game.getField();
        System.out.println("Игра началась!");
        while (isContinue) {
            player1.generateMove(gameField);
            this.consoleView.showField(gameField);
            if (this.controller.isWinner(gameField, player1.getFigure())) {
                System.out.printf("Победил ИГРОК:  %s\n", player1.getName());
                isContinue = false;
                continue;
            }
            if (this.controller.isFullField(gameField)) {
                System.out.println("Ничья");
                isContinue = false;
                continue;
            }
            player2.generateMove(gameField);
            this.consoleView.showField(gameField);
            if (this.controller.isWinner(gameField, player2.getFigure())) {
                System.out.printf("Победил ИГРОК: %s\n", player2.getName());
                isContinue = false;
                continue;
            }
            if (this.controller.isFullField(gameField)) {
                System.out.println("Ничья");
                isContinue = false;
            }
        }
    }

    public static void main(String[] args) {
        new TicTAcToeGame(new Game(new HumanPlayer("Roman", Figure.X),
                new ComputerPlayer("Microsoft", Figure.O), new Field())).start();
    }
}
