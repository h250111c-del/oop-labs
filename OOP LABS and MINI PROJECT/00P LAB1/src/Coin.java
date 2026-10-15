import java.util.EnumMap;
import java.util.Map;

// Each constant carries its value in cents, set through a private constructor.
enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int value;

    Coin(int value) { this.value = value; }

    int value() { return value; }

    // Fewest coins for 'amount' cents. Greedy works because US denominations
    // are a canonical coin system. values() is in ascending order, so walk it backwards.
    static Map<Coin, Integer> fewestCoins(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Negative amount");
        Map<Coin, Integer> result = new EnumMap<>(Coin.class);
        Coin[] coins = values();
        for (int i = coins.length - 1; i >= 0; i--) {
            int count = amount / coins[i].value;
            if (count > 0) {
                result.put(coins[i], count);
                amount %= coins[i].value;
            }
        }
        return result;
    }

    static int totalCoins(Map<Coin, Integer> change) {
        return change.values().stream().mapToInt(Integer::intValue).sum();
    }
}
 class CoinDemo {
    public static void main(String[] args) {
        int[] amounts = {0, 1, 30, 41, 99, 100, 168};
        for (int amount : amounts) {
            Map<Coin, Integer> change = Coin.fewestCoins(amount);
            System.out.println(amount + " cents -> " + change
                    + " (" + Coin.totalCoins(change) + " coins)");
        }
    }
}