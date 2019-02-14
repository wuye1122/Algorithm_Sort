package com.weikun.factorymethod;

//具体工厂
public class TubeCreator implements Creator{
     public Light factory(){
      return new TubeLight();
  }
}