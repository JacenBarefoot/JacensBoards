package com.company;
import java.sql.*;
import java.util.*;

public class Main {
    private String name;
    private String type;
    private Integer hp;
    private String description;

    Main(String name, String type, Integer hp, String description) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.description = description;
    }

    public String getPokeName() {
        return name;
    }

    public String toString() {
        return name + " - " + type + " - " + hp + " - " + description;
    }

    public static void main(String[] args) {
        List<Main> c = new ArrayList<Main>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner myObj = new Scanner(System.in);
        String action = "Hello World";
        do {
            System.out.println("[create] pokemon, view pokemon[name], view [all] pokemon, [update] pokemon, [delete] pokemon, or [quit]?");
            action = myObj.nextLine();
            switch (action) {
                case "create":
                    System.out.print("Name: ");
                    String pokeName = s1.nextLine();
                    System.out.print("Type: ");
                    String pokeType = s1.nextLine();
                    System.out.print("HP: ");
                    Integer pokeHp = s.nextInt();
                    System.out.print("Description: ");
                    String pokeDescription = s1.nextLine();
                    c.add(new Main(pokeName, pokeType, pokeHp, pokeDescription));
                    System.out.println(c);
                    break;
                case "name":
                    boolean found = false;
                    System.out.println("Enter a Pokemon's name:");
                    String pokName = s1.nextLine();
                    System.out.println("----------------------");
                    Iterator<Main> i = c.iterator();
                    while (i.hasNext()) {
                        Main e = i.next();
                        if (e.getPokeName().equals(pokName)) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Pokemon not found");
                    }

                    System.out.println("----------------------");
                    break;
                case "all":
                    boolean founds = false;
                    System.out.println("----------------------");
                    Iterator<Main> lil = c.iterator();
                    while (lil.hasNext()) {
                        Main e = lil.next();
                        System.out.println(e);
                        founds = true;
                    }
                    break;
                case "update":
                    found = false;
                    System.out.println("Enter a Pokemon's name to update :");
                    pokName = s1.nextLine();
                    System.out.println("----------------------");
                    ListIterator<Main>li = c.listIterator();
                    while (li.hasNext()) {
                        Main e = li.next();
                        if (e.getPokeName().equals(pokName)) {
                            System.out.println("Enter a new name for this Pokemon :");
                            pokeName = s1.nextLine();
                            System.out.println("Enter a new type for this Pokemon :");
                            pokeType = s1.nextLine();
                            System.out.println("Enter a new hp for this Pokemon :");
                            pokeHp = s.nextInt();
                            System.out.println("Enter a new description for this Pokemon :");
                            pokeDescription = s1.nextLine();
                            li.set(new Main(pokeName, pokeType, pokeHp, pokeDescription));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Pokemon not found");
                    }else{
                        System.out.println("Pokemon deleted successfully!");
                    }
                    System.out.println("----------------------");
                    break;
                case "delete":
                    found = false;
                    System.out.println("Enter a Pokemon's name to delete :");
                    pokName = s1.nextLine();
                    System.out.println("----------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Main e = i.next();
                        if (e.getPokeName().equals(pokName)) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Pokemon not found");
                    }else{
                        System.out.println("Pokemon deleted successfully!");
                    }
                    System.out.println("----------------------");
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("This is not a valid action!!!!!");
                    break;
            }
        } while (!action.equals("quit"));
    }
}
