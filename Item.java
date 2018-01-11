package legend;

//how do i connect method of using potion

public class Item {
    
    private String name;
    private int atk;
    private int def;
    private int intel;
    private int spd;
    private int hp;
    private int mp;
    private int quantity;

    public Item (String name, int hp, int mp, int atk, int def, int intel, int spd, int quantity) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.intel = intel;
        this.spd = spd;
        this.hp = hp;
        this.mp = mp;
        this.quantity = quantity;
    }
    
    public Item (String name, int quantity) {
        this.name = name;
        this.atk = 0;
        this.def = 0;
        this.intel = 0;
        this.spd = 0;
        this.hp = 0;
        this.mp = 0;
        this.quantity = quantity;
    }
  
    public int getHp() {
        return this.hp;
    }
    
    public int getMp() {
        return this.mp;
    }
    
    public int getAtk() {
        return this.atk;
    }
    
    public int getDef() {
        return this.def;
    }
    
    public int getSpd() {
        return this.spd;
    }
    
    public int getInt() {
        return this.intel;
    }
   
    
    
}
