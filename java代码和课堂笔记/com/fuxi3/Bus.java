package com.fuxi3;

//实现接口必须要实现接口里面的所有的方法
public class Bus implements Car, Traffic {

	public void run() {
		System.out.println("running");
	}

	public int getMaxSpeed() {
		return 320;
	}

	public int getType() {
		return 1;
	}

}
