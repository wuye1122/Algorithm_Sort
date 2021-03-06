package com.weikun.observer;

import java.util.ArrayList;
import java.util.List;

/// 抽象主题类
/// </summary>
public abstract class Subject{
    private List<Observer> observers = new ArrayList<Observer>();

    /// <summary>
    /// 增加观察者
    /// </summary>
    /// <param name="observer"></param>
    public void Attach(Observer observer)  {
        observers.add(observer);
    }

    /// <summary>
    /// 移除观察者
    /// </summary>
    /// <param name="observer"></param>
    public void Detach(Observer observer) {
        observers.remove(observer);
    }

    /// <summary>
    /// 向观察者（们）发出通知
    /// </summary>
    public void Notify()
    {
        for (Observer o : observers){
            o.Update();
        }
    }
}