This project is a solution to my problem when learning Java or CS in general, which is understanding OOP,
so I decided to make a game, which is more comprehensible when it comes to implementing OOP.
This is a mining game, where user can mine for minerals. Each minerals will have their attributes and variables that separate one from another.
Attributes and variables include names, rarities, values, and the depths that they could be found.
These attributes will be called for many purposes, such as adding to the user's inventory using the names,
or sorting based on rarity. Their values will determine other factors within the game, 
such as selling to gain money, then use that money for upgrades.
The game will have progression system, where upgrades are required for the user to dig deeper and gain more minerals.
Furthermore, there will be a menu option to select the actions to perform,
for example: option 1: mining() -> user can select this to mine.
The game will run on forever until the user select 0 to quit.

There will be several classes for this game to work.
Mineral.java is the identity of all minerals, with variables and attributes that define what a mineral is.
Player.java will hold all the actions, and also store the user's data, such as in-game money, and the game's progession through upgrades
InputAndInterface.java is for the input (Scanner), instead of creating new Scanner object for actions that required inputs, one class with methods should be suffice.
MineralSheet.java is where all minerals are stored as a final list. It references the Mineral class to create each distinct minerals.
The Player class will reference the sheet to decide which minerals the user could obtain.
GameLogic.java is the game structure, where everything will be put together as a complete game.