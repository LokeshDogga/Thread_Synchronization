package com.accolite.mini_au_java_assignment;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer_Consumer {

	Random count = new Random();
	@SuppressWarnings("rawtypes")
	BlockingQueue queue = new ArrayBlockingQueue(10);

	@SuppressWarnings("unchecked")
	void producer() throws InterruptedException {
		int temp = count.nextInt(100);
		System.out.println("Produced : " + temp);
		queue.put(temp);
	}
	void consumer() throws InterruptedException {
		System.out.println("consumed : " + 	queue.take() );
	}


	public static void main(String[] args) {
		Producer_Consumer pc = new Producer_Consumer();
		Thread produce = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					int count = 0;
					while(count < 10) {
						pc.producer();
						count++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}) ;
		Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					int count = 0;
					while(count < 10) {
						pc.consumer();
						count++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}) ;
		
		produce.start();
		consumer.start();

	}
}
