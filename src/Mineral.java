import java.util.*;

// Mineral Class will have all the attributes that will use to let the user know what they are getting
// Minerals will have names, value, probability, rarity and its depth that will be found
// Mineral superclass will have subclasses
// Each subclasses determine its rarity
// The probability of minerals indicate the total amount of that specific mineral within a threshold

public class Mineral implements Comparable<Mineral>
{
    

    // for displaying in inventory
    private String mineralName;
    private int value;
    private String rarity;
    private int amount;
    private int tempAmount;
    // for calculating probability
    private int probability; //chance of getting mineral for rolling random
    private int minDepth; // Minimum depth that the mineral is available
    private int maxDepth; // Maximum depth that the mineral is available

    // rarity list for comparison
    private final ArrayList<String> rarityList = new ArrayList<>(Arrays.asList("Common", "Uncommon", "Rare", "Legendary","Mythical"));


    public Mineral(String mineralName, int value, String rarity, int amount, int tempAmount,
                   int probability, int minDepth, int maxDepth) {
        this.mineralName = mineralName;
        this.value = value;
        this.rarity = rarity;
        this.amount = amount;
        this.tempAmount = tempAmount;

        this.probability = probability;
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
    }
   


    public String getName(){ return mineralName;}
    public int getValue(){ return value;}
    public String getRarity(){ return rarity;}

    public void setAmount(int amount) {this.amount = amount;}
    public void addAmount(int additionalAmount) { this.amount += additionalAmount; } // increase amount when mining
    public int getAmount() {return amount;}

    public void setTempAmount(int tempAmount) {this.tempAmount = tempAmount;}
    public void addTempAmount(int additionalAmount) { this.tempAmount += additionalAmount; } // increase amount when mining
    public int getTempAmount() {return tempAmount;}

    public int getProbability()
    {
        return probability;
    }
    
    public int getMinDepth() {return minDepth;}
    public int getMaxDepth() {return maxDepth;}

    public ArrayList<String> getRarityList() {return rarityList;}
    
    @Override
    public int compareTo(Mineral other) // compare method
    {
        if (getRarityList().indexOf(this.getRarity()) < getRarityList().indexOf(other.getRarity()))
        {
            return -1;
        }
        else if (getRarityList().indexOf(this.getRarity()) > getRarityList().indexOf(other.getRarity()))
        {
            return 1;
        }
        else // if same rarity, then compare value
        {
            if (this.getValue() < other.getValue()) {return -1;}
            else if (this.getValue() > other.getValue()) {return 1;}
            else {return 0;}
        }
    }


    @Override
    public String toString()
    {
        return "\n[ "+ getName() + " ] :" + " Value =" + " $" + getValue() + ", Rarity = " + getRarity() + ", Amount = " + getAmount();  
    }
    
}


// all rarities 
class Common extends Mineral
{
    public Common(String mineralName, int value,
    int probability, int minDepth, int maxDepth)
    {
        super(mineralName, value, "Common", 1,1, probability, minDepth, maxDepth);
    }
}
class Uncommon extends Mineral
{
    public Uncommon(String mineralName, int value,
    int probability, int minDepth, int maxDepth)
    {
        super(mineralName, value, "Uncommon", 1,1, probability, minDepth, maxDepth);
    }
}
class Rare extends Mineral
{
    public Rare(String mineralName, int value,
    int probability, int minDepth, int maxDepth)
    {
        super(mineralName, value, "Rare",1,1, probability, minDepth, maxDepth);
    }
}
class Epic extends Mineral
{
    public Epic(String mineralName, int value,
    int probability, int minDepth, int maxDepth)
    {
        super(mineralName, value, "Epic",1,1, probability, minDepth, maxDepth);
    }
}
class Legendary extends Mineral
{
    public Legendary(String mineralName, int value,
    int probability, int minDepth, int maxDepth)
    {
        super(mineralName, value, "Legendary",1,1, probability, minDepth, maxDepth);
    }
}

class Mythical extends Mineral
{
    public Mythical(String mineralName, int value,
    int probability, int minDepth, int maxDepth)
    {
        super(mineralName, value, "Mythical",1,1, probability, minDepth, maxDepth);
    }
}







