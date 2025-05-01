import java.util.Scanner;
//  This is a minor class, which purpose is to import Scanner for the entire project
// also includes the method that print the title of the game. 

public class InputAndInterface
{
    private Scanner scanner = new Scanner(System.in);
    public InputAndInterface() {}
    public int getScannerInt()
    {   
        int userInput = scanner.nextInt();
        return userInput;
    }
    public String getScannerStr()
    {
        String userInput = scanner.nextLine();
        return userInput;
    }
    public boolean hasNextInt()
    {
        return scanner.hasNextInt();
    }
    public void next()
    {
        scanner.next();
    }
    public void title()
    { // I got this in text generator
        System.out.println("\n" +
                        "  _____           _           _       __  __ _                 \n" + //
                        " |  __ \\         (_)         | |  _  |  \\/  (_)                \n" + //
                        " | |__) | __ ___  _  ___  ___| |_(_) | \\  / |_ _ __   ___ _ __ \n" + //
                        " |  ___/ '__/ _ \\| |/ _ \\/ __| __|   | |\\/| | | '_ \\ / _ \\ '__|\n" + //
                        " | |   | | | (_) | |  __/ (__| |_ _  | |  | | | | | |  __/ |   \n" + //
                        " |_|   |_|  \\___/| |\\___|\\___|\\__(_) |_|  |_|_|_| |_|\\___|_|   \n" + //
                        "                _/ |                                           \n" + //
                        "               |__/                                            \n" + //
                        "");
    }
}
