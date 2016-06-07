package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import lab03.CalculD;
import lab03.FileAnalyser;

public class TestCalcul {

	CalculD c;
	public TestCalcul() throws FileNotFoundException, IOException{
		FileAnalyser fa = new FileAnalyser("data.csv");
		try {
			c = new CalculD();
			c.start(fa.loadFile());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculSlope() {
		assertEquals(1.72,c.calculateSlope(),0.01);
		
	}

	@Test
	public void testCalculCste() {
		c.calculateSlope();
		assertEquals(-22.55,c.calculateCste(),0.01);
		
	}
}
