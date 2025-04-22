import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Game game;
    private Label statusLabel = new Label("Turn: X");

    @Override
    public void start(Stage primaryStage) {
        // 1. Istanza della tua logica esistente
        Board board = new Board();
        Player playerX = new Player("Spongebob", 'X');
        Player playerO = new Player("Patrick", 'O');
        game = new Game(board, playerX, playerO);
        game.start();

        // 2. Griglia visuale 3x3
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        Button[][] buttons = new Button[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = new Button(" ");
                btn.setMinSize(80, 80);
                final int r = row;
                final int c = col;

                btn.setOnAction(e -> {
                    if (!game.isGameOver() && btn.getText().equals(" ")) {
                        char symbol = game.getCurrentPlayer().getSymbol();
                        if (game.makeMove(r, c)) {
                            btn.setText(String.valueOf(symbol));
                            if (game.isGameOver()) {
                                String winner = game.getWinner();
                                if (winner != null) {
                                    statusLabel.setText("🏆 Winner: " + winner);
                                } else {
                                    statusLabel.setText("🤝 It's a draw!");
                                }
                            } else {
                                statusLabel.setText("Turn: " + game.getCurrentPlayer().getSymbol());
                            }
                        }
                    }
                });

                buttons[row][col] = btn;
                grid.add(btn, col, row);
            }
        }

        // 3. Layout
        VBox root = new VBox(20, statusLabel, grid);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Tic Tac Toe");
        Image image = new Image("Tic_tac_toe.png");
        primaryStage.getIcons().add(image);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // ← importante per avviare JavaFX
    }
}
