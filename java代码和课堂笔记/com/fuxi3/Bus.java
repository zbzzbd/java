package com.fuxi3;

//ʵ�ֽӿڱ���Ҫʵ�ֽӿ���������еķ���
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
