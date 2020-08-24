package com.farazdurrani.dynamicschedular2;

import java.util.Random;

public class MyRunnable implements Runnable {

	private String taskName;
	
	private long sleepTime;
	
	private int executeCount = new Random().nextInt(3);

	public MyRunnable(String taskName, long sleepTime) {
		this.taskName = taskName;
		this.sleepTime = sleepTime * 1000L;
	}

	@Override
	public void run() {
		System.out.println("Running task  " + this.taskName + " in Thread ID: "
			+ Thread.currentThread()
				.getId() + " with execute count " + ++executeCount);
		System.out.println("Sleeping for " + this.sleepTime +" seconds.");
		try {
			Thread.sleep(this.sleepTime);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done Sleeping for " + this.sleepTime + " 5 seconds.");
	}

}
