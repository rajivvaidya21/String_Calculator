package Calculator;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int add(@NotNull String str) throws Exception {

        String[] numbers = str.split("[^0-9-]");
        int totalSum=0;
        for (String num : numbers) {
            try {
               int tNum = Integer.parseInt(num);
                if (tNum < 0){
                    throw new RuntimeException("negatives not allowed :: " + negativeNumbers(numbers));
                }
                else
                    totalSum += tNum;
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
            }
        }
        return totalSum;
    }

    private List negativeNumbers(String[] numbers) {
        return Arrays.stream(numbers).filter(i -> Integer.parseInt(i) < 0).collect(Collectors.toList());
    }

    public static void main(String args[]){

    }
}