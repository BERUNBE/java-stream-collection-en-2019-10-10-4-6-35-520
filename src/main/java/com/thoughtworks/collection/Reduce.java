package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                .reduce(Integer::max)
                .orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream()
                .reduce(Integer::min)
                .orElse(0);
    }

    public double getAverage() {
        return arrayList.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(Double::sum)
                .orElse(0.0) / arrayList.size();
    }

    public double getOrderedMedian() {
        if (arrayList.size() % 2 == 0) {
            return (double) (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2;
        } else {
            return arrayList.get(arrayList.size()/2);
        }
    }

    public int getFirstEven() {
        return arrayList.stream()
                .filter(a -> a % 2 == 0)
                .reduce((a, b) -> a)
                .orElse(0);
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(arrayList.stream()
                .filter(a -> a % 2 == 0)
                .reduce((a, b) -> a)
                .orElse(0));
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        if (arrayList.size() % 2 == 0) {
            return (double) (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2;
        } else {
            return (double) arrayList.get(arrayList.size()/2);
        }
    }

    public int getLastOdd() {
        return arrayList.stream()
                .filter(a -> a % 2 != 0)
                .reduce((a, b) -> b)
                .orElse(0);
    }

    public int getIndexOfLastOdd() {
        return arrayList.indexOf(arrayList.stream()
                .filter(a -> a % 2 != 0)
                .reduce((a, b) -> b)
                .orElse(0));
    }
}
