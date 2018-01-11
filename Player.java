package legend;

import java.util.ArrayList;

/*0 is hitpoints, 1 is mana, 2 is attack, 3 is defence, 4 is intel, 5 is speed
have base values and a random modifier, with traits? prompt player later to make traits.
how am i going to account for if they are dead?
turn conditions are that stats[0] > 0 && stats[6] = 1;
equip weapons method to temporarily add stats
dequip wepaons method to remove

*/

//enemy hitpoints is enemyHP
//what statuses? poisoned(0-2), burnt, frozen, resistant

public class Player {
    
    private String role;
    int[] stats;
    private int[] statuses;
    private static final int NUM_STATUSES = 4;
    private int capHP;
    private int capMP;
    private int level;
    private boolean wep;
    private boolean armor;
    private boolean acc;
    private int xp;
    private int xpgiven;
    private ArrayList<Item> items;
    private ArrayList<Moves> moves;
    private int[] xplist = {10, 20, 30, 40, 50, 80, 100, 120, 140, 200, 220, 300, 400, 500, 650, 800, 950, 1100, 1250, 1500};
    
    //overloaded player differentiated by class?
    public Player (String role) {
        if (role.equals("warrior")) {
            role = "warrior";
            stats = new int[7];
            statuses = new int[4];
            stats[0] = (int) ((Math.random() * 5) + 20);
            stats[1] = (int) ((Math.random() * 2) + 5);
            stats[2] = (int) ((Math.random() * 2) + 4);
            stats[3] = (int) ((Math.random() * 2) + 6);
            stats[4] = (int) ((Math.random() * 2) + 3);
            stats[5] = (int) ((Math.random() * 2) + 4);
            //6 is for turn status 1 being action is possible
            stats[6] = 1;
            
            for (int i = 0; i < NUM_STATUSES; i++) {
                statuses[i] = 0;
            }
            capHP = stats[0];
            capMP = stats[1];
            level = 1;
            setItems(new ArrayList<Item>());
            xp = 0;
            
        }
        
        if (role.equals("mage")) {
            role = "mage";
            stats = new int[7];
            statuses = new int[4];
            stats[0] = (int) ((Math.random() * 3) + 15);
            stats[1] = (int) ((Math.random() * 3) + 7);
            stats[2] = (int) ((Math.random() * 2) + 3);
            stats[3] = (int) ((Math.random() * 2) + 4);
            stats[4] = (int) ((Math.random() * 2) + 6);
            stats[5] = (int) ((Math.random() * 2) + 5);
            stats[6] = 1;
            
            for (int i = 0; i < NUM_STATUSES; i++) {
                statuses[i] = 0;
            }
            capHP = stats[0];
            capMP = stats[1];
            level = 1;
            setItems(new ArrayList<Item>());
            xp = 0;
        }
        
        if (role.equals("rogue")) {
            role = "rogue";
            stats = new int[7];
            statuses = new int[4];
            stats[0] = (int) ((Math.random() * 3) + 15);
            stats[1] = (int) ((Math.random() * 2) + 5);
            stats[2] = (int) ((Math.random() * 2) + 5);
            stats[3] = (int) ((Math.random() * 2) + 4);
            stats[4] = (int) ((Math.random() * 2) + 5);
            stats[5] = (int) ((Math.random() * 3) + 7);
            stats[6] = 1;
            
            for (int i = 0; i < NUM_STATUSES; i++) {
                statuses[i] = 0;
            }
            capHP = stats[0];
            capMP = stats[1];
            level = 1;
            setItems(new ArrayList<Item>());
            xp = 0;
        }
        
        if (role.equals("goblin")) {
            role.equals("goblin");
            stats = new int[7];
            statuses = new int[4];
            stats[0] = (int) ((Math.random() * 2) + 5);
            stats[1] = (int) ((Math.random() * 2) + 1);
            stats[2] = (int) ((Math.random() * 1) + 1);
            stats[3] = (int) ((Math.random() * 1) + 2);
            stats[4] = (int) ((Math.random() * 1) + 1);
            stats[5] = (int) ((Math.random() * 1) + 6);
            stats[6] = 1;
            
            for (int i = 0; i < NUM_STATUSES; i++) {
                statuses[i] = 0;
            }
            capHP = stats[0];
            capMP = stats[1];
            setXpgiven(2);
        }
        
        if (role.equals("guard")) {
            role.equals("guard");
            stats = new int[7];
            statuses = new int[4];
            stats[0] = (int) ((Math.random() * 3) + 10);
            stats[1] = (int) ((Math.random() * 2) + 3);
            stats[2] = (int) ((Math.random() * 2) + 4);
            stats[3] = (int) ((Math.random() * 2) + 4);
            stats[4] = (int) ((Math.random() * 2) + 4);
            stats[5] = (int) ((Math.random() * 2) + 5);
            stats[6] = 1;
            
            for (int i = 0; i < NUM_STATUSES; i++) {
                statuses[i] = 0;
            }
            capHP = stats[0];
            capMP = stats[1];
            setXpgiven(5);
        }
        
        if (role.equals("demon")) {
            role.equals("demon");
            stats = new int[7];
            statuses = new int[4];
            stats[0] = (int) ((Math.random() * 3) + 30);
            stats[1] = (int) ((Math.random() * 2) + 4);
            stats[2] = (int) ((Math.random() * 2) + 6);
            stats[3] = (int) ((Math.random() * 2) + 5);
            stats[4] = (int) ((Math.random() * 2) + 5);
            stats[5] = (int) ((Math.random() * 2) + 8);
            stats[6] = 1;
            
            for (int i = 0; i < NUM_STATUSES; i++) {
                statuses[i] = 0;
            }
            capHP = stats[0];
            capMP = stats[1];
            setXpgiven(30);
        }
    }
    
    public String getRole() {
        return this.role;
    }
    
    public int getXp() {
        return this.xp;
    }
    
    public void setXp(int xp) {
        this.xp = xp;
    }
    
    public boolean getWep() {
        return wep;
    }

    public void setWep(boolean wep) {
        this.wep = wep;
    }
    public boolean getArmor() {
        return armor;
    }

    public void setArmor(boolean armor) {
        this.armor = armor;
    }

    public boolean getAcc() {
        return acc;
    }

    public void setAcc(boolean acc) {
        this.acc = acc;
    }

    @Override
    public String toString() {
        return "HP: " + this.stats[0] + "/" + this.getCapHP() + "\nMP: " + this.stats[1] + "/" + this.getCapMP() + "\nATK: " + this.stats[2] + 
        "\nDEF: " + this.stats[3] + "\nINT " + this.stats[4] + "\nSPD: " + this.stats[5] + 
        "\nPlayer Level: " + this.getLevel();
    }
    
    public int getCapHP() {
        return this.capHP;
    }
    
    public int getCapMP() {
        return this.capMP;
    }
    
    public int getAtk() {
        return this.stats[2];
    }
    public int getDef() {
        return this.stats[3];
    }
    public int getInt() {
        return this.stats[4];
    }
    public int getSpd() {
        return this.stats[2];
    }

    public void setAtk(int atk) {
        this.stats[2] = atk;
    }
    public void setDef(int def) {
        this.stats[3] = def;
    }
    
    public void setInt(int intel) {
        this.stats[4] = intel;
    }
    
    public void setSpd(int spd) {
        this.stats[5] = spd;
    }
    
    
    public int getLevel() {
        return this.level;
    }
    
    public void setCapHP(int newcap) {
        this.capHP = newcap;
    }
    
    public void setCapMP(int newcap) {
        this.capMP = newcap;
    }
    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void attack(Player enemy) {
        if (((Math.random() * 100) + this.stats[5]) > 100) {
            if (((this.stats[2] * 2) - (int) (enemy.stats[3]/2)) > 0) {
            enemy.stats[0]-= ((this.stats[2] * 2) - (int) (enemy.stats[3]/2));
            System.out.println("Critical strike! You inflicted " + ((this.stats[2] * 2) - (int) (enemy.stats[3]/2)) + " damage.");
            } else {
                System.out.println("The strike was ineffective.");
            }
        } else {
            if((this.stats[2] - (int) (enemy.stats[3]/2)) > 0) {
        enemy.stats[0] -= (this.stats[2] - (int) (enemy.stats[3]/2));
        System.out.println("You inflicted " + (this.stats[2] - (int) (enemy.stats[3]/2)) + " damage.");
            } else {
                System.out.println("The strike was ineffective.");
            }
        }
        this.stats[6] = 0;
    }
    /*Rogue skills*/
    public void superior(Player enemy) {
        this.stats[1] -= 3;
        if (this.stats[1] < 0) {
            this.stats[6] = 1;
        } else {
            if (enemy.stats[3] < this.stats[2] && enemy.stats[5] < this.stats[5]) {
                if (((Math.random() * 100) + this.stats[5]) > 100) {
                    enemy.stats[0]-= (int) (this.stats[2] * 4.25) - this.stats[3];
                } else {
                enemy.stats[0] -= this.stats[2] * 3 - this.stats[3];
                }
            } else {
                enemy.stats[0] -= this.stats[2] * 2 - this.stats[3];
            }
            this.stats[6] = 0;
            }
    }
    
    public void gamble(Player enemy) {
        double gamble = (Math.random() * 2) + this.stats[5]/100;
        if (gamble > 1.75) {
            enemy.stats[0] -= this.stats[5];
        }
        
    }
    
    
    /*Mage skills*/
    public void pulse(Player enemy) {
        this.stats[1]--;
        if (this.stats[1] < 0) {
            enemy.stats[0] -= this.stats[4];
        } else {
            enemy.stats[0] -= this.stats[4];
        }
        this.stats[6] = 0;
    }
    
    public void fireball(Player enemy) {
        this.stats[1] -= 2;
        if (this.stats[1] < 0) {
            this.stats[6] = 1;
        } else {
            int damage;
            if (enemy.statuses[1] == 1) {
                damage = (int) (this.stats[4] * 2.00);
                this.stats[6] = 0;
            } else {
                damage = (int) (this.stats[4] * 1.75);
                enemy.statuses[1] = 1;
                this.stats[6] = 0;
            }
            if (enemy.statuses[3] == 1) {
                damage /= 2;
            }
            enemy.stats[0] -= damage;
        }
    }
    
    public void icicle(Player enemy) {
        this.stats[1] -= 2;
        if (this.stats[1] < 0) {
            this.stats[6] = 1;
        } else {
            enemy.stats[0] -= (int) (this.stats[4] * 0.75);
            if (enemy.statuses[3] == 0) {
                enemy.statuses[2] = 1; 
            }
            this.stats[6] = 0;
        }
    }
    
    public void envenom (Player enemy) {
        this.stats[1] -= 2;
        if (this.stats[1] < 0) {
            stats[6] = 1;
        } else {
            enemy.statuses[0] = 1;
            stats[6] = 0;
        }
    }
    
    public void rapture (Player enemy) {
        this.stats[1] -= 5;
        if (this.stats[1] < 0) {
            stats[6] = 1;
        } else {
            enemy.statuses[0] = 2;
            if (enemy.statuses[3] == 0) {
                enemy.statuses[2] = 1; 
            }
            stats[6] = 0;
        }
    }
    
    public void chainFire(Player enemy, Player enemy2) {
        this.stats[1] -= 2;
        if (this.stats[1] < 0) {
            stats[6] = 1;
        } else {
            enemy.stats[0] -= (int) (this.stats[4] * 0.25);
            enemy2.stats[0] -= (int) (this.stats[4] * 0.25);
            enemy.statuses[1] = 1;
            enemy2.statuses[1] = 1;
            this.stats[6] = 0;
        }
    }
    
    public void manaShield() {
        int shield = (int) (this.stats[1] / 2);
        this.stats[1] -= (int) (this.stats[1] / 3);
        this.stats[0] += shield;
    }
    //tier 2
    public void debilitate(Player enemy) {
        this.stats[1] -= 4;
        enemy.statuses[3] = 0;
        enemy.stats[1] /= 2;
        enemy.stats[2] -= 2;
        this.stats[6] = 0;
    }
    
    public void pyroclasm(Player enemy, Player enemy2) {
        this.stats[1] -= 6;
        if (this.stats[1] < 0) {
            this.stats[6] = 1;
        }
        if (enemy.statuses[1] == 1 && enemy2.statuses[1] == 1) {
            enemy.stats[0] -= (int) (this.stats[4] * 3.00);
            enemy2.stats[0] -= (int) (this.stats[4] * 3.00);
            this.stats[6] = 0;
        } else if (enemy.statuses[1] == 0 && enemy2.statuses[1] == 1) {
            enemy.stats[0] -= (int) (this.stats[4] * 1.50);
            enemy.statuses[1] = 1;
            this.stats[6] = 0;
            enemy2.stats[0] -= (int) (this.stats[4] * 3.00);
        } else if (enemy.statuses[1] == 1 && enemy2.statuses[1] == 0) {
            enemy.stats[0] -= (int)  (this.stats[4] * 3.00);
            enemy2.stats[0] -= (int) (this.stats[4] * 1.50);
            enemy2.statuses[1] = 1;
            this.stats[6] = 0;
        } else {
            enemy.stats[0] -= (int)  (this.stats[4] * 1.50);
            enemy2.stats[0] -= (int) (this.stats[4] * 1.50);
            enemy.statuses[1] = 1;
            enemy2.statuses[1] = 1;
            this.stats[6] = 0;
        }
        
    }
    
    
    
    public void heal() {
        this.stats[0] += this.stats[4] * 2;
        this.stats[1] -= 3;
        this.stats[6] = 0;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void giveXp(Player enemy) {
        this.setXp(this.getXp() + enemy.getXpgiven());
        if (this.getXp() > xplist[this.level-1]) {
            if (role.equals("warrior")) {
            this.levelUpWarrior();
            this.setXp(0);
            } else if (role.equals("mage")) {
                this.levelUpMage();
                this.setXp(0);
            } else {
                this.levelUpRogue();
                this.setXp(0);
            }
        }
        
    }
    
    public void levelUpWarrior() {
        stats[2] += (int) (Math.random() * 3) + 1;
        stats[3] += (int) (Math.random() * 2) + 2;
        stats[4] += (int) (Math.random() * 2);
        stats[5] += (int) (Math.random() * 2) + 1;
        this.setCapMP(this.getCapMP() + 2);
        this.setCapHP(this.getCapHP() + 5);
        stats[0] = this.getCapHP();
        stats[1] = this.getCapMP();
        this.level ++;
    }
    
    public void levelUpMage() {
        stats[2] += (int) (Math.random() * 2);
        stats[3] ++;
        stats[4] += (int) (Math.random() * 2)  + 2;
        stats[5] += (int) (Math.random() * 2);
        this.setCapMP(this.getCapMP() + 4);
        this.setCapHP(this.getCapHP() + 3);
        stats[0] = this.getCapHP();
        stats[1] = this.getCapMP();
        this.level ++;
    }
    
    public void levelUpRogue() {
        stats[2] += (int) (Math.random() * 2) + 1;
        stats[3] += (int) (Math.random() * 2)  + 1;
        stats[4] += (int) (Math.random() * 2)  + 1;
        stats[5] += (int) (Math.random() * 2) + 2;
        this.setCapMP(this.getCapMP() + 2);
        this.setCapHP(this.getCapHP() + 4);
        stats[0] = this.getCapHP();
        stats[1] = this.getCapMP();
        this.level ++;
    }
    
    //what if the mage potions while at lower hp with shield on?
    public void potion() {
        this.stats[0] += 10;
        if (this.stats[0] > this.getCapHP()) {
            this.stats[0] = this.getCapHP();
        }
        stats[6] = 0;
    }
    
    public void ether() {
        this.stats[1] += 5;
        if (this.stats[1] > this.getCapMP()) {
            this.stats[1] = this.getCapMP();
        }
        stats[6] = 0;
    }
    
    
    public void equipWep(Item item) {
        if (this.getWep() == false) {
            this.setAtk(item.getAtk() + this.getAtk());
            this.setDef(item.getDef() + this.getDef());
            this.setInt(item.getInt() + this.getInt());
            this.setSpd(item.getSpd() + this.getSpd());
            this.setWep(true);
        } else {
            System.out.println("Unequip the current weapon first.");
        }
    }
    
    public void unequipWep(Item item) {
        if (this.getWep() == true) {
            this.setAtk(this.getAtk() - item.getAtk());
            this.setDef(this.getDef() - item.getDef());
            this.setInt(this.getInt() - item.getInt());
            this.setAtk(this.getSpd() - item.getSpd());
            this.setWep(false);
        } else {
            System.out.println("You have no weapon to uneqip.");
        }
    }
    
    public void equipArmor(Item item) {
        if (this.getArmor() == false) {
            this.setCapHP(item.getHp() + this.getCapHP());
            this.setCapMP(item.getMp() + this.getCapMP());
            this.setDef(item.getDef() + this.getDef());
            this.setSpd(item.getSpd() + this.getSpd());
            this.setArmor(true);
        } else {
            System.out.println("Unequip the current armor first.");
        }
    }
    
    public void unequipArmor(Item item) {
        if (this.getArmor() == true) {
            this.setCapHP(this.getCapHP() - item.getHp());
            this.setCapMP(this.getCapMP() - item.getMp());
            this.setDef(this.getDef() - item.getDef());
            this.setSpd(this.getSpd() - item.getSpd());
            this.setArmor(false);
        } else {
            System.out.println("You have no armor to uneqip.");
        }
    }
    
    public void equipAcc(Item item) {
        if (this.getAcc() == false) {
            this.setCapHP(item.getHp() + this.getCapHP());
            this.setCapMP(item.getMp() + this.getCapMP());
            this.setAtk(item.getAtk() + this.getAtk());
            this.setDef(item.getDef() + this.getDef());
            this.setInt(item.getInt() + this.getInt());
            this.setSpd(item.getSpd() + this.getSpd());
            this.setAcc(true);
        } else {
            System.out.println("Unequip the current acessory first.");
        }
    }
    
    public void unequipAcc(Item item) {
        if (this.getAcc() == true) {
            this.setCapHP(this.getCapHP() - item.getHp());
            this.setCapMP(this.getCapMP() - item.getMp());
            this.setAtk(this.getAtk() - item.getAtk());
            this.setDef(this.getDef() - item.getDef());
            this.setInt(this.getInt() - item.getInt());
            this.setSpd(this.getSpd() - item.getSpd());
            this.setAcc(false);
        } else {
            System.out.println("You have no acessory to uneqip.");
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getXpgiven() {
        return xpgiven;
    }

    public void setXpgiven(int xpgiven) {
        this.xpgiven = xpgiven;
    }
    
}
