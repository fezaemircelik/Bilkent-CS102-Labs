/**
 * @(#)MovieDatabase.java
 *
 *
 * @author 
 * @version 1.00 2022/7/16
 */

import java.util.*;
import java.util.zip.Inflater;
import java.io.*;
import javax.swing.JOptionPane;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	
    public MovieDatabase( String filename ) throws FileNotFoundException {
    	movieList = new ArrayList<Movie>();
    	loadMovies( filename );
    	JOptionPane.showMessageDialog( null, movieList.size() + " movies added...");
    }
    public void loadMovies( String fileName ) throws FileNotFoundException{

        Scanner inFile = new Scanner(new File(fileName));

        inFile.useDelimiter(",");
        inFile.useLocale(Locale.US);

        while(inFile.hasNext()){
            String movieName = inFile.next();
            String category = inFile.next();
            int year = inFile.nextInt();
            double length = inFile.nextDouble();
             //new movie
            Movie mov = new Movie(movieName, category, length, year);
            movieList.add(mov);
        }
    	
    }
    public ArrayList<Movie> searchMovies( String category, int year ){
        ArrayList<Movie> searchedMovies = new ArrayList<Movie>();

        for (int i = 0; i < movieList.size(); i++){
            if (movieList.get(i).getCategory().equalsIgnoreCase(category) && movieList.get(i).getYear() == year){
                searchedMovies.add(movieList.get(i));
            }
        }
    	
        return searchedMovies;
    }
    public String printSearchedMovies(ArrayList<Movie> x){
        String output = "";
        for (int i = 0; i < x.size(); i++){
            output += x.get(i).getMovieName() + "," + x.get(i).getCategory() + "," + x.get(i).getYear() + "," + x.get(i).getLength();
        }
        return output;
    }
    public String printSearchedMoviesForTextArea(ArrayList<Movie> x){
        String output = "";
        for (int i = 0; i < x.size(); i++){
            output += x.get(i).getMovieName() + "," + x.get(i).getLength();
        }
        return output;
    }

    public ArrayList<Integer> getYears(){
    	ArrayList<Integer> years = new ArrayList<Integer>();

        for (int i = 0; i < movieList.size(); i ++){
            if (years.contains(movieList.get(i).getYear())){}
            else years.add(movieList.get(i).getYear());
        }

        return years;
    }
    public ArrayList<String> getCategories(){
    	ArrayList<String> categories = new ArrayList<String>();

        for (int i = 0; i < movieList.size(); i++){
            if (categories.contains(movieList.get(i).getCategory())){}
            else categories.add(movieList.get(i).getCategory());
        }

        return categories;
    }

    //
    public String asd(){
        String output = "";
        for (int i = 0; i < movieList.size(); i++){
            output += movieList.get(i).toString() + "\n";
        }

        return output;
    }
}