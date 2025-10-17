import java.util.Scanner;
//scanner to get user input
public class PetSelector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //get user input

        String color = "";
        String season = "";
        String name = "";
        String pet = "";

        // Colors
        //Pre con-Ask user for favorite color - color must be red blue or green
        //post con- color is red blue or green
        System.out.print("Enter your favorite color (red, blue, or green)-all lowercase: ");
        color = input.nextLine().toLowerCase();
        if (color.equals("red") || color.equals("blue") || color.equals("green")) {
            System.out.println("Your favorite color is " + color);
        } else {
            System.out.print("Invalid color, please try again.");
            input.close();
            return;
        }

        // Seasons
        //Pre con- Ask user for favorite season - season must be winter spring summer or fall
        //post con- season is winter spring summer or fall
        System.out.println("Enter your favorite season(winter, spring, summer, or fall)-all lowercase");
        season = input.nextLine().toLowerCase();
        if (season.equals("winter") || season.equals("summer") || season.equals("spring") || season.equals("fall")) {
            System.out.println("Your favorite season is " + season);
        } else {
            System.out.print("Invalid season, please try again.");
            input.close();
            return;
        }

        // Name
        //Pre con- Ask user for their name - name must start with a letter
        //post con- name starts with a letter
        System.out.println("Enter your name: ");
        name = input.nextLine().toLowerCase();
        if (name.length() > 0 && Character.isLetter(name.charAt(0))) {
            System.out.println("Your name is : " + name);
        } else {
            System.out.println("Invalid name, name must start with a letter");
            input.close();
            return;
        }

        //Pre con - Determines if name starts with a vowel or consonant
        //post con- first letter of name is determined to be vowel or consonant if firstLetter is a vowel
        char firstLetter = Character.toLowerCase(name.charAt(0));
        boolean startsVowel = "aeiou".indexOf(firstLetter) >= 0;

        //Post Con - Determines pet based on rules
        //Pre con - all inputs are valid
        // Rule 1 Pre con - color is blue and season is fall
        //post con - pet is alligator
        if (color.equals("blue") && season.equals("fall")) {
            pet = "Alligator";
        }
        // Rule 2 pre con - color is blue and season is spring
        // post con - pet is ostrich
        else if (color.equals("blue") && season.equals("spring")) {
            pet = "Ostrich";
        }
        // Rule 3 - pre con - color is green and name starts with consonant and season is winter
        // post con - pet is giraffe
        else if (color.equals("green") && !startsVowel && season.equals("winter")) {
            pet = "Giraffe";
        }
        // Rule 4 - pre con - color is green and season is not fall
        // post con - pet is dog
        else if (color.equals("green") && !season.equals("fall")) {
            pet = "Dog";
        }
        // Rule 5 - pre con - color is red
        // post con - pet is porcupine if name starts with vowel else panda
        else if (color.equals("red")) {
            if (startsVowel) {
                pet = "Porcupine";
            } else {
                pet = "Panda";
            }
        }
        // Rule 6 - pre con - season is summer and pet is not dog panda or porcupine
        // post con - pet is pony
        else if (season.equals("summer") && !(pet.equals("Dog") || pet.equals("Panda") || pet.equals("Porcupine"))) {
            pet = "Pony";
        }
        // Rule 7 - pre con - name starts with consonant and color is blue and season is not summer or fall
        // post con - pet is axolotl if they didn't already get an ostrich
        else if (!startsVowel && color.equals("blue") && !season.equals("summer") && !season.equals("fall")) {
            // only if they didn't already get an ostrich
            if (!pet.equals("Ostrich")) {
                pet = "Axolotl";
            }
        }
        // Rule 8 - pre con - none of the above rules apply
        // post con - pet is rock
        else {
            pet = "Pet Rock";
        }

        //Outputted result
        System.out.println("Your perfect pet is: " + pet);

        input.close();
    }
}
