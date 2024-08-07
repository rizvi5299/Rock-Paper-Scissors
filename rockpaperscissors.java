import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class rockpaperscissors{
    static final String ANSI_RESET = "\u001B[0m"; static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_YELLOW = "\u001B[93m"; static final String ANSI_BLUE = "\u001B[94m";
    static final String ANSI_PURPLE = "\u001B[35m"; static final String LIGHTRED = "\u001B[91m";


    public static void rockpaperscissorsgame(){

        List<String> RPC = new ArrayList<>(); RPC.add("r");RPC.add("p");RPC.add("s");
        Map<String, String> choiceMap = new HashMap<>();choiceMap.put("r", "Rock");choiceMap.put("p", "Paper");choiceMap.put("s", "Scissors");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("************************************************\n\uD83D\uDC4A✋✌\uFE0F" + ANSI_YELLOW + " Welcome to Rock-Paper-Scissors! " + ANSI_RESET + "\uD83D\uDC4A✋✌\uFE0F \n************************************************");
        System.out.println(ANSI_BLUE + "Lets play a game of Rock, Paper, Scissors! Me vs. you! First to 3 wins!" + ANSI_RESET);
        boolean playAgain=true;

        while(playAgain){
            byte userwins=0;
            byte botwins=0;
            while(true){

                int randomIndex = random.nextInt(RPC.size());  //get a random RPC array index
                String randomWord = RPC.get(randomIndex);  //retrieve the word of that random index of RPC
                if(botwins==2&&userwins==2) System.out.println("          We're tied, " + ANSI_BLUE + "next game wins!" + ANSI_RESET);
                System.out.print("Enter your choice: rock (" + ANSI_BLUE + "r" + ANSI_RESET + "), paper (" + ANSI_BLUE + "p" + ANSI_RESET + "), or scissors (" + ANSI_BLUE + "s" + ANSI_RESET + "): ");
                String Userguess = scanner.nextLine().toLowerCase();

                if (!RPC.contains(Userguess)) {
                    System.out.println("Please only enter r, p, or s.");
                    continue;
                }


                String fullUserChoice = choiceMap.get(Userguess);
                String fullRandomChoice = choiceMap.get(randomWord);

                if(Userguess.equals("r")&&randomWord.equals("s")||Userguess.equals("p")&&randomWord.equals("r")||Userguess.equals("s")&&randomWord.equals("p")) {
                    userwins++;
                    System.out.println("          You chose " + ANSI_PURPLE + fullUserChoice.toLowerCase() + ANSI_RESET + " and I chose " + ANSI_PURPLE + fullRandomChoice.toLowerCase() + ANSI_RESET + ".");
                    try {Thread.sleep(500);} catch (InterruptedException e) {}
                    System.out.println("   🎉" + fullUserChoice + ANSI_YELLOW + " beats " + ANSI_RESET + fullRandomChoice.toLowerCase() + "! Your score: " + ANSI_YELLOW + userwins + ANSI_RESET + " and my score: " + LIGHTRED + botwins + ANSI_RESET);
                    try {Thread.sleep(500);} catch (InterruptedException e) {}
                    if (userwins >= 3) {
                        try {Thread.sleep(600);} catch (InterruptedException e) {}
                        System.out.println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83D\uDE0EYou've gotten 3 wins, HOORAY! You've " + ANSI_YELLOW + "WON" + ANSI_RESET + " the game!" + ANSI_YELLOW + "CONGRATULATIONS!\uD83D\uDE0E\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89" + ANSI_RESET); break;
                    }
                }

                else if(randomWord.equals("r")&&Userguess.equals("s")||randomWord.equals("p")&&Userguess.equals("r")||randomWord.equals("s")&&Userguess.equals("p")) {
                    botwins++;
                    System.out.println("          You chose " + ANSI_PURPLE + fullUserChoice.toLowerCase() + ANSI_RESET + " and I chose " + ANSI_PURPLE + fullRandomChoice.toLowerCase() + ANSI_RESET + ".");
                    try {Thread.sleep(500);} catch (InterruptedException e) {}
                    System.out.println("   "+fullRandomChoice + ANSI_RED + " beats " + ANSI_RESET + fullUserChoice.toLowerCase() + "! Your score: " +  LIGHTRED + userwins + ANSI_RESET + " and my score: " + ANSI_YELLOW + botwins + ANSI_RESET);
                    try {Thread.sleep(600);} catch (InterruptedException e) {}
                    if (botwins >= 3) {
                        try {Thread.sleep(500);} catch (InterruptedException e) {}
                        System.out.println("Tough luck, " + ANSI_RED + "YOU LOST!" + ANSI_RESET + " Better luck next time, " + ANSI_RED + "loser!" + ANSI_RESET + "\uD83D\uDE0E\uD83D\uDE0E"); break;
                    }
                }

                else if (randomWord.equals(Userguess)) {
                    System.out.println("          We both chose " + ANSI_PURPLE + fullRandomChoice.toLowerCase() + ANSI_RESET + ", so it's a draw!");
                    try {Thread.sleep(500);} catch (InterruptedException e) {}
                }


            }


            System.out.print("That was fun! Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            System.out.println("");
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
            scanner.nextLine();
            if(playAgainResponse.equalsIgnoreCase("yes")){System.out.println("************************ " + ANSI_BLUE + "NEW GAME" + ANSI_RESET + " ************************\n");}
            else {
                if((botwins>userwins))  System.out.println("Goodbye loser! L");
                else {
                    System.out.println("Goodbye! See you next time. \uD83D\uDC4B\uD83D\uDE0A");
                    System.exit(69);
                    System.out.println("...You will never see this...");
                }
            }
        }
    }

    public static void main(String[] args){
        rockpaperscissorsgame();
    }
}
