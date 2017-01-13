package points;
import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;

public class Test extends JFrame{
	private Points meas;
	
	public Test(){
		meas = new Points(1, 20);
		meas.createMeasurements();
		ChartPanel p = new ChartPanel(meas.plotGoalFunc());
		this.setSize(600, 600);
		this.add(p);
		this.setVisible(true);
	}
	
	public static void print(double [][] array){
		for (int k = 0; k < array.length;  k++){
			for (int j = 0; j < array.length; j++)
				System.out.print(array[k][j] + "\t");
			System.out.print("\n");
		}	
	}
	
	public static void print(Square [][] array){
		for (int k = 0; k < array.length;  k++){
			for (int j = 0; j < array.length; j++)
				System.out.print(array[k][j].toString() + "\t");
			System.out.print("\n");
		}
	}
	
	public static void print(double [] array){
		for (double d : array)
			System.out.println(d);
	}
}
