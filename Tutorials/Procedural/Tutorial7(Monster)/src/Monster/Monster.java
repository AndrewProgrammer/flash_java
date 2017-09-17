package Monster;

public class Monster {

    public final  String TOMBSTONE = "Here Lies a Dead monster"; // final = const , so it is constant String

    private int health = 500;
    private int attack = 20;
    private int movement = 2;
    private int xPosition = 0;
    private int yPosition = 0;
    private boolean alive = true;

    public String name = "Big Monster";

    //Getters
    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getMovement() {
        return movement;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    //Setters

    // Expect set Setter setHealth , look below

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Overloading
    public  void setHealth(int decreaseHealth)
    {
        health -= decreaseHealth;
        if(health < 0)
        {
            alive = false;
        }
    }
    // Overloading
    public void setHealth(double decreaseHealth)
    {
        int intDecreaseHealth = (int) decreaseHealth;
        health -= intDecreaseHealth;
        if(health < 0)
        {
            alive = false;
        }
    }

    //Parametrized Constructor - name of Constructor is the same like name of Class
    public Monster (int health, int attack , int movement)
    {
        this.health = health;
        this.attack = attack;
        this.movement = movement;
    }

    //Default Constructor that we have createad by ourselves
    public Monster()
    {

    }

    public static void main(String[] args)
    {
        Monster Frank = new Monster(); // new Object of constructor method

        System.out.println(Frank.attack); // private field because mian is inside of class
    }

    //You can overload constructors like any other method
    //The following constructor is the one provided by default if you don`t create
    //Default Constructor
   /* public Monster(int newHealth)
    {
        health = newHealth;
    }

    public Monster(int newHealth, int newAttack)
    {
        this(newHealth); // newHealth of overloading method. Pretty simple. Just new Health
        attack = newAttack;
    }*/
}
