import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener{
    private Container pane;
    private JButton cToF;
    private JButton fToC;
    private JTextField num;
    private JLabel result;

    public GUI(){
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
		pane.setLayout(new FlowLayout());
	cToF = new JButton("Convert to Fahrenheit");
	fToC = new JButton("Convert to Celsius");
	
	num = new JTextField(1000);

	JLabel instructions = new JLabel("Enter a number: ");

	result = new JLabel ("Your converted temperature is: ");
	    
	cToF.addActionListener(this);
	fToC.addActionListener(this);
	num.addActionListener(this);

	pane.add(instructions);
	pane.add(num);
	pane.add(cToF);
	pane.add(fToC);
	pane.add(result);
    }


    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	System.out.println(s);
	System.out.println(num.getText());
	if (s.equals("Convert to Fahrenheit")){
	    result.setText("Your converted temperature is: " + CtoF(Double.parseDouble(num.getText())));
	}
	if (s.equals("Convert to Celsius")){
	    result.setText("Your converted temperature is: " + FtoC(Double.parseDouble(num.getText())));
	}
    }


    
    public static double CtoF(double t){
	return 9 * t / 5 + 32;
    }

    public static double FtoC(double t){
	return 5 * (t-32) / 9;
    }

    public static void main(String[] args){
        GUI w = new GUI();
	w.setVisible(true);
    }
}
