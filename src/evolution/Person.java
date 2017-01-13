package evolution;
import points.*;

public class Person {
	public double a;
	public double b;
	public double sigmaA;
	public double sigmaB;
	public double f;
	private Points p;
	
	public Person(double a, double b, Points p){
		this.a = a;
		this.b = b;
		this.p = p;
		this.f = p.fitnessFunction(a, b);
	}
	public Person(double a, double b, double sigmaA, double sigmaB, Points p){
		this.a = a;
		this.b = b;
		this.sigmaA = sigmaA;
		this.sigmaB = sigmaB;
		this.p = p;
		this.f = p.fitnessFunction(a, b);
	}
}
