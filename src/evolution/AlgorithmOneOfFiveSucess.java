package evolution;
import points.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import points.Points;
public class AlgorithmOneOfFiveSucess
{
	private Random generator = new Random();
	private List<Person> generation;
	private int numberOfPopulation;
	
	private double sigma;
	private double mutation;
	private double numberOfSucess;
	private Points points;

	
	public AlgorithmOneOfFiveSucess(int numberOfPopulation, double sigma, Points p){
		 this.sigma = sigma;
		 this.numberOfPopulation=numberOfPopulation;
		 mutation= mutation();
		 numberOfSucess=0;
		 generation= new ArrayList<Person>(numberOfPopulation);
		 points = p;
	}
	public void creatGeneration(List<Person> generation,int numberOfPopulation){
		generation.clear();
		for(int i=0;i<numberOfPopulation;i++)
			generation.add(new Person(generator.nextDouble(),generator.nextDouble(), points));
	}
	public double generateNormalDistribution(){
		return Math.sqrt(-2*generator.nextDouble())*Math.cos(2*Math.PI*generator.nextDouble());
	}
	
	public double mutation(){
		return sigma*generateNormalDistribution();
	}
	public void changeMutation(){
		if(numberOfSucess>numberOfPopulation/5) 
			mutation*=0.82;
		else if(numberOfSucess<numberOfPopulation/5){
			mutation *=1.22;
		}
		
	}
	public Person createChild(Person parent){
		Person child = new Person (parent.a+mutation,parent.b+mutation, points);
		if(child.f > parent.f){
			numberOfSucess++;
			return child;
		}
		else return parent;
	}
	
	public void createNextGeneration(){
		List<Person> nextGeneration = new ArrayList<Person>(numberOfPopulation);
		
		generation.forEach(p-> nextGeneration.add(createChild(p)));
		
		changeMutation();
		
		generation= nextGeneration;	
	}
	
	
	
	
}
