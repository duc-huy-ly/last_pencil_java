package lastpencil;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] Players = {"John", "Jack"};
        String firstPlayer = "";
        int nPencils = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isValidNumberOfPencils = false;
        System.out.println("How many pencils would you like to use:");
        while (!isValidNumberOfPencils){
            try {
                int userInput = Integer.parseInt(scanner.nextLine().trim());
                if (userInput <= 0) {
                    throw new IllegalArgumentException("The number of pencils should be positive\"");
                }
                nPencils = userInput;
                isValidNumberOfPencils = true;
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            } catch (IllegalArgumentException e2) {
                System.out.println("The number of pencils should be positive");
            }
        }

        // Determine who plays first
        System.out.println("Who will be the first (John, Jack):");
        boolean isValidPlayerChoice = false;
        while (!isValidPlayerChoice) {
            try {
                firstPlayer = scanner.next();
                if (!firstPlayer.equals(Players[0]) && !firstPlayer.equals(Players[1])) {
                    throw new IllegalArgumentException("name not correct");
                }
                isValidPlayerChoice = true;

            } catch (IllegalArgumentException e) {
                System.out.println("Choose between John and Jack");
            }
        }

        int counter = 0;
        if (firstPlayer.equals("Jack")) {
            counter++;
        }
        int pencilsToSubtract = 0;

        while (nPencils > 0) {
            System.out.println("|".repeat(nPencils));
            System.out.println(Players[counter%2] + "'s turn");
            String currentPlayer = Players[counter%2];
            if (currentPlayer.equals("John")) {
                boolean inputValueIsCorrect = false;
                while (!inputValueIsCorrect) {
                    try {
                        pencilsToSubtract = Integer.parseInt(scanner.next());

                        if (pencilsToSubtract < 1 || pencilsToSubtract > 3) {
                            throw new NumberFormatException();
                        }
                        if (pencilsToSubtract > nPencils) {
                            throw new IllegalArgumentException();
                        }
                        inputValueIsCorrect = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Possible values: '1', '2' or '3'");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Too many pencils were taken");
                    }
                }
            } else if (currentPlayer.equals("Jack")) {
                Random random = new Random();
                if (nPencils > 1) {
                    if (nPencils % 4 == 1) {
                        pencilsToSubtract = random.nextInt(3) + 1;
                    } else if (nPencils % 4 == 2) {
                        pencilsToSubtract = 1;
                    } else if (nPencils % 4 == 3) {
                        pencilsToSubtract = 2;
                    } else if (nPencils % 4 == 0) {
                        pencilsToSubtract = 3;
                    }
                } else {
                    pencilsToSubtract = 1;
                }
                System.out.println(pencilsToSubtract);
            }
            nPencils -= pencilsToSubtract;
            counter++;
        }
        System.out.println(Players[counter%2]+ " won!");
    }





}
