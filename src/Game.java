public class Game {
    
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private boolean gameOver;
    
    // Costruttore
    public Game(Board board, Player playerX, Player playerO) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX; // il primo giocatore a giocare è il giocatore X
        this.gameOver = false;
    }
    
    // Metodo per avviare il gioco
    public void start() {
        board.resetBoard();  // Azzera la board all'inizio
        this.gameOver = false; // Imposta lo stato del gioco come in corso
    }
    
    // Metodo per fare una mossa
    public boolean makeMove(int row, int col) {
        if (!board.isCellEmpty(row, col)) {
            System.out.println("You can't choose this cell");
            return false;
        }
        
        board.setCell(row, col, currentPlayer.getSymbol());
        
        // Controlla se qualcuno ha vinto
        if (board.checkWin(currentPlayer.getSymbol())) {
            gameOver = true;
            System.out.println("The winner is " + currentPlayer.getName() + "!");
        } else if (board.isFull()) {
            System.out.println("It's a draw!");
            gameOver = true;
        } else {
            switchTurn();
        }
        
        return true;
    }
    
    // Metodo per cambiare il turno
    public void switchTurn() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
    
    // Metodo per verificare se il gioco è finito
    public boolean isGameOver() {
        return gameOver;
    }
    
    // Metodo per ottenere il giocatore corrente
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    // Metodo per ottenere il vincitore
    public String getWinner() {
        if (gameOver && board.checkWin(currentPlayer.getSymbol())) {
            return currentPlayer.getName();
        }
        return null;
    }
    
    // Metodo per stampare la board
    public void printBoard() {
        board.printBoard();
    }
}
