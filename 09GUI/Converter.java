import java.swing.*;
import java.out.*;
import java.event.*;

public class Converter extends JFrame implements ActionListener{
    private Container pane;
    private JButton cToF;
    private JButton fToC;
    private JTextField num;

    public Converter(){
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane.setLayout(new FlowLayout());

	pane = this.getContentPane();
	cToF = new JButton("Convert to Fahrenheit");
	fToC = new JButton("Convert to Celsius");
	num = new JTextField(1000);
	JLabel instructions = new JLabel("Enter a number: ");
	
	cToF.addActionListener(this);
	fToC.addActionListener(this);
	num.addActionListener(this);

	pane.add(instructions);
	pane.add(num);
	pane.add(cToF);
	pane.add(fToC);
    }


    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	System.out.println(s);

	if (s.equals("Convert to Fahrenheit")){
	    
	}
	if (s.equals("Convert to Celsius")){
	}
    }


    
    public static double CtoF(double t){
	return 9 * t / 5 + 32;
    }

    public static double FtoC(double t){
	return 5 * (t-32) / 9;
    }

    public static void main(String[] args){
	Converter w = new Converter();
	w.setVisible(true);
    }
}
