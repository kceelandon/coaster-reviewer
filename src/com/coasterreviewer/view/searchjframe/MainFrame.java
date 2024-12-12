package com.coasterreviewer.view.searchjframe;

import javax.swing.*;

import com.coasterreviewer.model.business.SearchManager;
import com.coasterreviewer.model.domain.*;
import com.coasterreviewer.view.searchjframe.ViewCoasterJFrame;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	private JTextField searchFld = new JTextField(25);
	private SearchManager mgr = SearchManager.getInstance();
	private final String dataPath = "data/productionData/";
	private DefaultListModel<Coaster> listModel;
	private JList<Coaster> resultList;
	private List<Coaster> allCoasters;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7947998827443089177L;
	
	public MainFrame() {
		allCoasters = new LinkedList<Coaster>();
		setTitle("Search Coasters");
		setSize(700, 300);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		this.searchFld.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				filterList();
			}
		});
		try {
			mgr.initializeSearch(dataPath);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listModel = new DefaultListModel<>();
		for (Coaster coaster : mgr.loadResults().getCoasterList()) {
			listModel.addElement(coaster);
			allCoasters.add(coaster);
		}
		resultList = new JList<>(listModel);
		resultList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int i = resultList.locationToIndex(e.getPoint());
					Coaster cst = listModel.getElementAt(i);
					handleResultClick(cst);
				}
			}
		});
		c.add(searchFld, BorderLayout.NORTH);
		c.add(new JScrollPane(resultList), BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void filterList() {
		String input = this.searchFld.getText();
		listModel.clear();
		try {
			mgr.updateSearch(input, allCoasters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Coaster coaster : mgr.loadResults().getCoasterList()) {
			listModel.addElement(coaster);
		}
	}
	
	private void handleResultClick(Coaster c) {
		// do something with coaster info i.e open a new page, etc.
		ViewCoasterJFrame newFrame = new ViewCoasterJFrame(c);
		newFrame.setVisible(true);
	}
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
	}
}
