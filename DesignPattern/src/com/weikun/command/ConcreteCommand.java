package com.weikun.command;

/** 
 * ¾ßÌåÃüÁî 
 *  
 * @author hnylchf 
 *  
 */  
public class ConcreteCommand implements Command {  

	Receiver receiver;  

	public ConcreteCommand(Receiver receiver) {  
		this.receiver = receiver;  
	}  

	

	@Override
	public void exceute() {
		// TODO Auto-generated method stub
		receiver.sendMessage();  
	}  
}  
