package com.weikun.command;

/** 
 * «Î«Û’ﬂ 
 *  
 * @author hnylchf 
 *  
 */  
public class Invoker {  
  
    Command command;  
  
    public void startExceuteCommand(Command command) {  
        this.command = command;  
        command.exceute();  
    }  
  
  
}  