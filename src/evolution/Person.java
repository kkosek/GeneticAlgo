package evolution;

public class Person {
	public  double  a;
	public  double  b;
	public double sigmaA;
	public double sigmaB;
	public  double  f;
	public Person(double a,double b){
		this.a=a;
		this.b=b;
		f=a*b;
	}
	public Person(double a,double b,double sigmaA,double sigmaB){
		this.a=a;
		this.b=b;
		this.sigmaA=sigmaA;
		this.sigmaB=sigmaB;
		f=a*b;
	}
	void calculateGoalFunction(){
		
	}
	
}
