package com.accolite.mini_au_java_assignment;

public class Even_Odd implements Runnable {

	private static int count = 0;

	Even_Odd(int count){
		super();
		this.count = count;
	}

	public static void increment(){
		count++;
	}

	synchronized void print_even() throws InterruptedException {
		//wait();
		increment();
		System.out.println("even "+ count);
		notifyAll();
	}

	synchronized void print_odd() throws InterruptedException {
		//wait();
		increment();
		System.out.println("odd  "+ count);
		notifyAll();
	}

	@Override
	synchronized public void  run() {
		for(int i = 0;i < 10;i++) {
			try {
				if(Thread.currentThread().getName().equals("odd")) {
					print_odd();
					wait();
				}
				else {
					print_even();
					wait();
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		Even_Odd obj=new Even_Odd(-1);
		Thread even = new Thread(obj , "even");
		Thread odd = new Thread(obj , "odd");
		even.start();
		odd.start();
	}
}
