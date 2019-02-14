package com.weikun.factorymethod;

public class Client{
	public static void main(String[] args){
		Creator create = new BullbCreator();
		Light bullbLight = create.factory();
		bullbLight.TurnOn();

		Creator create1 = new TubeCreator();
		Light tubebLight = create.factory();
		tubebLight.TurnOn();

	}
}
