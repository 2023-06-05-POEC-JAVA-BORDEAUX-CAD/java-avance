package fr.maboite.tests;

public class AreaCalculator {

	public Integer calcSquareArea(Integer edge) {
		return edge*edge;
	}
	
	
	public Double calcCircleAera(Double radius) {
		if(radius < 0) {
			throw new IllegalArgumentException();
		}
		
		return Math.PI*radius*2;
	}
	
}
