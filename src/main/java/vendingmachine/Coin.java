package vendingmachine;

import java.util.*;

public class Coin {
    private final int value;

    static final int _500 = 500;
    static final int _100 = 100;
    static final int _50 = 50;
    static final int _10 = 10;
    private static final List<Integer> COIN_SET = Arrays.asList(_500,_100,_50, _10);

    Coin(final int change){

        if(!COIN_SET.contains(change)){
            throw new IllegalArgumentException();
        }

        this.value = change;
    }

    @Override
    public String toString() {
        return "Coin{}";
    }
}
