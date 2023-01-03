package org.example;

import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;
public class HelloOtus {
    private static final String MODULE_NAME = "HelloOtus class";
    public static void main(String[] args) {
        System.out.println(MODULE_NAME);
        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(2);
        numbers.add(15);
        numbers.add(51);
        numbers.add(53);
        numbers.add(35);
        numbers.add(45);
        numbers.add(32);
        numbers.add(43);
        numbers.add(16);

        Ordering<Integer> ordering = Ordering.natural();
        System.out.println("Input List: ");
        System.out.println(numbers);
        System.out.println("*******************************");
        List<Integer> result = ordering.sortedCopy(numbers);
        System.out.println(result);
    }
}