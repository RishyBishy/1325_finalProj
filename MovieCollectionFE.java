package finalProj;

import java.util.Scanner;

public class MovieCollectionFE {
	private static Scanner scan = new Scanner(System.in);
	private static MovieCollection movieCollection;
	
	public static void main(String[] args) {
		
		//welcome message
		System.out.println("Welcome to the Movie Management System!\n");
		System.out.println("How many movies are in your collection?");
		int size = Integer.parseInt(scan.nextLine());
		movieCollection = new MovieCollection(size);
		
		int choice = -1;
		
		//loop for all options (search/add/remove)
		do {
			printMenu();
			choice = Integer.parseInt(scan.nextLine());
			switch(choice) {
				case 1:
					addMovie();
					break;
				case 2:
					removeMovie();
					break;
				case 3:
					searchMovies();
					break;
				case 4:
					rateMovie();
					break;
				case 5:
					movieCollection.listAllMovies();
					break;
				case 9:
					System.out.println("Now exiting program...");
					break;
				default:
					System.out.println("Invalid choice input, please try again. ");
					break;
			}
		}while(choice != 9);
		
		System.out.println("\nThank you for using the Movie Collection System!");
		scan.close();
	}
	
	private static void printMenu() {
		System.out.println("\nMenu: ");
		System.out.println("1. Add Movie");
		System.out.println("2. Remove Movie");
		System.out.println("3. Search Movie");
		System.out.println("4. Rate a Movie");
		System.out.println("5. List All Movies");
		
		System.out.println("9. Exit");
	}
	
	private static void addMovie() {
		System.out.println("Enter the title:");
		String title = scan.nextLine();
		System.out.println("Enter the directors name:");
		String director = scan.nextLine();
		System.out.println("Enter the release year:");
		int year = Integer.parseInt(scan.nextLine());
		System.out.println("Enter the genre:");
		String genre = scan.nextLine();
		
		Movie temp = new Movie(title, director, year, genre);
		movieCollection.addMovie(temp);
	}
	
	private static void removeMovie() {
		System.out.println("What is the name of the movie that you would like to remove?");
		String title = scan.nextLine();
		
		movieCollection.removeMovie(title);
	}
	
	private static void searchMovies() {
		System.out.println("Search by:");
		System.out.println("1. Title");
		System.out.println("2. Director");
		System.out.println("3. Genre");
		
		int selection = Integer.parseInt(scan.nextLine());
		switch(selection) {
			case 1:
				System.out.println("Enter the title:");
				String title = scan.nextLine();
				movieCollection.searchByTitle(title);
				break;
			case 2:
				System.out.println("Enter the directors name: ");
				String director = scan.nextLine();
				movieCollection.searchByDirector(director);
				break;
			case 3:
				System.out.println("Enter the genre (action, drama, etc.): ");
				String genre = scan.nextLine();
				movieCollection.searchByGenre(genre);
				break;
			default:
				System.out.println("Invalid option, please try again.");
				break;
		}
	}
	
	//rate movie function
	//nothing added in any of the methods for that functionality yet though
	private static void rateMovie() {
		movieCollection.listAllMovies();
		System.out.println("\nEnter a title from one of the movies in the collection above that you would like to rate: ");
		
		//actual rating process
	}
}
