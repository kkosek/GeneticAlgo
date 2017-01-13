package GUI;
import java.util.ArrayList;
import points.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Charts{
	public static ChartPanel averageValueOfFitnessFunction(double [] averageValues){
		XYSeries series = new XYSeries("Average fitness function values");
		for (int i = 0; i < averageValues.length; i++)
			series.add(i, averageValues[i]);
		
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYAreaChart("Average value of fitness function", "generation", "average", dataset);
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}
	
	public static JFreeChart xyFitting(double a, double b, ArrayList<Point> measurements){
		XYSeries meas = new XYSeries("Measurements");
		XYSeries line = new XYSeries("Result fitting function");
		
		for (int i = 0; i < measurements.size(); i++)
			meas.add(measurements.get(i).x, measurements.get(i).y);
		
		line.add(0, b);
		line.add(12, a * 12 + b);
		
		XYSeriesCollection dataset = new XYSeriesCollection(meas);
		dataset.addSeries(line);
		JFreeChart chart = ChartFactory.createXYAreaChart("Result", "X", "Y", dataset);
		return chart;
	}
}
