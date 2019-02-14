package com.weikun.command;
/*
 * 
 * 结构：
命令者模式包括四种角色
接收者：接受者是一个类的实例，该实例负责执行与请求相关的操作
命令：命令是一个接口，规定了用来封装请求的若干个方法。
具体命令：具体命令是实现命令接口的类的实例，具体命令必须实现命令接口中的方法。
请求者：请求者是一个包含”命令接口“变量的类的实例。
请求者中的”命令“接口的变量可以存放任何具体命令的引用，请求者负责调用具体命令，让具体命令执行那些封装了请求的方法
 */
public class Test {


	public static void main(String[] args) {  
		Receiver receiver = new Receiver();  //执行者  
		Command command = new ConcreteCommand(receiver); //命令和具体命令  
		Invoker invoker = new Invoker(); //请求者  
		invoker.startExceuteCommand(command); //请求者下达命令  
	}  


}
