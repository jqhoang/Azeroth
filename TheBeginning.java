package legend;
import java.util.Scanner;

public class TheBeginning {
    static Scanner scan;
    static String userRole;
    static Player main;


public static void main(String[] args) {
    scan = new Scanner(System.in);
    System.out.println("Hello player, welcome to the land of Azeroth what would you like to play as?");
    System.out.println("The choices you have are warrior, rogue or a mage!");
    do {
        userRole = scan.next();
    } while (!(userRole.equalsIgnoreCase("warrior") || userRole.equalsIgnoreCase("mage") 
            || userRole.equalsIgnoreCase("rogue")));

    switch (userRole) {
    case "warrior":
        main = new Player("warrior");
        break;
    case "mage":
        main = new Player("mage");
        break;
    case "rogue":
        main = new Player("rogue");
        break;
    }
    //System.out.println(main.toString());
    
    System.out.println("You are a " + userRole + ".");
    System.out.println("You awake in Argonia, a small village in the Eastern side of Azeroth.");
    System.out.println("Argonia has always been quiet, but in the wake of the civil war of Azeroth" 
    + ", you know that unrest will come to your village.\n" );
    System.out.println("A slow knock on your door interrupts your thoughts, you answer and hear a low"
            + " growly voice answer.\n");
    System.out.println("You have been summoned " + userRole + ". Your father has requested you come" + 
            " to the capital, in light of the rebellion it is of utmost \nimportance that you comply." + 
            " We leave now.\n");
    System.out.println("Your father has not contacted you in years, but it is apparent that he has been keeping"
            + " tabs on you. \nIf he has requested your return to Aluneth, it is something you must do."
            + " You gather your things and head towards the door.");
    if (userRole.equals("warrior")) {
        Item sword = new Item("sword", 0, 0, 1, 0, 0, 0, 1);
        Item chainmail = new Item("chainmail", 2, 0, 0, 1, 0, 0, 1);
        main.getItems().add(sword);
        main.getItems().add(chainmail);
        main.equipWep(sword);
        main.equipArmor(chainmail);
        main.stats[0] = main.getCapHP();
        main.stats[1] = main.getCapMP();
    }
    if (userRole.equals("mage")) {
        Item staff = new Item("staff", 0, 0, 1, 0, 1, 0, 1);
        Item robe = new Item("robe", 1, 1, 0, 1, 0, 0, 1);
        main.getItems().add(staff);
        main.getItems().add(robe);
        main.equipWep(staff);
        main.equipArmor(robe);
        main.stats[0] = main.getCapHP();
        main.stats[1] = main.getCapMP();
    }
    if (userRole.equals("rogue")) {
        Item dagger = new Item("dagger", 0, 0, 1, 0, 0, 1, 1);
        Item garb = new Item("garb", 1, 0, 0, 1, 0, 0, 1);
        
        main.getItems().add(dagger);
        main.getItems().add(garb);
        main.equipWep(dagger);
        main.equipArmor(garb);
        main.stats[0] = main.getCapHP();
        main.stats[1] = main.getCapMP();
    }
    //System.out.println(main.toString());
    System.out.println("You step outside the door to find the guard. He is an old man, with a full beard. His eyes"
            + " glower at you. \nThey have a glimmer to them, as if thousands dawns have been witnessed. He motions"
            + " towards a grey mare. \nYou take off away from town."
            + "\nYou reach the surrounding woods of Argonia, the moonlight illuminates the tall grass.\nThe old man"
            + " stops his horses gallop and whispers.\n\nStop. \n\nThere are shadows ahead, they have ill intention."
            + "\nYou reign your horse to a stop. The wind whistles as it streaks through the tall grass. In its whistle"
            + "\nyou hear what the old man is speaking of, light footsteps. They move aggressively towards you it "
            + "seems they \nare aware you know of their presence."
            + " Stay in the shadows, I will handle this.");
    Player oldMan = new Player("warrior");
    for(int i = 0; i < 11; i++) {
        oldMan.levelUpWarrior();
    }
    Player enemy = new Player("demon");
    for (int i = 0; i < 5; i++) {
        enemy.levelUpWarrior();
    }
    Battle encounter = new Battle(oldMan, enemy);
    encounter.encounter();
    System.out.println("The old man stands over the slain demon.");

    
}
}
