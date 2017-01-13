import java.util.ArrayList;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

public class Measurements{
	private final double a;
	private final double b;
	private final ArrayList<Point> measurements;
	private final double middle;
	private final int bins = 20;
	
	
	public Measurements(double a, double b){
		this.a = a;
		this.b = b;
		measurements = new ArrayList<>();
		middle = 0.5;
	}
	
	private double getNumberFromWeibullDist(){
		double lambda = 1.0;
		double k = 2;
		return lambda*(Math.pow(-Math.log(1 - Math.random()), 1/k));
	}
	
	private double getNoise(){
		double noise = getNumberFromWeibullDist();
		if (noise < middle)
			return noise;
		else
			return -noise;
	}
	
	public void createMeasurements(){
		for (int i = 0; i < 10; i++){
			double x = i + getNoise();
			double y = i * a + b + getNoise();
			measurements.add(new Point(x, y));
		}
	}
		
	public void testChart(){
		HistogramDataset hist = new HistogramDataset();
		hist.setType(HistogramType.RELATIVE_FREQUENCY);
		double [] s = new double[1000000];
		for (int i = 0; i < 1000000; i++)
			s[i] = getNumberFromWeibullDist();
		
		hist.addSeries("Histogram", s, bins);
		Test.print(createFactorMatrix());
	}
	
	private HistogramDataset createHistogram(double [] values){
		HistogramDataset hist = new HistogramDataset();
		hist.setType(HistogramType.RELATIVE_FREQUENCY);
		hist.addSeries("Histogram", values, bins);
		return hist;
	} 
	
	private ArrayList<Double> getFactorValues(HistogramDataset hist){
		double binValue = hist.getY(0, 0).doubleValue();
		int i = 0;
		ArrayList<Double> factorVector = new ArrayList<>();
		
		while (binValue > 0.005){
			i++;
			factorVector.add(binValue);
			binValue = hist.getY(0, i).doubleValue();
		}
		return factorVector;
	}
	
	public double [][] createFactorMatrix(){
		double [][] factorMatrix;
 		double [] values = new double[1000000];
		for (int i = 0; i < 1000000; i++)
			values[i] = getNumberFromWeibullDist();
		HistogramDataset hist = createHistogram(values);
		ArrayList<Double> factorVector = getFactorValues(hist);
		
		factorMatrix = new double[factorVector.size()][factorVector.size()];
		
		for (int k = 0; k < factorVector.size(); k++)
			for (int j = 0; j < factorVector.size(); j++)
				factorMatrix[k][j] = factorVector.get(k) * factorVector.get(j);
		
		return factorMatrix;
	}
}