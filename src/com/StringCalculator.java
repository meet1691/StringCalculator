package com;

import java.util.ArrayList;

public class StringCalculator extends Exception {

    public int add(String numbers) {

        int sum = 0;

        if (numbers.isEmpty())
            return 0;
        else {

            String[] elements = numbers.split(",");
            ArrayList<String> listOfNegative = new ArrayList<>();

            for (String element : elements) {
                if (element.contains("-")) {
                    listOfNegative.add(element);
                    continue;
                }
                // here I assume 1000 should be allowed to add . If not then code should be "if (element.length()>3){...}"
                if (!element.equals("1000") && element.length() > 3) {
                    continue;
                }
                if (element.contains("\n")) {
                    char[] charWithSpace = element.toCharArray();
                    for (char digit : charWithSpace) {
                        if (Character.isDigit(digit)) {
                            int numberInString = Integer.parseInt(Character.toString(digit));
                            sum += numberInString;
                        }

                    }
                    continue;
                }
                try {
                    int num = Integer.parseInt(element);
                    sum += num;
                } catch (NumberFormatException nfe) {
                    char current = element.charAt(0);
                    int index = current - 'a' + 1;
                    sum += index;
                }
            }

            if (listOfNegative.size() > 0) {
                throw new IllegalArgumentException("Negative Numbers Are :" + listOfNegative);
            }

        }

        return sum;
    }


}
