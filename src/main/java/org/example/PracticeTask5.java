package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.lang.Thread;

public class PracticeTask5 implements PracticeTask {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public PracticeTask5(){
        String[] queue1 = { "Walter White", "Mike Ermontraud", "Jesse Pinkman", "Saul Goodman" };
        tasks.add(new DataProcessing("Breaking Bad",  new LinkedList<>(Arrays.asList(queue1))));
        String[] queue2 = { "Metallica", "Guns N Roses", "Nirvana", "Queen", "AC/DC", "Pink Floyd", "RHCP", "SoAD", "Linkin Park" };
        tasks.add(new DataProcessing("Rock bands", new LinkedList<>(Arrays.asList(queue2))));
        String[] queue3 = { "Lil Peep", "Post Malone", "Eminem", "Juice WRLD", "MGK" };
        tasks.add(new DataProcessing("Hip-hop", new LinkedList<>(Arrays.asList(queue3))));
    }

    public void run(){
        System.out.println("Задача 5" + "\n");
        tasks.forEach(Task::start);
        System.out.println();
    }

    private class DataProcessing implements Task {
        private String name;
        private final LinkedList<String> queue;
        private boolean isRunning = true;

        public DataProcessing(String name, LinkedList<String> queue){
            this.name = name;
            this.queue = queue;
        }

        public void start(){
            int workTime;
            System.out.println("Обработка данных " + name + " началась");
            while(isRunning && !queue.isEmpty()){
                try {
                    workTime = (int)Math.round(Math.random() * 2000);
                    Thread.sleep(workTime);
                    if(workTime > 1500){
                        stop();
                    } else {
                        var current = queue.remove();
                        System.out.println("Пакет данных " + current + " обработан за " + workTime + " мс");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            printEndMessage();
        }

        public void stop(){
            isRunning = false;
        }

        private void printEndMessage(){
            if(queue.isEmpty()){
                System.out.println("Обработка данных " + name + " завершена успешно.\n");
            } else {
                System.out.println("Обработка данных " + name + " прервана. Необработанных пакетов: " + queue.size() + "\n");
            }
        }
    }
}
