package com.farazdurrani.dynamicschedular;

import java.util.Random;

public class MyRunnable implements Runnable {

	private String taskName;
	
	private int executeCount = new Random().nextInt(3);

	public MyRunnable(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println("Running task  " + this.taskName + " in Thread ID: "
			+ Thread.currentThread()
				.getId() + " with execute count " + ++executeCount);
	}

}
