package legend;

import java.util.Scanner;

public class Battle {
    private Scanner scan;
    private String x;
    private String userChoice;
    private Player player;
    private Player enemy;
    private Player enemy2;
    
    public Battle (Player player, Player enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    
    public Battle (Player player, Player enemy, Player enemy2) {
        this.player = player;
        this.enemy = enemy;
        this.enemy2 = enemy2;
    }
    
    /*public void encounter2() {
        scan = new Scanner(System.in);
        while (player.stats[0] > 0 && (enemy.stats[0] > 0 && enemy2.stats[0] > 0)) {
            int playerTurns = (int) (player.stats[5]/enemy.stats[5]);
            int enemyTurns = (int) (enemy.stats[5]/player.stats[5]);
            int enemy2Turns = (int) (enemy2.stats[5]/player.stats[5]);
            if (playerTurns == 0) {
                playerTurns = 1;
            }
            if (enemyTurns == 0) {
                enemyTurns = 1;
            }
            if (enemy2Turns == 0) {
                enemy2Turns = 1;
            }
            player.stats[6] = playerTurns;
            enemy.stats[6] = enemyTurns;
            enemy2.stats[6] = enemy2Turns;
        }
        while (player.stats[6] != 0) {
            do {
                System.out.println("What would you like to do player?");
                System.out.println("Your options are: ");
            }
        }
    }
    */
    public void encounter() {
        scan = new Scanner(System.in);
        while (player.stats[0] > 0  && enemy.stats[0] > 0) {
            int playerTurns = (int) (player.stats[5]/enemy.stats[5]);
            int enemyTurns = (int) (enemy.stats[5]/player.stats[5]);
            if (playerTurns == 0) {
                playerTurns = 1;
            }
            if (enemyTurns == 0) {
                enemyTurns = 1;
            }
            player.stats[6] = playerTurns;
            enemy.stats[6] = enemyTurns;
            // MAKE THIS A METHOD CALLED USERTURN, make an array to keep track of which moves and items are accesible to the player
            // and then make a gigantic switch statement with every skill listed and to call it, use an if array of boolean type to see if player
            //has attained the skill, if boolean check is true allow method to be used, else call again
            while (player.stats[6] != 0) {
                do {
                System.out.println("What would you like to do player?");
                System.out.println("Your options are: Attack");
                x = scan.next().toLowerCase().trim();
                } while (x.equals("") || x == null || !x.equals("attack"));
                switch (x) {
                case "attack":
                    player.attack(enemy);
                    //System.out.println(enemy.toString());
                    break;
                }
                
            }
            while (enemy.stats[6] != 0) {
                enemy.attack(player);
                //System.out.println(player.toString());
            }

            if (playerTurns == 0) {
                playerTurns = 1;
            }
            if (enemyTurns == 0) {
                enemyTurns = 1;
            }
            player.stats[6] = playerTurns;
            enemy.stats[6] = enemyTurns;
        }
        if (player.stats[0] <= 0) {
            System.out.println("You have failed in your quest, champion.");
        }
        if (enemy.stats[0] <= 0) {
            System.out.println("The enemy has been vanquished.");
            player.giveXp(enemy);
        }
    }
}

