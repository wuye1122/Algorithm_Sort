package com.weikun.factorymethod;

//���幤��
public class BullbCreator implements Creator{
     public Light factory(){
      return new BullbLight();
  }
}