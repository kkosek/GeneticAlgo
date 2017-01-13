import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Points{
	private final double a;
	private final double b;
	private final ArrayList<Point> measurements;
	private final Statistics stats;
	
	public Points(double a, double b){
		super();
		this.a = a;
		this.b = b;
		measurements = new ArrayList<>();
		stats = new Statistics();
		createMeasurements();
	}

	public void createMeasurements(){
		for (int i = 0; i < 10; i++){
			double x = i + stats.getNoise();
			double y = i * a + b + stats.getNoise();
			measurements.add(new Point(x, y, stats));
		}
	}
	
	public double fitnessFunction(double a, double b){
		double result = 0;
		
		for (int k = 0; k < measurements.size(); k++)
			for(int i = 0; i < stats.getLength(); i++)
				for(int j = 0; j < stats.getLength(); j++)
					if(measurements.get(k).matrixOfUncertainity[i][j].containsLine(a, b))
						result += stats.factorMatrix[i][j];
		
		System.out.println(result);
		return result;
	}
	
	public JFreeChart plotGoalFunc(){
		XYSeries series = new XYSeries("Goal function");
		for (int i = 0; i < 50; i++)
			series.add(0.1 + i*0.1, fitnessFunction(0.1 + i*0.1, 20));
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		JFreeChart chart = ChartFactory.createXYAreaChart("Funkcja celu", "x", "y", dataset);
		return chart;
	}
	
	
	
	
	
	
	
	
	

	
	
	
}