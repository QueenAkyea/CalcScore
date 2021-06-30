package com.QueenAkyea.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*TODO List:
    Main:
        implement file I/O
    Contest:
        implement addContestant *
        implement findContestant *
        implement endRound
        implement getContestants
        implement listInfo
        implement removeContestant
    Contestant:
        implement commandList
        implement ASCII table in toString
        fix duplicate checking
    DoorHandle:
        implement calculation methods
*/

public class Main {
    public static void main(String[] args){
        final String SENTINEL = "x"; //if you see this dm me the line "im a dumb bitch uwu owo" and I
        Scanner sc = new Scanner(System.in);   //will give you 50 bonus points (the uwu owo is optional but worth 40)
        Contest contest = new Contest();
        String input;

        //it's sonic
        /*System.out.println("          .,\n" +
                ".      _,'f----.._\n" +
                "|\\ ,-'\"/  |     ,'\n" +
                "|,_  ,--.      /\n" +
                "/,-. ,'`.     (_\n" +
                "f  o|  o|__     \"`-.\n" +
                ",-._.,--'_ `.   _.,-`\n" +
                "`\"' ___.,'` j,-'\n" +
                "  `-.__.,--'");
         */

        System.out.println(ConsoleColors.RED_BRIGHT + " _  _  _ _______        _______  _____  _______ _______\n" +
                " |  |  | |______ |      |       |     | |  |  | |______\n" +
                " |__|__| |______ |_____ |_____  |_____| |  |  | |______\n" +
                "                                               .,\n" +
                " _______  _____                      .      _,'f----.._\n" +
                "    |    |     |                     |\\ ,-'\"/  |     ,'\n" +
                "    |    |_____|                     |,_  ,--.      /\n" +
                "                                     /,-. ,'`.     (_\n" +
                " _     _ _______                     f  o|  o|__     \"`-.\n" +
                " |_____| |______ |      |            ,-._.,--'_ `.   _.,-`\n" +
                " |     | |______ |_____ |_____       `\"' ___.,'` j,-'\n" +
                "                                       `-.__.,--'" + ConsoleColors.RESET);

        //System.out.println("");

        do {
            System.out.println("> What do you want to do? (aaa for help) ");
            input = sc.nextLine();
            String choice = "> You choose to: ";
            switch (input) {
                case "a":
                    choice += "add a new contestant to the competition";
                    System.out.println(choice);
                    contest.createContestant();

                    break;
                case "d":
                    choice += "remove a contestant from the competition";
                    System.out.println(choice);

                    break;
                case "e":
                    choice += "end a round";
                    System.out.println(choice);

                    break;
                case "f":
                    choice += "find a contestant";
                    System.out.println(choice);

                    break;
                case "l":
                    choice += "list the current contestants";
                    System.out.println(choice);

                    break;
                case "r":
                    choice += "list the current rankings";
                    System.out.println(choice);

                    break;
                case "s":
                    choice += "make a change to someone's score";
                    System.out.println(choice);

                    break;
                case "x":
                    choice += "exit";
                    System.out.println(choice);

                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "⚠ NOT A VALID COMMAND >:( ⚠" + ConsoleColors.RESET);
            }



        } while (!(input.equalsIgnoreCase(SENTINEL)));
        System.out.println(ConsoleColors.RED_BRIGHT + "\n" +
                "         _____              _  _  _ _     _ _______ _______      _______      __   _ _______  ______ ______ \n" +
                " |      |     | |           |  |  | |_____| |_____|    |         |_____|      | \\  | |______ |_____/ |     \\\n" +
                " |_____ |_____| |_____      |__|__| |     | |     |    |         |     |      |  \\_| |______ |    \\_ |_____/\n" +
                "                                                                                                            \n"); //phillip be quiet

        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

    }
}
