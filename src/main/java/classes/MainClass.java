package classes;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Name");
        String name = scanner.nextLine();

        Warrior[] warriors = new Warrior[]{new Warrior(name), new Warrior("Pet")};

        FightField fightField = new FightField();
        fightField.initFight(warriors[0], warriors[1]);

        if (fightField.getCurrentFightStatus() == FightField.FIGHT_STATUS.FIGHT_BEGINS){
            System.out.println("=============FIGHT BEGINS!!!=============\n");
        }

        int kick, block;
        while (fightField.getCurrentFightStatus() != FightField.FIGHT_STATUS.FIGHT_ENDS){
            System.out.println("Enter your kick and block from 0 to 3 where:");
            System.out.println("0 = HEAD \n" +
                                "1 = BODY \n" +
                                "2 = GROIN \n" +
                                "3 = LEGS");
            kick = scanner.nextInt();
            block = scanner.nextInt();
            fightField.startRound(Warrior.BODY_PARTS.values()[kick], Warrior.BODY_PARTS.values()[block]);
        }
        System.out.println("Fight is finished!");
        if (warriors[0].isWinner()) System.out.println(warriors[0].getName() + " Wins!!!");
        else System.out.println(warriors[0].getName() + " Lose!!!");

    }
}
