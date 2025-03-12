package org.example;

public class PracticeTask1 implements PracticeTask {
    private int[] array;

    public PracticeTask1(int arrayLength){
        array = new int[arrayLength];
        fillArrayWithRandomNumbers(-100, 100);
    }

    public void run(){
        System.out.println("Задача 1");
        printArray();
        var sumPositives = getSumOfPositiveNumbers();
        System.out.println(sumPositives + "\n");
    }

    private void fillArrayWithRandomNumbers(int lowerLimit, int upperLimit){
        for(var i = 0; i < array.length; i++){
            var deviation = (int)Math.round(Math.random() * (upperLimit - lowerLimit));
            var randomNumber = lowerLimit + deviation;
            array[i] = randomNumber;
        }
    }

    private void printArray(){
        for(int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private int getSumOfPositiveNumbers(){
        int sumPositives = 0;
        for(int j : array){
            if(j > 0){
                sumPositives += j;
            }
        }
        return sumPositives;
    }
}
