import java.util.ArrayList;

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
	}

	public void createMeasurements(){
		for (int i = 0; i < 10; i++){
			double x = i + stats.getNoise();
			double y = i * a + b + stats.getNoise();
			measurements.add(new Point(x, y, stats));
		}
	}
		
	
	
	
	
	
	
	
	

	
	
	
}