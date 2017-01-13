import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

public class Test extends JFrame{
	private ChartPanel chartPanel;
	private Measurements meas;
	
	public Test(){
		meas = new Measurements(1, 1);
		meas.testChart();
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	public static void print(double [][] array){
		for (int k = 0; k < array.length;  k++){
			for (int j = 0; j < array.length; j++)
				System.out.print(array[k][j] + "\t");
			System.out.print("\n");
		}
	
	}
}
