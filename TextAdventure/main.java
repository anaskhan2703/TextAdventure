import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;


public class main {
    public static void main(String[] args){

        //System objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //Enemy variables
        String[] enemies = {"Zombie", "Skeleton", "Rogue ninja", "Bounty hunter", "Wizard", "Giant"};
        String[] bosses = {"Dragon"};
        int maxhealth = 75, tier2maxhealth = 100, tier3maxhealth = 125, tier1ad = 15, tier2ad = 25, tier3ad = 35;

        //Player Variables
        int health = 100, ad = 50, potnum = 1, potheal = 25, potdrop = 50;

        boolean Run = true;

        System.out.println("Welcome to the deep dark dungeon");

        GAME:
        while (Run)
        {
            System.out.println("------------------------------");
            int enemyhealth = rand.nextInt(maxhealth);
            String currentEnemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\tCurrent enemy: " + currentEnemy + "\n");

            while (enemyhealth > 0)
            {
                System.out.println("\tYour health: " + health);
                System.out.println("\t" + currentEnemy + "'s health: " + enemyhealth);
                System.out.println("\tWhat should you do?");
                System.out.println("\t1) Attack");
                System.out.println("\t2) Heal from potions");
                System.out.println("\t3) Escape");

                String in = input.nextLine();
                if (in.equals("1"))
                {
                    int DealDamage = rand.nextInt(ad);
                    int TakeDamage = rand.nextInt(tier2ad);

                    health = health - TakeDamage;
                    enemyhealth = enemyhealth - DealDamage;

                    System.out.println("\tYou hit the enemy for " + DealDamage + " damage");
                    System.out.println("\tThe enemy did" + TakeDamage + " in return");

                    if (health < 1)
                    {
                        System.out.println("\tYou have taken too much damage. You are too weak to fight.");
                        break;
                    }

                }
                else if (in.equals("2"))
                {
                    if (potnum > 0)
                    {
                        health = health + potheal;
                        potnum = potnum - 1;
                        System.out.println("\tYou drank a health potion. You healed for " + potheal + " and you have" +
                                potnum + " potions left.");

                    }
                    else
                    {
                        System.out.println("\tYou have no health potions left. Defeat enemies for a chance to get one");
                    }

                }
                else if (in.equals("3"))
                {
                    System.out.println("\tYou run away from the " + currentEnemy);
                    continue GAME;

                }
                else
                {
                    System.out.println("Wrong input.");
                }

            }

            if (health < 1)
            {
                System.out.println("You have died.");
                break;
            }

            System.out.println("------------------------------");
            System.out.println(currentEnemy + " was defeated.");
            System.out.println("You have " + health + " HP left");
            if (rand.nextInt(100) < potdrop)
            {
            potnum = potnum + 1;
            System.out.println("enemy dropped a health potion");
            System.out.println("You now have " + potnum + " amount of potions");
            }
            System.out.println("------------------------------");
            System.out.println("what would you like to do?");
            System.out.println("1) Continue fighting");
            System.out.println("2) Exit");

            String in = input.nextLine();

            while (!in.equals("1") && !in.equals("2"))
            {
                System.out.println("Invalid command");
                in = input.next();
            }
            if (in.equals("1")){
                System.out.println("You continue on your adventure");
            }
            else if (in.equals("2")){
                System.out.println("You exit.");
            }

        }







    }
}


