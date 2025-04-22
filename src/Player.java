public class Player {

    String name;
    char playerSymbol;

    public Player(String name,char playerSymbol){
        this.name = name;
        this.playerSymbol = playerSymbol;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setSymbol(char playerSymbol){
        this.playerSymbol = playerSymbol;
    }

    public String getName(){
        return this.name;
    }

    public char getSymbol(){
        return this.playerSymbol;
    }


}
