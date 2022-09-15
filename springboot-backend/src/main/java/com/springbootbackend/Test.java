package com.springbootbackend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.springbootbackend.model.User;

public class Test {
	public static void main(String ar[]) {

		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 2; i <= 4; i++) {
			Runnable number = new Numbers(i);
			executor.execute(number);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		// System.out.println("Finished all threads");

	}

}

class Numbers implements Runnable {
	private int num;

	public Numbers(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(num+" * "+i+" = "+num*i);
		}
	}

}