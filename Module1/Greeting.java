package Module1;

import java.util.Scanner;
public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What do you do for work?");
        String work = scanner.nextLine();
        System.out.println("Hello, " + name + "! It's great to know that you work as a " + work + ".");
        scanner.close();
    }

}