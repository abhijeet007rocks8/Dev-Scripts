ngthButton = new JRadioButton("Length", true);
		lengthButton.setFont(new Font("Arial", Font.BOLD, 14));
		weightButton = new JRadioButton("Weight", false);
		lengthButton.setFont(new Font("Arial", Font.BOLD, 14));

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(lengthButton);
		bgroup.add(weightButton);

		JPanel radioPanel = new JPanel();
		radioPanel.add(lengthButton);
		radioPanel.add(weightButton);
		//radioPanel.setBounds(610, 20, 50, 10);
		radioPanel.setBackground(Color.GRAY);
		//frmStandardCalculator.getContentPane().add(radioPanel);
		mainPanel.add(radioPanel);