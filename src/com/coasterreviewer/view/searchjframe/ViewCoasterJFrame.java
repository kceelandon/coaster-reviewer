package com.coasterreviewer.view.searchjframe;

import javax.swing.*;

import com.coasterreviewer.model.business.SearchManager;
import com.coasterreviewer.model.domain.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class ViewCoasterJFrame extends JFrame {
	private JLabel nameLabel = new JLabel("");
	private JLabel manufacturerLabel = new JLabel("");
	private JLabel descLabel = new JLabel("");
	private JLabel yearLabel = new JLabel("");
	private JPanel panel = new JPanel();

	/**
	 * 
	 */
	private static final long serialVersionUID = -8587076214926843035L;

	public ViewCoasterJFrame() {
		setTitle("Unknown Coaster");
		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public ViewCoasterJFrame(Coaster c) {
		setTitle("Viewing: " + c.getName());
		setSize(300, 300);
		nameLabel.setText("Coaster Name: " + c.getName());
		manufacturerLabel.setText("Manufacturer: " + c.getManufacturer());
		yearLabel.setText("Year Opened: " + c.getYearCreated());
		descLabel.setText("Description: " + c.getDescription());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(nameLabel);
		panel.add(manufacturerLabel);
		panel.add(yearLabel);
		panel.add(descLabel);
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
