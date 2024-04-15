import java.util.Random;

public class Dice {
    int diceCount;
    int min=1;
    int max=6;
    public Dice(int diceCount){
        this.diceCount=diceCount;
    }
    public int rollDice(){
        int diceUsed=1;
        int totalSum=0;
        while(diceUsed<=diceCount){
            totalSum+=min+(new Random().nextInt(max-min+1));
            diceUsed++;
        }
        return totalSum;
    }
}
