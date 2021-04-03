package com.thepot;

public class CoinChange {

    public static void main(String[] args) {

//        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));

    }

    public int coinChange(int[] coins, int amount) {

        Integer[] memory = new Integer[amount + 1];


        int finalCount = coinChangeHelper(coins, amount, memory);


        if (finalCount == Integer.MAX_VALUE) {
            return -1;
        }

        return finalCount;


    }

    private int coinChangeHelper(int[] coins, int amount, Integer[] memory) {

        if (amount == 0) {
            return 0;
        }


        if (memory[amount] != null) {
            return memory[amount];
        }

        int min = Integer.MAX_VALUE;


        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {

                int leftAmount = amount - coins[i];

                int leftCount = coinChangeHelper(coins, leftAmount, memory);

                if (leftCount == Integer.MAX_VALUE) {
                    continue;
                }

                int finalCount = leftCount + 1;

                if (finalCount < min) {
                    min = finalCount;
                }
            }

        }

        memory[amount] = min;
        return min;
    }

}
