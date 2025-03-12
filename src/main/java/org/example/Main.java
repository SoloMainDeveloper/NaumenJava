package org.example;

public class Main {
    public static void main(String[] args) {
        var tasks = new PracticeTask[] {
                new PracticeTask1(20),
                new PracticeTask2(20),
                new PracticeTask3("Sales"),
                new PracticeTask4(),
                new PracticeTask5()
        };
        for (var task : tasks) {
            task.run();
        }
    }
}