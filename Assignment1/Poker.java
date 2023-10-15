import java.util.ArrayList;
public class Poker {
    private PlayingCards deck;
    private ArrayList<String> hand1 = new ArrayList<String>();
    private ArrayList<String> hand2 = new ArrayList<String>();

    Poker() {
        this.deck = new PlayingCards();
        deck.Shuffle();
        dealHands();
    }
    Poker(ArrayList<String> hand1, ArrayList<String> hand2) {
        this.deck = new PlayingCards();
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public void dealHands() {
        for(int i=0;i<5;i++) {
            hand1.add(deck.getNextCard());
            hand2.add(deck.getNextCard());
        }
    }

    public void showHand(int x) {
        if (x == 1) {
            System.out.print("Player 1's Hand:\n");
            for (int i =0;i<5;i++){
                System.out.println(hand1.get(i)+",");
            }
        }
        else {
            System.out.print("Player 2's Hand:\n");
            for (int i =0;i<5;i++){
                System.out.println(hand2.get(i)+",");
            }
        }
    }
    public int[] countSuite(ArrayList<String> list){
        int[] suiteSplit = new int[4];
        for (int i=0;i<5;i++){
            String card =list.get(i);
            String[] suite = card.split("\\s");
            switch (suite[2]) {
                case ("Clubs") -> suiteSplit[0] += 1;
                case ("Diamonds") -> suiteSplit[1] += 1;
                case ("Hearts") -> suiteSplit[2] += 1;
                case ("Spades") -> suiteSplit[3] += 1;
            }
        }
        return suiteSplit;
    }
    public int[] countValues(ArrayList<String> list){
        int[] values = new int[13];
        for (int i=0;i<5;i++){
            String card =list.get(i);
            String[] suite = card.split("\\s");
            switch (suite[0]) {
                case ("A") -> values[0] += 1;
                case ("2") -> values[1] += 1;
                case ("3") -> values[2] += 1;
                case ("4") -> values[3] += 1;
                case ("5") -> values[4] += 1;
                case ("6") -> values[5] += 1;
                case ("7") -> values[6] += 1;
                case ("8") -> values[7] += 1;
                case ("9") -> values[8] += 1;
                case ("10") -> values[9] += 1;
                case ("J") -> values[10] += 1;
                case ("Q") -> values[11] += 1;
                case ("K") -> values[12] += 1;
            }
        }
        return values;
    }
    public int numPairs(int[] list){
        int pairs = 0;
        for (int i=0;i<13;i++){
            if (list[i]==2){
                pairs+=1;
            }
        }
        return pairs;
    }
    public int threeOfAKind(int[] list){
        int trips = 0;
        for (int i=0;i<13;i++){
            if (list[i]==3){
                trips = list[i];
            }
        }
        return trips;
    }
    public int fourOfAKind(int[] list){
        int quad = 0;
        for (int i=0;i<13;i++){
            if (list[i]==4){
                quad=list[i];
            }
        }
        return quad;
    }
    public boolean fullHouse(int[] list){
        return (threeOfAKind(list) !=0) && (numPairs(list) !=0);
    }
    public boolean straight(int[] list){
        boolean s = false;
        for(int i=0;i<9;i++){
            if(list[i]==1){
                if(list[i+1]==1){
                    if(list[i+2]==1){
                        if(list[i+3]==1){
                            if(list[i+4]==1){
                                s = true;
                            }
                        }
                    }
                }
            }
        }
        if(list[0]==1 && list[10]==1 && list[11]==1 && list[12]==1){
            s = true;
        }
        return s;
    }
    public boolean flush (int[] list){
        boolean f = false;
        for(int i=0;i<4;i++){
            if (list[i] == 5) {
                f = true;
                break;
            }
        }
        return f;
    }
    public boolean straightFlush(int[] values,int[] suite){
        return (straight(values)) && (flush(suite));
    }
    public boolean royalFlush(int[] values,int[] suite){
        return (flush(suite) && (values[0]==1 && values[10]==1 && values[11]==1 && values[12]==1));
    }
    public String scoreHand(int player){
        if (player==1){
            if (royalFlush(countValues(hand1), countSuite(hand1))){ return "Royal Flush";}
            else if (straightFlush(countValues(hand1), countSuite(hand1))){return "Straight Flush";}
            else if (fourOfAKind(countValues(hand1))!=0){return "Four of a Kind";}
            else if (fullHouse(countValues(hand1))){return "Full House";}
            else if (flush(countSuite(hand1))){return "Flush";}
            else if (straight(countValues(hand1))){return "Straight";}
            else if (threeOfAKind(countValues(hand1))!=0){return "Three of a Kind";}
            else if (numPairs(countValues(hand1))==2){return "2 Pairs";}
            else if (numPairs(countValues(hand1))==1){return "1 Pair";}
            else { return "High Card";}
        }
        else {
            if (royalFlush(countValues(hand2), countSuite(hand2))){ return "Royal Flush";}
            else if (straightFlush(countValues(hand2), countSuite(hand2))){return "Straight Flush";}
            else if (fourOfAKind(countValues(hand2))!=0){return "Four of a Kind";}
            else if (fullHouse(countValues(hand2))){return "Full House";}
            else if (flush(countSuite(hand2))){return "Flush";}
            else if (straight(countValues(hand2))){return "Straight";}
            else if (threeOfAKind(countValues(hand2))!=0){return "Three of a Kind";}
            else if (numPairs(countValues(hand2))==2){return "2 Pairs";}
            else if (numPairs(countValues(hand2))==1){return "1 Pair";}
            else { return "High Card";}
        }
    }
}
