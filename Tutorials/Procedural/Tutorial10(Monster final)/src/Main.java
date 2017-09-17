import java.util.Scanner;

import MonsterTwo.MonsterTwo;
import org.apache.commons.lang3.ArrayUtils;

// Basic class definition
// public means this class can be used by other classes
// Class names should begin with a capital letter
// A file can't contain two public classes. It can contain classes that are not public
// If you place class files in the same folder the java compiler will be able to find them
/* The Goal of this tutorial is to make a game like this
------------------------------
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||M||F||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|P||*||*||*||*||*||*||*||*||*|
|*||*||*||*||D||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
------------------------------
[9,9]
 */
public class Main {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        MonsterTwo.buildBattleBoard();

        char[][] tempBattleBoard = new char[10][10];

        //Creating objects of 1 Monster
        //ObjectName[] Monsters = new MonsterTwo;

        MonsterTwo[] Monsters = new MonsterTwo[4];

        Monsters[0] = new MonsterTwo(1000,20,1,"Frank"); // Creating 1 Monster
        Monsters[1] = new MonsterTwo(500,40,2,"Drac");// Creating 2 Monster
        Monsters[2] = new MonsterTwo(750,30,3,"Paul");// Creating 3 Monster
        Monsters[3] = new MonsterTwo(1250,15,4,"George");// Creating 4 Monster

        MonsterTwo.redrowBoard();

        for(MonsterTwo m : Monsters)
        {
            if(m.getAlive())
            {
                int arrayItemIndex = ArrayUtils.indexOf(Monsters, m);
                m.moveMonster(Monsters, arrayItemIndex);
            }
        }

        MonsterTwo.redrowBoard();
    }

}