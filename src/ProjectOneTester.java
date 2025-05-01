public class ProjectOneTester {
    // This project is a solution to my problem when learning Java or CS in general, which is understanding OOP,
    // so I decided to make a game, which is more comprehensible when it comes to implementing OOP.
    // This is a mining game, where user can mine for minerals. Each minerals will have their attributes and variables that separate one from another.
    // Attributes and variables include names, rarities, values, and the depths that they could be found.
    // These attributes will be called for many purposes, such as adding to the user's inventory using the names,
    // or sorting based on rarity. Their values will determine other factors within the game, 
    // such as selling to gain money, then use that money for upgrades.
    // The game will have progression system, where upgrades are required for the user to dig deeper and gain more minerals.
    // Furthermore, there will be a menu option to select the actions to perform,
    // for example: option 1: mining() -> user can select this to mine.
    // The game will run on forever until the user select 0 to quit.

    // There will be several classes for this game to work.
    // Mineral.java is the identity of all minerals, with variables and attributes that define what a mineral is.
    // Player.java will hold all the actions, and also store the user's data, such as in-game money, and the game's progession through upgrades
    // InputAndInterface.java is for the input (Scanner), instead of creating new Scanner object for actions that required inputs, one class with methods should be suffice.
    // MineralSheet.java is where all minerals are stored as a final list. It references the Mineral class to create each distinct minerals.
    // The Player class will reference the sheet to decide which minerals the user could obtain.
     // GameLogic.java is the game structure, where everything will be put together as a complete game.      
    public static void main(String[] args) {

        // Case1: - As intended -
        // Name input: will be invalid if theres any numbers or integer
        // choice input: will be invalid if not integer from 0-6
        // User will start with $0, mine 1 time initially,
        // get 1 mineral per mining attempt.
        // pickaxe starts at lvl 1, drill starts at lvl 1,
        // lower bound is 0, will stays the same for the entire game.
        // upper bound is 500m -> can only mine coal for now (this can be upgraded)
        // Evidently, user can check the stats [6] ( same attributes as stated)
        GameLogic newGame1 = new GameLogic(0, 1, 1, 1, 0, 500);
        newGame1.startGame();

        // Case2: - Cheats -
        // Name input: will be invalid if theres any numbers or integer
        // choice input: will be invalid if not integer from 0-6
        // User will start with $100,000, mine 10 times initially
        // get 10 minerals per mining attempt.
        // pickaxe starts at lvl 1, though upgrade to lvl 4 wil maximize the mineLoop ( max mineLoop = 12), therefore unable to upgrade further
        // drill starts at lvl 1, but the max depth is 8000, so drill cannot be upgraded
        // additionally, lower bound is set to 3200, which will only includes all Legendary minerals
        // check stat to confirm [6]

        //GameLogic newGame2 = new GameLogic(100000, 10, 1, 1, 3200, 8000);
        //newGame2.startGame();

        // Case3: - Blue Diamond -
        // Name input: will be invalid if theres any numbers or integer
        // choice input: will be invalid if not integer from 0-6
        // User will have mostly the same attributes as Case 2
        // Only target a single mineral: Blue Diamond (lower bound = 4800, upper bound = 8000)
        // mineLoop = 20, -> expect 20 blue diamonds
        // unable to upgrade pickaxe due to the exceed mineLoop ( max mineLoop = 12)
        // unable to upgrade pickaxe due to hitting the max depth

        //GameLogic newGame3 = new GameLogic(9999, 20, 20,  1, 4800, 8000);
        //newGame3.startGame();
        
        // Case4: - Problems -
        // Name input: will be invalid if theres any numbers or integer
        // choice input: will be invalid if not integer from 0-6
        // User will have $500,000
        // Problem 1: Pickaxe lvl 24, but mineLoop = 1 ( which can only increase by upgrading the pickaxe level)
        // => have option to upgrade mineLoop if pickaxe reaches 24 and mine loop is < 12.
        // Problem 2: Drill lvl is 200, which makes the cost to upgrade impossible to achieve.
        // => Automatically set back to lvl 1 when tries to upgrade.
        // Problem 3: The bounds are 0m - 0m, which doesnt return any minerals to mine.
        // => will set to default 0-500m when first mine.

        //GameLogic newGame4 = new GameLogic(500000, 01, 24, 200, 0, 0);
        //newGame4.startGame();
    }
}
