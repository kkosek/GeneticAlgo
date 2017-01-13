package GUI;
import java.awt.Dimension;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import points.Point;

public class Charts{
	public static ChartPanel averageValueOfFitnessFunction(double [] averageValues){
		XYSeries series = new XYSeries("Average fitness function values");
		for (int i = 0; i < averageValues.length; i++)
			series.add(i, averageValues[i]);
		
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYAreaChart("Average value of fitness function", "generation", "average", dataset);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(600, 300));
		
		return panel;
	}
	
	public static ChartPanel xyFitting(double a, double b, ArrayList<Point> measurements){
		XYSeries meas = new XYSeries("Measurements");
		XYSeries line = new XYSeries("Result fitting function for a = " + a + ", b = " + b);
		
		for (int i = 0; i < measurements.size(); i++)
			meas.add(measurements.get(i).x, measurements.get(i).y);
		
		line.add(0, b);
		line.add(12, a * 12 + b);
		
		XYSeriesCollection dataset = new XYSeriesCollection(meas);
		
		JFreeChart chart = ChartFactory.createScatterPlot("Result", "X", "Y", dataset);
		XYPlot plot = chart.getXYPlot();
		XYLineAnnotation annotation = new XYLineAnnotation(0, b, 10, 10*a + b);
		plot.addAnnotation(annotation);
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(600, 300));
		
		return panel;
	}
}
