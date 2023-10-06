public abstract class Customer {
    private char letter;

    private int number;
    private static int aCount = 1; private static int bCount = 1; private static int cCount = 1; private static int dCount = 1;

    Customer(){
        letter = 'X'; number = 0;
    }
    Customer(char newLetter){
        letter = newLetter;
        if (newLetter == 'A'){
            number = aCount++;
        }
        if (newLetter == 'B'){
            number = bCount++;
        }
        if (newLetter == 'C'){
            number = cCount++;
        }
        if (newLetter == 'D'){
            number = dCount++;
        }
        if (letter != 'A'&& letter != 'B'&& letter != 'C'&& letter != 'D'){
            letter = 'X'; number = 0;
            System.out.println("Error, letter must be A, B, C or D");
        }
    }
    protected String getTicketNumber(){
        return ""+letter+number;
    }
    public abstract String getCustomerInfo();
}