package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(num -> num * 3 + 2)
                .reduce((numA, numB) -> numA + numB)
                .get();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> outputArrayList = new ArrayList<>();
        for (Integer num : arrayList) {
            if (num % 2 != 0) {
                outputArrayList.add(num * 3 + 2);
            } else {
                outputArrayList.add(num);
            }
        }
        return outputArrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(num -> num % 2 != 0)
                .map(num -> num * 3 + 5)
                .reduce((numA, numB) -> numA + numB)
                .get();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> outputArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            outputArrayList.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return outputArrayList;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        if (arrayList.size() % 2 == 0) {
            return (double) (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2;
        } else {
            return arrayList.get(arrayList.size()/2);
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList = arrayList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        return evenList.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .distinct()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> outputArrayList = new ArrayList<>();
        List<Integer> evenList = arrayList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream()
                .filter(num -> num % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        outputArrayList.addAll(evenList);
        outputArrayList.addAll(oddList);
        return outputArrayList;
    }
}
