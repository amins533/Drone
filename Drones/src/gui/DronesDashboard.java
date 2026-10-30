package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.json.*;

import components.RoundedBorder;
import components.RoundedJButton;
import components.RoundedJTextField;



//import org.apache.batik.swing.JSVGCanvas;

public class DronesDashboard {
	
	private static final String END_POINT = "http://dronesim.facets-labs.com/api/dronedynamics/?format=json";
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";
	private static final String TOKEN = " Token d622b1fbb44b37233ba96988aa87dc92e6549185";
	
	JFrame mainFrame;
	JPanel contentPanePanel;
	JPanel menuMainContainer;
	JLabel burgerMenuImageContainer;
	JLabel dashboardTextLabel;
	JPanel searchBarFilterButtonContainer;
	RoundedJTextField textFieldContainer;
	JButton filterButton;
	JTextField searchBar;
	JPanel tableContainer;
	
	
	public DronesDashboard() {
		
		/*mainFrame = new JFrame();
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Drones");*/
		
		ImageIcon mainIcon = new ImageIcon("src/gui/images-icons/mainIcon.png");
		
		//mainFrame.setIconImage(mainIcon.getImage());
		
		contentPanePanel = new JPanel();
		contentPanePanel.setLayout(new BoxLayout(contentPanePanel, BoxLayout.Y_AXIS));
		contentPanePanel.setBackground(new Color(22, 27, 33));
		contentPanePanel.setOpaque(true);
		
		//mainFrame.add(contentPanePanel);
				
		menuMainContainer = new JPanel(new BorderLayout());
		menuMainContainer.setBorder(new EmptyBorder(20, 20, 20, 40));
		menuMainContainer.setBackground(contentPanePanel.getBackground());
		menuMainContainer.setOpaque(true);
		menuMainContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuMainContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
		
		contentPanePanel.add(menuMainContainer);
		
		ImageIcon burgerMenu = new ImageIcon("src/gui/images-icons/burger-menu.png");
		burgerMenuImageContainer = new JLabel();		
		burgerMenuImageContainer.setIcon(burgerMenu);
		burgerMenuImageContainer.setVerticalAlignment(SwingConstants.CENTER);
				
//		burgerMenuSVG = new JSVGCanvas();
//		burgerMenuSVG.setURI("C:/Users/lenis/eclipse-workspace/Drones/src/gui/images-icons/burger-menu.svg");
		
		menuMainContainer.add(burgerMenuImageContainer, BorderLayout.WEST);
		
		dashboardTextLabel = new JLabel();
		dashboardTextLabel.setText("Drones Dashboard");
		dashboardTextLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		dashboardTextLabel.setForeground(Color.WHITE);
		dashboardTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		menuMainContainer.add(dashboardTextLabel, BorderLayout.CENTER);
		
		//search bar and filter button
		
		searchBarFilterButtonContainer = new JPanel(new FlowLayout());
		searchBarFilterButtonContainer.setPreferredSize(new Dimension(1150, 150));
		searchBarFilterButtonContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
		searchBarFilterButtonContainer.setBorder(new EmptyBorder(30, 0, 0, 0));
		searchBarFilterButtonContainer.setOpaque(false);
		
		contentPanePanel.add(searchBarFilterButtonContainer);
		
		textFieldContainer = new RoundedJTextField(25);
        textFieldContainer.setBorder(new EmptyBorder(0, 0, 0, 15));
        textFieldContainer.setPreferredSize(new Dimension(1000, 50));
        textFieldContainer.setOpaque(false);
        
		searchBarFilterButtonContainer.add(textFieldContainer);
		
		searchBar = new JTextField("ID Eingeben...");
		searchBar.setBorder(new CompoundBorder(new RoundedBorder(25), new EmptyBorder(0, 5, 0 ,0)));
		searchBar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textFieldContainer.add(searchBar, BorderLayout.CENTER);		
		
		filterButton = new RoundedJButton("Filter", 25);
        filterButton.setPreferredSize(new Dimension(150, 50));
        filterButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        filterButton.setBackground(new Color(240, 240, 240));
        filterButton.setFocusPainted(false);
        
        if(((RoundedJButton) filterButton).getIsHovered()) {
        	
        	filterButton.setCursor(null);
        	
        }
		
		
		searchBarFilterButtonContainer.add(filterButton);
		
		tableContainer = new JPanel(new BorderLayout());
		tableContainer.setMaximumSize(new Dimension(1150, Integer.MAX_VALUE));
		tableContainer.setBorder(new EmptyBorder(0, 0, 45, 0));
		tableContainer.setOpaque(false);
		
		contentPanePanel.add(tableContainer);
		
		DefaultTableModel dashboardModel = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
				
			}
			
		};
		
		dashboardModel.addColumn("Id");
		dashboardModel.addColumn("Speed");
		dashboardModel.addColumn("Longitude");
		dashboardModel.addColumn("Latitude");
		dashboardModel.addColumn("Status");
		

//		dashboardModel.addColumn("Average-Speed");
//		dashboardModel.addColumn("Traveled-Distance");
		
		try {
			
			URL dynamicsURL = new URL(END_POINT);
			HttpURLConnection conn = (HttpURLConnection) dynamicsURL.openConnection();
			
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setRequestProperty("Authorization", TOKEN);
			conn.setRequestMethod("GET");
			
			if(conn.getResponseCode() != 200)
				System.err.println("ERROR. Cannot connect to the API");
			
			BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			StringBuffer readedInputStream = new StringBuffer();
			String currentInputStreamLine;
			
			while((currentInputStreamLine = inputStreamReader.readLine()) != null)
				readedInputStream.append(currentInputStreamLine);
			
			inputStreamReader.close();
			
//			System.out.println(readedInputStream);
			
			JSONObject wholeAPIResponse = new JSONObject(readedInputStream.toString());
			JSONArray resultsArray = new JSONArray(wholeAPIResponse.getJSONArray("results"));
			
//			System.out.println(resultsArray);
			
			for(int i = 0; i < resultsArray.length(); i++) {
				
				JSONObject currentDrone = resultsArray.getJSONObject(i);
								
				dashboardModel.addRow(new Object[] {
					
						currentDrone.get("drone"),
						currentDrone.getInt("speed"),
						currentDrone.getString("longitude"),
						currentDrone.getString("latitude"),
						currentDrone.getString("status")
						
				});
				
			}
			
		} catch(MalformedURLException e) {
			
		System.err.println("Malformed URL: " + e.getLocalizedMessage());
		e.printStackTrace();
		
		} catch(IOException e) {
		
		System.out.println("General IO Exception: " + e.getLocalizedMessage());
		e.printStackTrace();
		
		}
		
		JTable droneDashboard = new JTable(dashboardModel);
		
        droneDashboard.setGridColor(Color.WHITE);
        droneDashboard.setBorder(new RoundedBorder(0, 0, 25, 25));
        droneDashboard.setForeground(Color.WHITE);
        droneDashboard.setFont(new Font("Tahoma", Font.PLAIN, 16));
        droneDashboard.setRowHeight(55);
        droneDashboard.setRowSelectionAllowed(false);
        droneDashboard.setShowHorizontalLines(true);
        droneDashboard.setShowVerticalLines(true);
        droneDashboard.setOpaque(false);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer.setOpaque(false);
        
//        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
//        	
//     	   @Override
//     	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//     	        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//     	        label.setHorizontalAlignment(SwingConstants.CENTER);
//     	        label.setOpaque(false);
//
//     	        int bottomLeft = (row == table.getRowCount() - 1 && column == 0) ? 25 : 0;
//     	        int bottomRight = (row == table.getRowCount() - 1 && column == table.getColumnCount() - 1) ? 25 : 0;
//     	        label.setBorder(new RoundedBorder(0, 0, bottomLeft, bottomRight));
//     	        return label;
//     	    }
//     	
//        };
        
        for (int i = 0; i < droneDashboard.getColumnCount(); i++)
        	droneDashboard.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		
        JTableHeader tableHeader = droneDashboard.getTableHeader();
        
		tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 50));
		tableHeader.setFocusable(false);
		tableHeader.setResizingAllowed(false);
		tableHeader.setReorderingAllowed(false);
		
		
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel currentHeaderCell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                currentHeaderCell.setHorizontalAlignment(SwingConstants.CENTER);
                currentHeaderCell.setVerticalAlignment(SwingConstants.CENTER);
                currentHeaderCell.setFont(new Font("Tahoma", Font.BOLD, 20));
                currentHeaderCell.setForeground(Color.WHITE);
                currentHeaderCell.setBackground(Color.DARK_GRAY);
                currentHeaderCell.setOpaque(true);

                int topLeft = column == 0 ? 25 : 0;
                int topRight = column == table.getColumnCount() - 1 ? 25 : 0;
                
//              System.out.println("Top-Left: " + topLeft);
//              System.out.println("Top-Right: " + topRight);
//              System.out.println("\n");
                
//                currentHeaderCell.setBorder(new CompoundBorder(new RoundedBorder(topLeft, topRight, 0, 0), new LineBorder(Color.WHITE, 1)));
                currentHeaderCell.setBorder(new LineBorder(Color.WHITE, 1));
                return currentHeaderCell;
            }
        };

        for (int i = 0; i < droneDashboard.getColumnCount(); i++)
        	droneDashboard.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        
        
		JScrollPane scrollPane = new JScrollPane(droneDashboard);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		tableContainer.add(scrollPane, BorderLayout.CENTER);
		
//		mainFrame.revalidate();
//		mainFrame.repaint();
		
//		mainFrame.pack();
	
		//mainFrame.setVisible(true);
		
	}
	
	
	
}
