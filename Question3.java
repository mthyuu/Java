import java.util.ArrayList;
import java.util.Scanner;
public class Question3 extends Throwable{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // In order to change the answer, only change the answer string
        String answer = "trashcan";
        boolean playAgain = true;

        String guess;
        boolean correct = false;
        while (playAgain){
            while (!correct){
                try {
                    do {
                        //takes input of guess and answer, takes it to bullsAndCows for output
                        System.out.println("Answer is "+answer.length()+" letters long");
                        System.out.print("Enter your guess: ");
                        guess = sc.nextLine().toLowerCase();
                        if (guess.length() < answer.length()){
                            throw new IndexOutOfBoundsException();
                        }
                        dogsAndCats(guess,answer);
                        if (guess.equals(answer)){
                            correct = true;
                        }
                        System.out.print("");
                    }while (!correct);
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("Please enter the proper guess length\n");
                }
            }
            System.out.println("\nYou're correct, congrats!\nWould you like to play again? (Y/N)");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("y")){
                System.out.println("Please choose a new word: ");
                answer = sc.nextLine().toLowerCase();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                correct = false;
            }
            else {
                playAgain = false;
            }
        }
        System.out.println("\nThanks for playing!");
    }

    public static void dogsAndCats(String guess, String answer){
        //initializes array that holds characters for the guess
        char[] gus = new char[guess.length()];

        //fills the guess array with characters of guess
        for (int i=0;i<guess.length();i++){
            gus[i] = guess.charAt(i);
        }

        //using arraylist to initialize answer because of ".contains()" command
        ArrayList<Character> march = new ArrayList<>();

        //fills the answer array with characters of answer
        for (int i=0;i<answer.length();i++){
            march.add(answer.charAt(i));
        }
        int dogs = 0;
        int cats = 0;

        for (int i=0;i< gus.length;i++){
            //checks to see if corresponding letter in answer and guess match
            //if so, adds one bull
            if (gus[i] == march.get(i)){
                dogs++;
            }
            //checks to see if any letters of guess is contained within the answer
            //if so, adds one cow
            else if (march.contains(gus[i])){
                cats++;
            }
        }
        //if the guess is not equal to the answer, prints num of dogs and cats
        if (!(guess.equals(answer))){
            System.out.println("Dogs: "+dogs+" Cats: "+cats);
        }
    }
}
