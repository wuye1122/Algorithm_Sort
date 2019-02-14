package com.weikun.factorymethod;

//具体工厂
public class BullbCreator implements Creator{
     public Light factory(){
      return new BullbLight();
  }
}