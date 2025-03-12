package org.example;

public class PracticeTask2 implements PracticeTask {
    private double[] array;

    public PracticeTask2(int arrayLength) {
        array = new double[arrayLength];
        fillArrayWithRandomNumbers(-100, 100);
    }

    public void run(){
        System.out.println("Задача 2");
        printArray();
        quickSort(0, array.length - 1);
        printArray();
        System.out.println();
    }

    private void fillArrayWithRandomNumbers(double lowerLimit, double upperLimit){
        for(var i = 0; i < array.length; i++){
            var deviation = Math.random() * (upperLimit - lowerLimit);
            var randomNumber = lowerLimit + deviation;
            array[i] = randomNumber;
        }
    }

    private void printArray(){
        for(double j : array){
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private void quickSort(int low, int high){
        if(low < high){
            var pivot = partition(low, high);
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    private int partition(int low, int high){
        var pivot = array[high];

        var i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                var temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        var temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
