
import java.awt.EventQueue;
import java.awt.*;

import javax.net.ssl.KeyManagerFactorySpi;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.border.LineBorder;
import java.awt.Color;

public class ScientificCalculator {

	private JFrame frmStandardCalculator;
	private JTextField txtDisplay;
	private JTextField jtxtConverts;
	private JTextField jtxtFrom;
	private JTextField jtxtTo;
	private JTextField currResultLbl;
	private JRadioButton lengthButton;
	private JRadioButton weightButton;
	
	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;
	
	private int searchIndex(String[] a, String b){
		for(int i=0; i<a.length; i++){
			if(a[i].equals(b))
				return i;
		}
		return -1;
	}

	/*double[] i = new double[5];
	double Nigerian_Naira = 5.54;
	double US_Dollar = 0.013;
	double Kenyan_Shilling = 1.45;
	double Brazilian_Real = 0.068;
	double Canadian_Dollar = 0.017;
	double Indian_Rupee = 1.00;
	double Philippine_Peso = 0.66;
	double Indonessia_Rupiah = 194.21;*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScientificCalculator window = new ScientificCalculator();
					window.frmStandardCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	ScientificCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */



	public void weight_LengthConverter(){

		String[] a = new String[5];
		frmStandardCalculator.setBounds(300, 300, 945, 380);
	
		JPanel headPanel= new JPanel();
		headPanel.setBounds(607, 18, 299, 274);
		headPanel.setLayout(new GridLayout(4,1,0,3));
		frmStandardCalculator.getContentPane().add(headPanel);

		JLabel headLabel = new JLabel("           Unit Conversions");
		headLabel.setFont(new Font("Arial", Font.BOLD, 21));
		headPanel.add(headLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 7));
		panel.setBounds(600, 11, 313, 288);
		frmStandardCalculator.getContentPane().add(panel);         // Colored border
		
		lengthButton = new JRadioButton("Length", false);
		lengthButton.setFont(new Font("Arial", Font.BOLD, 14));
		weightButton = new JRadioButton("Weight", false);
		weightButton.setFont(new Font("Arial", Font.BOLD, 14));

		

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(lengthButton);
		bgroup.add(weightButton);

		JPanel radioPanel = new JPanel();
		radioPanel.add(lengthButton);
		radioPanel.add(weightButton);
		headPanel.add(radioPanel);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(2,2,2,2));
		headPanel.add(textPanel);

		
		JComboBox jcmbUnitFrom = new JComboBox();
		jcmbUnitFrom.setFont(new Font("Arial", Font.BOLD, 14));
		jcmbUnitFrom.setModel(new DefaultComboBoxModel(new String[] { "-From-"}));
		jcmbUnitFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textPanel.add(jcmbUnitFrom);

		jtxtFrom = new JTextField();
		jtxtFrom.setHorizontalAlignment(SwingConstants.RIGHT);
		textPanel.add(jtxtFrom);
		jtxtFrom.setColumns(10);

		JComboBox jcmbUnitTo = new JComboBox();
		jcmbUnitTo.setFont(new Font("Arial", Font.BOLD, 14));
		jcmbUnitTo.setModel(new DefaultComboBoxModel(new String[] { "-To-"}));
		jcmbUnitTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textPanel.add(jcmbUnitTo);

		jtxtTo = new JTextField();
		jtxtTo.setFont(new Font("Arial", Font.BOLD, 15));
		jtxtTo.setHorizontalAlignment(SwingConstants.RIGHT);
		jtxtTo.setEditable(false);
		textPanel.add(jtxtTo);
		jtxtTo.setColumns(10);

		JPanel convPanel = new JPanel();
		convPanel.setLayout(new GridLayout(1,2,4,0));
		headPanel.add(convPanel);


		JButton convUnitButton = new JButton("Convert");
		convUnitButton.setFont(new Font("Arial", Font.BOLD, 15));
		convPanel.add(convUnitButton);
		

		JButton clearUnitButton = new JButton("Clear");
		clearUnitButton.setFont(new Font("Arial", Font.BOLD, 15));
		convPanel.add(clearUnitButton);

		String[] lengths = {"cm", "m", "feet", "inches", "Kilometres"} ;
		String[] lengthSymbol = {"cm", "m", "ft", "in", "km" };
		double[] cm = {1, 0.01, 0.0328084, 0.393701, 0.000001};
		double[] m = {100, 1, 3.28084, 39.3701, 0.0001};
		double[] feet = {30.48, 0.3048, 1, 12, 0.0003};
		double[] inches = {2.54, 0.0254, 0.083, 1, 0.0000254};
		double[] kilometres = {100000, 1000, 3280.84, 39370.1, 1};

		lengthButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jcmbUnitFrom.setModel(new DefaultComboBoxModel(lengths ));
				jcmbUnitTo.setModel(new DefaultComboBoxModel(lengths ));
			}
		});

		String[] weights = {"grams", "Kilograms", "Pounds", "Stones", "Ounces"};
		String[] weightSymbol = {"g", "Kg", "lbs", "st.", "oz"};
		double[] grams = {1, 0.001, 0.00220462, 0.000157473, 0.035274};
		double[] kilograms = {1000, 1, 2.204, 0.157, 35.27};
		double[] pounds = {453.592, 0.453, 1, 0.0714286, 16};
		double[] stones = {6350.29, 6.350, 14, 1, 224};
		double[] ounces = {28.3495, 0.0283, 0.0625, 0.00446429, 1};

		weightButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jcmbUnitFrom.setModel(new DefaultComboBoxModel(weights ));
				jcmbUnitTo.setModel(new DefaultComboBoxModel(weights));

			}
		});

		convUnitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double unitInput = Double.parseDouble(jtxtFrom.getText());
				int currIndex;

				if (jcmbUnitFrom.getSelectedItem().equals("grams"))
				{
					currIndex = searchIndex(weights, (String)jcmbUnitTo.getSelectedItem());
					String weightResult = String.format(" %.4f", unitInput*grams[currIndex])+ " "+weightSymbol[currIndex];
					jtxtTo.setText(weightResult);
								
				}

				if (jcmbUnitFrom.getSelectedItem().equals("Kilograms"))
				{
					currIndex = searchIndex(weights, (String)jcmbUnitTo.getSelectedItem());
					String weightResult = String.format(" %.4f", unitInput*kilograms[currIndex])+ " "+weightSymbol[currIndex];
					jtxtTo.setText(weightResult);
								
				}

				if (jcmbUnitFrom.getSelectedItem().equals("Pounds"))
				{
					currIndex = searchIndex(weights, (String)jcmbUnitTo.getSelectedItem());
					String weightResult = String.format(" %.4f", unitInput*pounds[currIndex])+ " "+weightSymbol[currIndex];
					jtxtTo.setText(weightResult);
								
				}
				if (jcmbUnitFrom.getSelectedItem().equals("Stones"))
				{
					currIndex = searchIndex(weights, (String)jcmbUnitTo.getSelectedItem());
					String weightResult = String.format(" %.4f", unitInput*stones[currIndex])+ " "+weightSymbol[currIndex];
					jtxtTo.setText(weightResult);
								
				}
				if (jcmbUnitFrom.getSelectedItem().equals("Ounces"))
				{
					currIndex = searchIndex(weights, (String)jcmbUnitTo.getSelectedItem());
					String weightResult = String.format(" %.4f", unitInput*ounces[currIndex])+ " "+weightSymbol[currIndex];
					jtxtTo.setText(weightResult);
								
				}
				if (jcmbUnitFrom.getSelectedItem().equals("cm"))
				{
					currIndex = searchIndex(lengths, (String)jcmbUnitTo.getSelectedItem());
					String lenghtResult = String.format(" %.4f", unitInput*cm[currIndex])+ " "+lengthSymbol[currIndex];
					jtxtTo.setText(lenghtResult);
								
				}

				if (jcmbUnitFrom.getSelectedItem().equals("m"))
				{
					currIndex = searchIndex(lengths, (String)jcmbUnitTo.getSelectedItem());
					String lenghtResult = String.format(" %.4f", unitInput*m[currIndex])+ " "+lengthSymbol[currIndex];
					jtxtTo.setText(lenghtResult);
							
				}

				if (jcmbUnitFrom.getSelectedItem().equals("feet"))
				{
					currIndex = searchIndex(lengths, (String)jcmbUnitTo.getSelectedItem());
					String lenghtResult = String.format(" %.4f", unitInput*feet[currIndex])+ " "+lengthSymbol[currIndex];
					jtxtTo.setText(lenghtResult);
								
				}

				if (jcmbUnitFrom.getSelectedItem().equals("inches"))
				{
					currIndex = searchIndex(lengths, (String)jcmbUnitTo.getSelectedItem());
					String lenghtResult = String.format(" %.4f", unitInput*inches[currIndex])+ " "+lengthSymbol[currIndex];
					jtxtTo.setText(lenghtResult);
								
				}

				if (jcmbUnitFrom.getSelectedItem().equals("Kilometres"))
				{
					currIndex = searchIndex(lengths, (String)jcmbUnitTo.getSelectedItem());
					String lenghtResult = String.format(" %.4f", unitInput*kilometres[currIndex])+ " "+lengthSymbol[currIndex];
					jtxtTo.setText(lenghtResult);
								
				}

			}
		});

		clearUnitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtFrom.setText(null);
				jtxtTo.setText(null);
				}
		});


	}





	private void currencyConverter(){

		frmStandardCalculator.setTitle("Calculator-Conversions");
		frmStandardCalculator.setBounds(600, 300, 625, 380);
		txtDisplay.setBounds(10, 11, 243, 37);

		JLabel lblNewLabel = new JLabel("        Currency Exchange");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel.setBounds(296, 22, 298, 37);
		frmStandardCalculator.getContentPane().add(lblNewLabel);
		
		JComboBox jcmbCurrencyFrom = new JComboBox();
		jcmbCurrencyFrom.setFont(new Font("Arial", Font.BOLD, 14));
		jcmbCurrencyFrom.setModel(new DefaultComboBoxModel(new String[] {"      -From-", "Brazil", "Canada", "India", "Indonesia", "Kenya", "Nigeria", "Phillipines", "USA"}));
		jcmbCurrencyFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jcmbCurrencyFrom.setBounds(300, 100, 120, 34);
		frmStandardCalculator.getContentPane().add(jcmbCurrencyFrom);

		//Currency to:

		String[] Currency = {"Brazil", "Canada", "India", "Indonesia", "Kenya", "Nigeria", "Phillipines", "USA"};
		String[] symbol = {"Brz", "C$", "INR", "IDR", "KS", "N", "PHP", "$"};
		double[] BrExch = {1, 0.273, 16.512, 3106.91, 25.01, 89.90, 11.32, 0.22};
		double[] CanExch = {3.66, 1, 60.45, 11373.50, 91.54, 329.08, 41.43, 0.79};
		double[] InExch = {0.068, 0.016, 1, 187.900, 1.51, 5.46, 0.68, 0.013};       // 1 rupee equivalent
		double[] IndoExch = {0.00032, 0.000088, 0.0053, 1, 0.0081, 0.029, 0.0036, 0.00007};
		double[] KenExch = {0.04, 0.011, 0.66, 124.17, 1, 3.59, 0.45, 0.0087 };
		double[] NigExch = {0.011, 0.003, 0.18, 34.43, 0.28, 1, 0.13, 0.0024 };
		double[] PhilExch = {0.088, 0.024, 1.46, 274.66, 2.21, 7.95, 1, 0.019};
		double[] UsExch = {4.62, 1.26, 76.33, 14363.45, 115.65, 415.58, 52.28, 1};	

		JComboBox jcmbCurrencyTo = new JComboBox();
		jcmbCurrencyTo.setFont(new Font("Arial", Font.BOLD, 14));
		jcmbCurrencyTo.setModel(new DefaultComboBoxModel(new String[] {"      -To-", "Brazil", "Canada", "India", "Indonesia", "Kenya", "Nigeria", "Phillipines", "USA"}));
		jcmbCurrencyTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jcmbCurrencyTo.setBounds(450, 100, 120, 34);
		frmStandardCalculator.getContentPane().add(jcmbCurrencyTo);

		
		jtxtConverts = new JTextField();
		jtxtConverts.setHorizontalAlignment(SwingConstants.RIGHT);
		jtxtConverts.setBounds(300, 145, 120, 47);
		frmStandardCalculator.getContentPane().add(jtxtConverts);
		jtxtConverts.setColumns(10);
		
		currResultLbl = new JTextField();
		currResultLbl.setFont(new Font("Arial", Font.BOLD, 15));
		currResultLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		currResultLbl.setEditable(false);
		currResultLbl.setBounds(450, 145, 120, 47);
		frmStandardCalculator.getContentPane().add(currResultLbl);
		currResultLbl.setColumns(10);
		
		JButton btnConverts = new JButton("Convert");
		btnConverts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double currencyInput = Double.parseDouble(jtxtConverts.getText());
				int currIndex;
				if (jcmbCurrencyFrom.getSelectedItem().equals("Nigeria"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert1 = String.format(symbol[currIndex]+" %.2f", currencyInput*NigExch[currIndex]);
					currResultLbl.setText(cConvert1);
								
				}
				
				if (jcmbCurrencyFrom.getSelectedItem().equals("USA"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert1 = String.format(symbol[currIndex]+" %.2f", currencyInput * UsExch[currIndex]);
					currResultLbl.setText(cConvert1);
								
				}
				
				if (jcmbCurrencyFrom.getSelectedItem().equals("Kenya"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert2 = String.format(symbol[currIndex]+" %.2f", currencyInput * KenExch[currIndex]);
					currResultLbl.setText(cConvert2);
								
				} 
				
				if (jcmbCurrencyFrom.getSelectedItem().equals("Canada"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert4 = String.format(symbol[currIndex]+" %.2f", currencyInput * CanExch[currIndex]);
					currResultLbl.setText(cConvert4);
								
				} 
				
				if (jcmbCurrencyFrom.getSelectedItem().equals("Brazil"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert5 = String.format(symbol[currIndex]+" %.2f", currencyInput * BrExch[currIndex]);
					currResultLbl.setText(cConvert5);
								
				} 
				
				if (jcmbCurrencyFrom.getSelectedItem().equals("India"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert6 = String.format(symbol[currIndex]+" %.2f", currencyInput * InExch[currIndex]);
					currResultLbl.setText(cConvert6);
								
				} 
				
				if (jcmbCurrencyFrom.getSelectedItem().equals("Phillipines"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert7 = String.format(symbol[currIndex]+" %.2f", currencyInput * PhilExch[currIndex]);
					currResultLbl.setText(cConvert7);
				
				}  
				
				if (jcmbCurrencyFrom.getSelectedItem().equals("Indonesia"))
				{
					currIndex = searchIndex(Currency, (String)jcmbCurrencyTo.getSelectedItem());
					String cConvert8 = String.format(symbol[currIndex]+"%.9f", currencyInput * IndoExch[currIndex]);
					currResultLbl.setText(cConvert8);
								
				} 

			}
		});
		btnConverts.setFont(new Font("Arial", Font.BOLD, 15));
		btnConverts.setBounds(326, 253, 104, 34);
		frmStandardCalculator.getContentPane().add(btnConverts);
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Arial", Font.BOLD, 15));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtConverts.setText(null);
				currResultLbl.setText(null);
				}
		});
		btnClear.setBounds(435, 253, 104, 34);
		frmStandardCalculator.getContentPane().add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 7));
		panel.setBounds(276, 11, 318, 288);
		frmStandardCalculator.getContentPane().add(panel);
	}

	private void initialize() {
		frmStandardCalculator = new JFrame();
		frmStandardCalculator.setResizable(false);
		frmStandardCalculator.setTitle("Standard Calculator");
		frmStandardCalculator.setBounds(700, 300, 280, 385);
		frmStandardCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmStandardCalculator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmStandard = new JMenuItem("Standard");
		mntmStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frmStandardCalculator.getContentPane().removeAll();
				frmStandardCalculator.setTitle("Standard Calculator");
				frmStandardCalculator.setBounds(700, 300, 280, 385);
				txtDisplay.setBounds(10, 11, 243, 37);
				
			}
		});
		mnFile.add(mntmStandard);
		
		JMenuItem mntmCurrencyConverter = new JMenuItem("Converters");
		mntmCurrencyConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currencyConverter();
				weight_LengthConverter();
			}
		});
		mnFile.add(mntmCurrencyConverter);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		frmStandardCalculator.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setBounds(11, 11, 243, 37);
		frmStandardCalculator.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton button = new JButton("\u00AB");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String backspace = null;
				
				if (txtDisplay.getText().length() >0) {
					StringBuilder strB = new StringBuilder(txtDisplay.getText());
					strB.deleteCharAt(txtDisplay.getText().length() -1);
					backspace = strB.toString();
					txtDisplay.setText(backspace);
				}
			}
		});
		button.setBounds(12, 57, 46, 47);
		frmStandardCalculator.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u0152");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDisplay.setText(null);
			}
		});
		button_1.setBounds(60, 57, 46, 47);
		frmStandardCalculator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDisplay.setText(null);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(108, 57, 46, 47);
		frmStandardCalculator.getContentPane().add(button_2);
		
		JButton btnPlusMinus = new JButton("\u00B1");
		btnPlusMinus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = ops * (-1);
				txtDisplay.setText(String.valueOf(ops));	
			}
		});
		btnPlusMinus.setBounds(156, 57, 46, 47);
		frmStandardCalculator.getContentPane().add(btnPlusMinus);
		
		JButton btnSqrt = new JButton("\u221A");
		btnSqrt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.sqrt(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnSqrt.setBounds(204, 57, 46, 47);
		frmStandardCalculator.getContentPane().add(btnSqrt);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn7.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn7.setBounds(12, 105, 46, 47);
		frmStandardCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn8.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn8.setBounds(60, 105, 46, 47);
		frmStandardCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn9.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn9.setBounds(108, 105, 46, 47);
		frmStandardCalculator.getContentPane().add(btn9);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(txtDisplay.getText());
				 txtDisplay.setText("");
				 operations = "/";
			}
		});
		btnDiv.setBounds(156, 105, 46, 47);
		frmStandardCalculator.getContentPane().add(btnDiv);
		
		JButton btnRMod = new JButton("%");
		btnRMod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(txtDisplay.getText());
				 txtDisplay.setText("");
				 operations = "%";
			}
		});
		btnRMod.setBounds(204, 105, 46, 47);
		frmStandardCalculator.getContentPane().add(btnRMod);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn4.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn4.setBounds(12, 153, 46, 47);
		frmStandardCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn5.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn5.setBounds(60, 153, 46, 47);
		frmStandardCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn6.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn6.setBounds(108, 153, 46, 47);
		frmStandardCalculator.getContentPane().add(btn6);
		
		JButton btnMul = new JButton("*");
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(txtDisplay.getText());
				 txtDisplay.setText("");
				 operations = "*";	
			}
		});
		btnMul.setBounds(156, 153, 46, 47);
		frmStandardCalculator.getContentPane().add(btnMul);
		
		JButton btnx2 = new JButton("X^2");
		btnx2.setFont(new Font("Tahoma", Font.PLAIN, 6));
		btnx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = (ops * ops);
				txtDisplay.setText(String.valueOf(ops));	
				
			}
		});
		btnx2.setBounds(204, 153, 46, 47);
		frmStandardCalculator.getContentPane().add(btnx2);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String iNum = txtDisplay.getText() +btn1.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn1.setBounds(12, 202, 46, 47);
		frmStandardCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn2.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn2.setBounds(60, 202, 46, 47);
		frmStandardCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn3.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn3.setBounds(108, 202, 46, 47);
		frmStandardCalculator.getContentPane().add(btn3);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				firstnum = Double.parseDouble(txtDisplay.getText());
				 txtDisplay.setText("");
				 operations = "-";
			}
		});
		btnMinus.setBounds(156, 202, 46, 47);
		frmStandardCalculator.getContentPane().add(btnMinus);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() +btn0.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn0.setBounds(12, 252, 94, 47);
		frmStandardCalculator.getContentPane().add(btn0);
		
		JButton btnEquals = new JButton("=");
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String answer;
				secondnum = Double.parseDouble(txtDisplay.getText());
				if (operations == "+")
				{
					result = firstnum + secondnum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
					
				}
				
				else if (operations == "-")
				{
					result = firstnum - secondnum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
					
				}
				
				else if (operations == "*")
				{
					result = firstnum * secondnum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
					
				}
				
				else if (operations == "/")
				{
					result = firstnum / secondnum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
					
				}	
				
			}
		});
		btnEquals.setBounds(204, 202, 46, 97);
		frmStandardCalculator.getContentPane().add(btnEquals);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(! txtDisplay.getText().contains("."))
				{
					txtDisplay.setText(txtDisplay.getText() + btnDot.getText());
				}
			}
		});
		btnDot.setBounds(108, 252, 46, 47);
		frmStandardCalculator.getContentPane().add(btnDot);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(txtDisplay.getText());
				 txtDisplay.setText("");
				 operations = "+";
			}
		});
		btnPlus.setBounds(156, 252, 46, 47);
		frmStandardCalculator.getContentPane().add(btnPlus);

	}
}


// Author : Heet kumar Kothadiya