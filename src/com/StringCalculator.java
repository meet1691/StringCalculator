package com;

public class StringCalculator {
    public int add(String numbers){

        int sum = 0 ;

        if (numbers.isEmpty())
            return 0;
        else {

            String[] elements = numbers.split(",");
            for (String element: elements){
                try {
                    int num = Integer.parseInt(element);
                    sum+=num;
                } catch (NumberFormatException nfe) {
                    char current = element.charAt(0);
                    int index = current -'a'+1 ;
                    sum+=index;
                }
            }
        }

        return sum;
    }

}
