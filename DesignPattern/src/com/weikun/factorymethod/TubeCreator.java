package com.weikun.factorymethod;

//���幤��
public class TubeCreator implements Creator{
     public Light factory(){
      return new TubeLight();
  }
}