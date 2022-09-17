package tests;

import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	
	@Test
	public void threeTest() throws InterruptedException {
		System.out.println("this is threeTest");
		Thread.sleep(1000);
	}

}
