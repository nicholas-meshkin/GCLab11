package gcLab11;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
//import java.util.Map;
import java.util.TreeSet;
import java.util.HashMap;

public class GCLab11 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userCont = "y";
		List<Movie> movieList = new ArrayList<>();
		// movies I added before getting david's list
//		movieList.add(new Movie("2001: A Space Odyssey", "Sci-Fi"));
//		movieList.add(new Movie("The Ballad of Buster Scruggs", "Anthology"));
//		movieList.add(new Movie("Isle of Dogs", "Stop-Motion"));
//		movieList.add(new Movie("Moon", "Sci-Fi"));
//		movieList.add(new Movie("Tokyo!", "Anthology"));
//		movieList.add(new Movie("The Fantastic Mr. Fox", "Stop-Motion"));
//		movieList.add(new Movie("Ex Machina", "Sci-Fi"));
//		movieList.add(new Movie("Looper", "Sci-Fi"));
//		movieList.add(new Movie("Her", "Sci-Fi"));
//		movieList.add(new Movie("The Matrix", "Sci-Fi"));

		// populates list with movies
		for (int d = 1; d < 101; d++) {
			movieList.add(MovieIO.getMovie(d));
		}

		// gets a set of all of the categories
		Set<String> catSet = new HashSet<>();
		for (int i = 0; i < movieList.size(); i++) {
			String tempCat;
			Movie tempMov;
			tempMov = movieList.get(i);
			tempCat = tempMov.getCategory();
			catSet.add(tempCat);
		}

		// creates a hashmap with each category associated with a digit from 1 to the
		// number of categories
		HashMap<Integer, String> catChoices = new HashMap<>();
		int i = 1;
		for (String cat : catSet) {
			catChoices.put(i, cat);
			i++;
		}

		System.out.println("Welcome to the Movie List Application!");

		do {
			printCatChoices(catChoices);
			int userSelection = Validator.getInt(scnr, "What movie category are you interested in?");
			if (catChoices.containsKey(userSelection)) {
				TreeSet<String> alphList = new TreeSet<>(); //puts the category items in alphabetical order
				for (int k = 0; k < movieList.size(); k++) {
					Movie tempMov;
					tempMov = movieList.get(k);
					String tempCat = tempMov.getCategory();
					if (tempCat.equals(catChoices.get(userSelection))) {
						alphList.add(tempMov.getTitle());
					}

				}
				for(String titleSelection : alphList) {
					System.out.println(titleSelection);
				}
				
				
			} else {
				System.out.println("You did not enter a valid selection");
			}
			userCont = Validator.getString(scnr, "Press \"y\" to continue, any other key to exit.");
		} while (userCont.equalsIgnoreCase("y"));

		System.out.println("Thank you for using the Movie List Application!");
		scnr.close();
	}

	public static void printCatChoices(HashMap<Integer, String> catPrint) {
		System.out.println("Please enter the number associated with the desired category. Here are your choices:");
		for (int j = 1; j < catPrint.size() + 1; j++) {
			System.out.printf("%-3d", j);
			System.out.printf("%-15s", catPrint.get(j));
			System.out.println();
		}
	}

}
