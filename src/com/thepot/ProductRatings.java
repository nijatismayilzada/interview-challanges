package com.thepot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRatings {

    public static void main(String[] args) {
        System.out.println(fiveStarReviews(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(1, 3)))), 50));


    }

    public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingThreshold) {
        int additions = 0;

        double total = 0;
        for (List<Integer> prods : productRatings) {
            total = total + prods.get(0).doubleValue() / prods.get(1).doubleValue();
        }

        double currentRating = total / productRatings.size() * 100;


        while (ratingThreshold - currentRating > 0) {
            additions++;

            double maximumEfficiency = 0;
            int indexToAdd = 0;
            for (int i = 0; i < productRatings.size(); i++) {
                List<Integer> prod = productRatings.get(i);

                double rate = prod.get(0).doubleValue() / prod.get(1).doubleValue() * 100;

                double increasedRate = (prod.get(0).doubleValue() + 1) / (prod.get(1).doubleValue() + 1) * 100;

                if (increasedRate - rate >= maximumEfficiency) {
                    maximumEfficiency = increasedRate - rate;
                    indexToAdd = i;
                }

            }
            List<Integer> prodToAdd = productRatings.get(indexToAdd);
            int e = prodToAdd.get(0) + 1;
            int e1 = prodToAdd.get(1) + 1;
            prodToAdd.clear();
            prodToAdd.add(e);
            prodToAdd.add(e1);


            total = 0;
            for (List<Integer> prods : productRatings) {
                total = total + prods.get(0).doubleValue() / prods.get(1).doubleValue();
            }

            currentRating = total / productRatings.size() * 100;

        }
        return additions;


    }

}
