package com.weikun.face;

public class Facade {  
    //ʾ�ⷽ��������ͻ�����Ҫ�Ĺ���  
    public void test(){  
        ModuleA a = new ModuleA();  
        a.testA();  
        ModuleB b = new ModuleB();  
        b.testB();  
        ModuleC c = new ModuleC();  
        c.testC();  
    }  
}  