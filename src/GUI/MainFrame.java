package GUI;

import evolution.*;
import points.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	private JPanel graphPanel;
	private JPanel paramsPanel;
	private JLabel numberOfPopulation;
	private JLabel numberOfChildren;
	private JLabel numberOfGenerations;
	private JTextField setPopulation;
	private JTextField setChildren;
	private JTextField setGenerations;
	private JButton start;
	
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
		paramsPanel.add(start);	
		
		this.add(graphPanel, BorderLayout.CENTER);
		this.add(paramsPanel, BorderLayout.NORTH);
	}
	
	public void startAction(){
		Points points = new Points(3, 4);
		AlgorithmOneOfFiveSucess a = new AlgorithmOneOfFiveSucess(50, 10, points);
		
	}
	
}
