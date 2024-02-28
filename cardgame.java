import java.util.*;

class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class cardgame {
    public static void main(String[] args) {
        collectAndGroupCards();
    }

    private static void collectAndGroupCards() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Cards: ");
        int numCards = scanner.nextInt();
        Map<String, List<Card>> cardMap = new HashMap<>();

        for (int i = 1; i <= numCards; i++) {
            System.out.println("Enter card " + i + ":");
            String symbol = scanner.next().toLowerCase();
            int number = scanner.nextInt();

            
            Card card = new Card(symbol, number);

            if (!cardMap.containsKey(symbol)) {
                cardMap.put(symbol, new ArrayList<>());
            }
            cardMap.get(symbol).add(card);
        }

        
        List<String> distinctSymbols = new ArrayList<>(cardMap.keySet());
        Collections.sort(distinctSymbols);
        System.out.println("\nDistinct Symbols are: " + String.join(" ", distinctSymbols));

        for (String symbol : distinctSymbols) {
            System.out.println("\nCards in " + symbol.toUpperCase() + " Symbol");
            List<Card> cards = cardMap.get(symbol);
            int totalCards = cards.size();
            int totalSum = cards.stream().mapToInt(card -> card.number).sum();

            for (Card card : cards) {
                System.out.println(card.symbol + " " + card.number);
            }

            System.out.println("Number of cards : " + totalCards);
            System.out.println("Sum of Numbers : " + totalSum);
        }

        scanner.close();
    }
}