import java.util.*;
// This Player class is the core class of the game
// This class will have all the methods that indicate the actions throughout the game
// The main methods (game actions) include: mining, selling, opening inventory, upgrading, and checking status
// This class also stores user's money for upgrading purposes
// as well as storing minerals obtained

public abstract class Player 
{
    InputAndInterface ui = new InputAndInterface(); // import User Input
    private String name;
    private long money;
    private ArrayList<Mineral> inventory = new ArrayList<Mineral>(); 
    
    public Player() {} // empty constructor for main game
    public Player(String name, long money) // for testing
    {
        this.name = name;
        this.money = money;
    }
    public void setName(String name) {this.name = name;}
    public String getPlayerName() {return name;}

    public void setMoney(int money) {this.money = money;}
    public void addMoney(double ammount) {this.money += ammount ;}
    public void subMoney(double ammount) {this.money -= ammount ;}
    public long getMoney() {return money;}

    public void clearScreen()
    {
        // pseudo clear screen
        // please don't scroll up
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }
    
    // get user name input
    public void playerName()
    {   
        this.clearScreen();
        System.out.println("\n===============================================================");
        ui.title();
        System.out.println("\n===============================================================");
        boolean check = false;
        //check for any invalid inputs, like special characters or integers
        while (!check)
        {   
            boolean valid = true;
            System.out.print("\nPlease type in your name: ");
            String userInput = ui.getScannerStr();
            if (userInput.length() <= 10)
            {
                for (int i =0; i < userInput.length(); i++)
                {
                    if (!Character.isLetter(userInput.charAt(i)))
                    {   
                        valid = false;
                        System.out.println("Invalid name: Name cannot contain numbers or special characters");
                        break;
                    }
                }
            }
            else if (userInput.length() == 0)
            {
                System.out.println("Please type a name.");
            }
            else
            {
                System.out.println("Name must be <= 10 characters");
            }
            if (valid) 
            {
                check = true; // if valid, exit loop
                this.setName(userInput);
            }
            
        }
        
        System.out.println("===============================================================");
        this.clearScreen();
    }

    public ArrayList<Mineral> getInventory() {return inventory;} 
    public void openInventory() // open inventory, display currently owned minerals
    {
        this.clearScreen();
        System.out.println("\n===============================================================");
        System.out.println(getPlayerName() + "'s inventory:");

        if (!getInventory().isEmpty()) // if Inventory is not empty, print all the minerals
        {
            Collections.sort(getInventory(),Collections.reverseOrder()); // sort from rarest to most common
            
            for (Mineral m : getInventory())
            {
                System.out.println(m.toString());
            }
        }
        else 
        {
            System.out.println("\nYour inventory is looking empty, go mine some minerals.");
        }
        System.out.println("===============================================================");
    }


    public void sellAll() // sell all minerals in inventory
    {
        this.clearScreen();
        System.out.println("\n===============================================================");
        if (!getInventory().isEmpty())
        {
            long sum = 0;
            for (Mineral m : getInventory()) // go through the inventory
            {
                // add all amount * their values
                sum += m.getValue() * m.getAmount(); 
            }
            getInventory().clear(); // clear inventory
            this.addMoney(sum);

            System.out.println("\nYou have sold all Minerals and got: " + "$"+ sum);
        }
        else
        {
            System.out.println("\nYou got nothing to sell, go mine some minerals!\n");
        }
        System.out.println("===============================================================");
    }



}
class Miner extends Player
{
    private int mineLoop; // for loop, how many times it will mine per attempt
    private int depthIncrement = 50; // depth increment every upgrade
    private int lowerBound; //starting depth
    private int upperBound;  // current max depth
    private int pickaxeLevel; // upgrade to get more mineral (increase ammount)
    private int drillLevel; // upgrade to dig deeper (increase depth)

    public Miner() {} //empty constructor
    public Miner(String name, long money) { super(name,money); }

    public void setDepthIncrement(int depthIncrement) {this.depthIncrement = depthIncrement;}
    public int getDepthIncrement() {return depthIncrement;}

    public void setMineLoop(int mineLoop) {this.mineLoop = mineLoop;}
    public int getMineLoop() {return mineLoop;}

    public void setPickaxeLevel(int pickaxeLevel)  {this.pickaxeLevel = pickaxeLevel;}
    public int getPickaxeLevel() {return pickaxeLevel;}

    public void setDrillLevel(int drillLevel)  {this.drillLevel = drillLevel;}
    public int getDrillLevel()  {return drillLevel;}

    public void setLower(int lowerBound)    { this.lowerBound = lowerBound; }
    public int getLower() {return lowerBound;}

    public void setUpper(int upperBound)      { this.upperBound = upperBound; }
    public int getUpper() {return upperBound;}
    


    public void playerStats()
    {
        this.clearScreen();
        System.out.println("\n===============================================================");
        System.out.println("[ "+getPlayerName()+" ]\n");
        System.out.println("You currently have: " + "$" + getMoney());
        System.out.println("\nPickaxe level: " + getPickaxeLevel());
        System.out.println("=> You can mine the total of: "+ getMineLoop() + " minerals per attempt.");
        System.out.println("\nDrill level: " +getDrillLevel());
        System.out.println("=> You can mine to: " + getUpper() +"m.");
        System.out.println("===============================================================");
    }




    public void upgradePickaxe()
    {
        this.clearScreen();
        System.out.println("\n===============================================================");
        if (getPickaxeLevel() < 24 && getMineLoop() < 12) // max level = 24
        {
            // initial cost is 100, times 1.5 ^ ( current pickaxe level - 1 )
            double upgradeCost = 100 * (Math.pow(1.5,(getPickaxeLevel()-1)));
            System.out.println("\nUpgrade pickaxe to level " + (getPickaxeLevel() + 1) + " for: $" + upgradeCost + " ?");
            System.out.print("[Y]/[N] : ");
            String userInput = ui.getScannerStr().toLowerCase(); // get user input (yes/no)
            if(userInput.equals("y") || userInput.equals("yes"))
            {
                
                if (getMoney() >= upgradeCost)  // check if user has enough money
                {
                    setPickaxeLevel(getPickaxeLevel()+1); // increase pickaxe level
                    System.out.println("\nYou have upgraded the pickaxe to level: " + getPickaxeLevel());
                    if (getPickaxeLevel() %2 ==0) // every 2 levels, increase the loop
                    {   // ex: MineLoop = 2, user can mine 2 minerals of any type.
                        int more = getMineLoop()+1;
                        this.setMineLoop(more);
                        System.out.println("\n => You can now mine the total of " + getMineLoop() + " minerals per attempt.");
                    }
                    this.subMoney(upgradeCost); // deduct the current money
                }
                else 
                {
                    System.out.println("\nYou don't have enough money to upgrade.");
                }
            }
            else
            {
                System.out.println("\nYou did not upgrade the pickaxe.");
            }
        }
        else if (getPickaxeLevel() >= 24 && getMineLoop() < 12)
        {   
                double upgradeCost = 100 * (Math.pow(1.5,(getMineLoop()-1)));
                System.out.println("\nYou have reached max pickaxe level: "+ getPickaxeLevel());
                System.out.println("\nYou can still upgrade your * Mine Loop *.");
                System.out.println("\nUpgrade Mine Loop to level " + (getMineLoop() + 1) + " for: $" + upgradeCost + " ?");
                System.out.print("[Y]/[N] : ");
                String userInput = ui.getScannerStr().toLowerCase(); // get user input (yes/no)
                if(userInput.equals("y") || userInput.equals("yes"))
                {
                    
                    if (getMoney() >= upgradeCost)  // check if user has enough money
                    {
                        setMineLoop(getMineLoop() + 1); // increase MineLoop level
                        System.out.println("\nYou have upgraded the Mine Loop to level: " + getMineLoop());
                        System.out.println("\n => You can now mine the total of " + getMineLoop() + " minerals per attempt.");
                        }
                        this.subMoney(upgradeCost); // deduct the current money
                    }
                    else 
                    {
                        System.out.println("\nYou don't have enough money to upgrade.");
                    }
        }

        
            else if (getMineLoop() >= 12)
            System.out.println("You have reached max number of times to mine per attempt: " + getMineLoop());
        
        System.out.println("===============================================================");
        
    }

    

    public void upgradeDrill()
    {
        this.clearScreen();
        System.out.println("\n===============================================================");
        if (getUpper() < 8000 && getDrillLevel() < 160)
        {
            // initial cost is 100, times 1.1 ^( current drill level - 1 )
            double upgradeCost = 100 * (Math.pow(1.1,(getDrillLevel()-1)));
            System.out.println("\nUpgrade drill to level " + (getDrillLevel() + 1) + " for: $" + upgradeCost + " ?");
            System.out.print("[Y]/[N] : ");
            
            String userInput = ui.getScannerStr().toLowerCase(); // get user input (yes/no)
            if(userInput.equals("y") || userInput.equals("yes"))
            {
                
                if (getMoney() >= upgradeCost) // check if user has enough money
                {
                    setDrillLevel(getDrillLevel()+1); // increase drill level
                    setUpper(getUpper() + getDepthIncrement()); // dig deeper
                    
                    System.out.println("\nYou have upgraded the drill to level: " + getDrillLevel());
                    System.out.println("\n => You can now mine to: " + getUpper() + "m.");
                    this.subMoney(upgradeCost); // deduct the current money
                }
                
                else 
                {
                    System.out.println("\nYou don't have enough money to upgrade.");
                }
            }
            else
            {
                System.out.println("\nYou did not upgrade the drill.");
            }
        }
        else if (getDrillLevel() >= 160)
        {
            System.out.println("\nWhoops, it seems you have reached beyond max drill level");
            System.out.println("\nLet's dial back a little bit.");
            setDrillLevel(1);
            System.out.println("\nYour drill level is now 1.");
        }
        else if (getUpper() >=8000)// if max depth reached, cant upgrade
        {
            System.out.println("\nYou have reached max depth: 8000m.");
        }
        System.out.println("===============================================================");
        
    }


    public void addToInventory(Mineral other) // method to add minerals to inventory
    {
        boolean exist = false;
        // get current inventory
        for (Mineral m : getInventory())
        {
            // check if (other) mineral is already in the inventory
            if (m.getName().equals(other.getName()))
            {
                exist = true; // if it already exist, only add 1 to the total amount
                m.addAmount(1);
                break;
            }
        }
        if (!exist) // if it does not exist, add the entire mineral (name, rarity, amount = 1)
        {
            getInventory().add(other);
        }
    }
   
 

    public void mining()
    {
        this.clearScreen();
        System.out.println("\n===============================================================");
        System.out.println("Mine results:\n");
        Random rand = new Random();
        MineralSheet all_Mineral = new MineralSheet(); //import mineral sheet
        // make new list that contains obtainable minerals
        ArrayList<Mineral> threshold = new ArrayList<Mineral>();

        // get a list of minerals between lower and upper bound
        for (Mineral m : all_Mineral.getList())
        {
            if (this.getLower() == 0 && this.getUpper()==0)
            {
                this.setLower(0);
                this.setUpper(500);
            }
            if (this.getLower() <= m.getMinDepth() && m.getMaxDepth() <= this.getUpper())
            {
                //each minerals have their own min and max depths
                //this will include any minerals that are within the bounds
                threshold.add(m); 
            }
            
        }

        //  total probability: all minerals' "probability" will add up
        //  Ex: coal = 100, copper = 70, iron = 35, lead = 10, add up = 215
        int totalProbability = 0;
        for (Mineral m : threshold)
        {
            totalProbability += m.getProbability();
        }
        // create a temporary inventory for displaying purposes.
        ArrayList<Mineral> tempInventory = new ArrayList<Mineral>(); 

        // start mining
        for (int i = 0; i < getMineLoop(); i++)
        {
            // roll for a random number between 1 and 215 (example)
            // cumulative: after each loop, probability of each
            //mineral will add up = 215 ( 100 -> 170 -> 205 -> 215)
            //                        (coal -> copper -> iron -> lead)
            // execution: roll a random number ( lets say 101)
            // the loop will execute, going through a list of minerals
            // 1st loop: cumulative = 100 (start at coal)
            // if !roll < cumulative, start next loop, 
            // 2nd loop: cumulative = 170 (we're at copper)
            // since roll < cumulative, we get this mineral
            int roll = rand.nextInt(totalProbability)+1;
            Mineral minedMineral = null; 
            int cumulative = 0;

            for (Mineral m : threshold)
            {
                cumulative += m.getProbability();
                
                if (roll <= cumulative)
                {
                    minedMineral = m;
                    break;
                }
            }

            // adding mineral to both temporary inventory and real inventory
            if (minedMineral != null)
            {   
                
                boolean exist = false;  

                //same method as addToInventory
                for (Mineral temp : tempInventory)
                {
                    if (minedMineral.getName().equals(temp.getName()))
                    {
                        temp.addTempAmount(1);
                        exist = true;
                        break;
                    }

                }
                if (!exist)
                {
                    tempInventory.add(minedMineral);
                }
                this.addToInventory(minedMineral);
            }
        }
        // print out the minerals mined per attempt
        for (Mineral m : tempInventory)
        {
            System.out.println("You mined: " + m.getTempAmount() + "x " + m.getName());
            m.setTempAmount(1); // reset to 1 for future minerals
        }
        System.out.println("===============================================================");
    }



}
