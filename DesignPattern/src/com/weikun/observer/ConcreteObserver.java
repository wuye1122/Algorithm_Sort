package com.weikun.observer;

/// <summary>
/// 具体观察者，实现抽象观察者角色所要求的更新接口，已是本身状态与主题状态相协调
/// </summary>
public class ConcreteObserver extends Observer{
    private String observerState;
    private String name;
    private ConcreteSubject subject;

    /// <summary>
    /// 具体观察者用一个具体主题来实现
    /// </summary>
    
    public ConcreteObserver(ConcreteSubject subject, String name){
        this.subject = subject;
        this.name = name;
    }

    public ConcreteSubject getSubject() {
		return subject;
	}

	public void setSubject(ConcreteSubject subject) {
		this.subject = subject;
	}

	/// <summary>
    /// 实现抽象观察者中的更新操作
    /// </summary>
    @Override
    public  void Update(){
       observerState = subject.getSubjectState();
       System.out.println("The observer's state of "+name+" is "+ observerState);
    }
}