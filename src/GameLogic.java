// Game logic class, which will compile all classes together and turn them into a functional game

public class GameLogic {
    InputAndInterface ui = new InputAndInterface();
    private  Miner n1 = new Miner(); // make a miner
    public GameLogic(int money, int mineLoop,int pickaxeLevel, int drillLevel, int lowerBound, int upperBound)
    {
        System.out.println("\n===============================================================");
       
        // all the initial variables ( can be assigned to any values )
        n1.playerName();
        n1.setMoney(money);
        n1.setMineLoop(mineLoop);
        n1.setPickaxeLevel(pickaxeLevel);
        n1.setDrillLevel(drillLevel);
        n1.setLower(lowerBound);
        n1.setUpper(upperBound);
        
    }
    public void startGame()
    {
        // game start
        boolean gameFlow = true;
        while (gameFlow)
        {   
            // all of the options
            ui.title();
            System.out.println("\n===============================================================");
            System.out.println("\nPlayer: " + n1.getPlayerName());
            System.out.println("\n========================== [ Menu ] ==========================");
            System.out.println("\nPlease enter options from 1 - 6, enter 0 to quit.");
            System.out.println("\n[1]. Mine minerals.");
            System.out.println("\n[2]. Open inventory.");
            System.out.println("\n[3]. Sell all minerals.");
            System.out.println("\n[4]. Upgrade Pickaxe.");
            System.out.println("\n[5]. Upgrade Drill.");
            System.out.println("\n[6]. View your stats.");
            System.out.println("\n[0]. Quit the game.");
            System.out.print("\nYour input: ");

           
            if (!ui.hasNextInt()) // check if input is valid (only integer)
            {
                System.out.println("\nInvalid input, please enter options from 1 - 6, enter 0 to quit.");
                ui.next(); // clear the invalid input
                continue;
                
            }
            
            int userInput = ui.getScannerInt(); // input an integer that matches the cases
            switch (userInput)
            {
                case 1: n1.mining();
                break;

                case 2: n1.openInventory();
                break;

                case 3: n1.sellAll();
                break;

                case 4: n1.upgradePickaxe();
                break;

                case 5: n1.upgradeDrill();
                break;

                case 6: n1.playerStats();
                break;

                case 0: System.out.println("\nThe game will close.\n");
                gameFlow = false;
                return;  
                
                default:
                    System.out.println("\nInvalid input, please enter options from 1 - 6, enter 0 to quit.");
            }
        }
    }
}

