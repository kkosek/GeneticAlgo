package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;

public class MainFrame extends JFrame{
	private JPanel graphPanel;
	private JPanel paramsPanel;
	private JLabel numberOfPopulation;
	private JLabel numberOfChildren;
	private JLabel numberOfGenerations;
	private JTextField setPopulation;
	private JTextField setChildren;
	private JTextField setGenerations;
	private JTextField waitingBar;
	private JButton start;
	private JComboBox algos;
	
	public MainFrame(){
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setSize(700, 700);
		this.setTitle("Fit Function");
		graphPanel = new JPanel();
		paramsPanel = new JPanel();
		paramsPanel.setLayout(new BoxLayout(paramsPanel, BoxLayout.LINE_AXIS));
	
		numberOfPopulation = new JLabel("Populacja");
		numberOfChildren = new JLabel("Liczba dzieci");
		numberOfGenerations = new JLabel("Liczba pokoleń");
		
		setPopulation = new JTextField();
		setPopulation.setEditable(true);
		setChildren = new JTextField();
		setChildren.setEditable(true);
		setGenerations = new JTextField();
		setGenerations.setEditable(true);
		waitingBar = new JTextField("");
		waitingBar.setEditable(false);
		
		String [] algosNames = {"First", "Second"};
		algos = new JComboBox(algosNames);
		start = new JButton((new AbstractAction("START"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				startAction();
			}
		}));
		
		paramsPanel.add(numberOfPopulation);
		paramsPanel.add(setPopulation);
		paramsPanel.add(numberOfChildren);
		paramsPanel.add(setChildren);
		paramsPanel.add(numberOfGenerations);
		paramsPanel.add(setGenerations);
		paramsPanel.add(algos);
		paramsPanel.add(start);	
		
		this.add(graphPanel, BorderLayout.CENTER);
		this.add(paramsPanel, BorderLayout.NORTH);
		this.add(waitingBar, BorderLayout.SOUTH);
	}
	
	public void startAction(){
		int population;
		int children;
		int generations;
		int chosenAlgo = algos.getSelectedIndex();
		
		try{
			population = Integer.parseInt(setPopulation.getText());
			children = Integer.parseInt(setChildren.getText());
			generations = Integer.parseInt(setGenerations.getText());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(new JFrame(),
				    "Enter integer to apropriate field.",
				    "Illegal Format",
				    JOptionPane.ERROR_MESSAGE);
		}
		waitingBar.setText("Calculating...");
		
		if(chosenAlgo == 0){
			//TODO wykonaj algorytm	
			double [] values = {2,3,4,5,6,5,4,3};
			graphPanel.add(Charts.averageValueOfFitnessFunction(values));
			graphPanel.add(Charts.averageValueOfFitnessFunction(values));
			graphPanel.repaint();
			
		}else{
			
		}
		waitingBar.setText("Finished.");
	}
	
}
