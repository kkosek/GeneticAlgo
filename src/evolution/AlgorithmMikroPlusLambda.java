package evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlgorithmMikroPlusLambda {
	
	private Random generator = new Random();
	private List<Person> generation;
	private List<Person> children;
	private int numberOfPopulation;
	private int  numberOfChildren;
	private double constSigma;
	
	public AlgorithmMikroPlusLambda(int numberOfPopulation,int numberOfChildren ){
	}
	
	public List<Person> crossing(Person person1,Person person2){
		List<Person> kids= new ArrayList<Person>(2);
		Person p1= new Person(0,0);
		Person p2= new Person(0,0);
		double o=generator.nextDouble();

		p1.a =person1.a*o+(1-o)*person2.a;
		p1.b =person1.b*o+(1-o)*person2.b;
		p2.a =person2.a*o+(1-o)*p1.a;
		p2.b =person2.b*o+(1-o)*p1.b;
	
		p1.sigmaA =person1.sigmaA*o+(1-o)*person2.sigmaA;
		p1.sigmaB =person1.sigmaB*o+(1-o)*person2.sigmaB;
		p2.sigmaA =person2.sigmaA*o+(1-o)*person1.sigmaA;
		p2.sigmaB =person2.sigmaB*o+(1-o)*person1.sigmaB;
		kids.add(p1);
		kids.add(p2);
		return kids;
	}
	public void mutation(Person person){
		person.sigmaA=person.sigmaA*Math.exp(constSigma/Math.sqrt(2)+generator.nextDouble()/Math.sqrt(2));
		person.sigmaB=person.sigmaB*Math.exp(constSigma/Math.sqrt(4)+generator.nextDouble()/Math.sqrt(2*Math.sqrt(2)));
	}
	public void createNextGenerattion(){

		for(int i=0;i<numberOfChildren;i++)
			children.addAll(crossing(generation.get(generator.nextInt(numberOfPopulation)),generation.get(generator.nextInt(numberOfPopulation))));
		
		children.forEach(c->mutation(c));
		List<Person> nextGeneration= new ArrayList<Person>(numberOfPopulation);
			nextGeneration.addAll(generation);
			nextGeneration.addAll(children);
		
		double f=0;
		int index=0;
		while(nextGeneration.size()!=numberOfPopulation){
			for(int i=0;i<numberOfChildren;i++)
			{
				
				if(f>nextGeneration.get(i).f){
					index=i;
					f=nextGeneration.get(i).f;
				}
				else if(i==0)
				{
					index=i;
					f=nextGeneration.get(i).f;
				}
				
			
			}
			nextGeneration.remove(index);
		}
		
	}
	

}
