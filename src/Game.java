public class Game {
    
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private boolean gameOver;
    
    public Game(Board board, Player playerX, Player playerO) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX; 
        this.gameOver = false;
    }
    
    public void start() {
        board.resetBoard();  
        this.gameOver = false; 
    }
    
    public boolean makeMove(int row, int col) {
        if (!board.isCellEmpty(row, col)) {
            System.out.println("You can't choose this cell");
            return false;
        }
        
        board.setCell(row, col, currentPlayer.getSymbol());
        
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
    
    public void switchTurn() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public String getWinner() {
        if (gameOver && board.checkWin(currentPlayer.getSymbol())) {
            return currentPlayer.getName();
        }
        return null;
    }
    
    public void printBoard() {
        board.printBoard();
    }
}
