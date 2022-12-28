import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.util.*;
import java.io.*;

public class MovieGUI extends JFrame {
		private MovieDatabase database;
		
		JPanel category_panel;
        private JComboBox yearcmb;
        private JRadioButton drama;
        private JRadioButton comedy;
        private JRadioButton animation;
        private JRadioButton horror;
        private JTextArea list;
        private Scanner movies;
        private JButton save;
        private JMenuBar menuBar;
        private JMenu menu;
        private JMenuItem loadMovies;

		private ButtonGroup category_group;
		private String currentCategory = "";
        
        //stores the movie years from the movie database
        private ArrayList <Integer> years; 
		
		//stores the categories from the movie database
		private ArrayList <String> categories;                                  					 
		
		//stores the year RadioButtons
    	private ArrayList<JRadioButton> buttonList = new ArrayList<JRadioButton>();    			   
        public MovieGUI (String title, String filename) throws FileNotFoundException{
        	database = new MovieDatabase(filename);
	       	setTitle(title);
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300,375);
     		MovieWindow();		  
      	}	
        private void getComboYears(){
        	try {
        		years = database.getYears();
        	}
        	catch( NullPointerException ex ){
        		System.out.println( "Movies must be loaded before this operation" );
        	}
        	
        }
        private void getCategories(){
        	try {
        		categories = database.getCategories();
        	}
        	catch( NullPointerException ex ){
        		System.out.println( "Movies must be loaded before this operation" );
        	}	
        }
       
        private void addRadioButtons(){
        	category_group = new ButtonGroup();
          	
          	getCategories();
          	JRadioButton button;
          	for( String c : categories ){
          		button = new JRadioButton( c, false);
          		buttonList.add(button);
          		category_panel.add(button);	
          		category_group.add(button);

				button.addActionListener(e ->{
					list.setText(database.printSearchedMoviesForTextArea(database.searchMovies(c, years.get(yearcmb.getSelectedIndex()) )));
					currentCategory = c;
				});
          	}
          	buttonList.get(0).setSelected(true);
        }
        private void MovieWindow() {
        	setLayout(new FlowLayout());
        	
        	//get the years for the combo box and add the combo box
        	getComboYears();
        	JLabel yearLabel = new JLabel("Choose Year");
          	yearcmb = new JComboBox(years.toArray());
           	yearcmb.setSelectedIndex(0);
           	add(yearLabel);
          	add(yearcmb);

			yearcmb.addActionListener(e -> {
				list.setText(database.printSearchedMoviesForTextArea(database.searchMovies(currentCategory, years.get(yearcmb.getSelectedIndex()) )));
			});
          
          	//create button panel and add buttons using method
          	category_panel = new JPanel();
          	category_panel.setLayout(new BoxLayout(category_panel, BoxLayout.Y_AXIS));
          	category_panel.add(new JLabel("Categories", JLabel.CENTER));
          	add(category_panel);
          	addRadioButtons();
          	
          	//create movie list text area, add to scrollpane
          	list = new JTextArea(8, 20);
          	JScrollPane listScroll = new JScrollPane(list,
          	                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
          	                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
          	//add scroll pane to JFrame 
          	add(listScroll);         	                       
 			
 			
 			//create save button and add to JFrame
 			save = new JButton("SAVE TO FILE");
          	add(save);

			save.addActionListener(e->{
				try{
					FileWriter outStream = new FileWriter(currentCategory +  years.get(yearcmb.getSelectedIndex()) + ".txt");
			 		PrintWriter output = new PrintWriter(outStream);
					 

					String outString = database.printSearchedMovies(database.searchMovies(currentCategory, years.get(yearcmb.getSelectedIndex()) ));
					output.print(outString);
					System.out.println("File Written");
					output.close();
				}
				catch(IOException ex){
					System.err.println("Error Creating File");
			  		System.exit(1);
				}
				
			});
          	
          	//create menuBar and add menu/item and add to JFrame
          	menuBar = new JMenuBar();
          	menu = new JMenu("Options");
          	loadMovies = new JMenuItem("Exit");

			loadMovies.addActionListener(e ->{
				System.exit(0);
			});
          
			//add item to menu/menu to bar/bar to JFrame
			menu.add( loadMovies );
			menuBar.add(menu);
			this.setJMenuBar(menuBar);
			
		}//end MovieWindow	
}