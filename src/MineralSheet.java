import java.util.ArrayList;
import java.util.Arrays;

// This class stores all the available Minerals
// This will be extracted by the Player Class for the mining() method
// Customizable, additional minerals can be added (not with add method)

public class MineralSheet {
    
    private final ArrayList<Mineral> allMinerals = new ArrayList<>( Arrays.asList
    (
        new Common("Coal", 2,100, 0, 500),
        new Common("Copper", 5,70, 100, 600),
        new Common("Iron",10, 35, 200, 700),
        new Common("Lead", 20, 10, 300,800),

        new Uncommon("Nickel",25,100,500,1000 ),
        new Uncommon("Zinc", 30, 70, 600, 1200 ),
        new Uncommon("Aluminium", 35, 35, 700, 1400),
        new Uncommon("Silver", 50,10, 800, 1600),

        new Rare("Titanium", 100,110, 1000, 2000),
        new Rare("Platinum", 120,60, 1200, 2400),
        new Rare("Gold", 200, 15, 1400, 2600),
        new Rare("Palladium", 300,5, 1600,2800),

        new Epic("Rhodium", 500, 120, 2000, 3200),
        new Epic("Uranium", 800, 55, 2400, 3600),
        new Epic("Emerald", 1000, 10, 2600, 4000),
        new Epic("Topaz", 1500, 5, 2800, 4400),

        new Legendary("Sapphire", 2000, 130, 3200, 5000),
        new Legendary("Ruby", 3000, 60,3600, 5800),
        new Legendary("Amethyst", 4000, 15,4000, 6400),
        new Legendary("Diamond", 5000, 5, 4400, 7200),
        
        new Mythical("Blue Diamond", 6000, 1, 4800, 8000)


    ));
    
    public MineralSheet(){}; //empty constructor, main reason is to import the sheet

    public ArrayList<Mineral> getList() // return the entire sheet.
    {
        return allMinerals;
    }
}
