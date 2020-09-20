package com.thepot;

public class IntegerToEnglish {


    private static final String[] nums = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static final String SPC = " ";

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglish().numberToWords(12345676));
    }

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }

        StringBuilder stringBuilder = new StringBuilder();

        int billion = num / 1000000000;

        if (billion > 0) {

            stringBuilder.append(nums[billion]).append(SPC).append("Billion");

            num = num - billion * 1000000000;
            appendSpace(num, stringBuilder);

        }

        int million = num / 1000000;

        if (million > 0) {
            stringBuilder.append(getHundreds(million)).append(SPC).append("Million");

            num = num - million * 1000000;
            appendSpace(num, stringBuilder);
        }


        int thousand = num / 1000;

        if (thousand > 0) {
            stringBuilder.append(getHundreds(thousand)).append(SPC).append("Thousand");
            num = num - thousand * 1000;
            appendSpace(num, stringBuilder);
        }

        return stringBuilder.append(getHundreds(num)).toString().trim();

    }

    private void appendSpace(int num, StringBuilder stringBuilder) {
        if (num > 0) {
            stringBuilder.append(SPC);
        }
    }

    private String getHundreds(int num) {
        int hundred = num / 100;
        StringBuilder stringBuilder = new StringBuilder();

        if (hundred > 0) {
            stringBuilder.append(getTens(hundred)).append(SPC).append("Hundred");

            num = num - hundred * 100;
            appendSpace(num, stringBuilder);
        }


        return stringBuilder.append(getTens(num)).toString();

    }

    private String getTens(int num) {
        if (num > 0 && num < 20) {

            return nums[num];

        } else {
            int ten = num / 10;
            num = num - ten * 10;

            return (tens[ten] + SPC + nums[num]).trim();
        }
    }

}
