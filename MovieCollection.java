package finalProj;

public class MovieCollection {
	private Movie[] movies;
	public static final int DEF_SIZE = 10;
	
	//default constructor
	public MovieCollection() {
		init(DEF_SIZE);
	}
	
	
	//parameterized constructor
	public MovieCollection(int size) {
		init(size);
	}
	
	//initialize size of movie collection
	public void init(int size) {
		if(size >= 1) {
			movies = new Movie[size];
		}else {
			movies = new Movie[DEF_SIZE];
		}
	}
	
	public Movie[] getMovies() {
		return movies;
	}
	
	public void addMovie(Movie uM) {
		//making sure theres space AND that you're not adding a null object
		if(uM == null || movies[movies.length - 1] != null) {
			return;
		}
		
		for(int i = 0; i < movies.length; i++) {
			if(movies[i] == null) {
				movies[i] = uM;
				break;
			}
		}
	}
	
	public void removeMovie(String uT) {
		int index = -1;
		//searching through movies for the TITLE
		for (int i = 0; i < movies.length; i++) {
			if (movies[i] != null && movies[i].getTitle().equals(uT)) {
				index = i;
				break;
			}
		}
		
		//check if movie title was found in collection
		if (index == -1) {
			return;
		}
		
		for (int i = index; i < movies.length - 1; i++) {
			movies[i] = movies[i + 1];
		}
		
		//remove copy of the end of the string
		movies[movies.length - 1] = null;
	}
	
	public void searchByTitle(String uT) {
		for(int i = 0; i < movies.length - 1; i++) {
			if(movies[i] == null) {	
				//reached end of string and thus, end of search
				break;
			}
			
			if(movies[i].getTitle().equals(uT)) {
				System.out.println(movies[i].toString());
			}
		}
	}
	
	public void searchByDirector(String uD) {
		for(int i = 0; i < movies.length - 1; i++) {
			if(movies[i] == null) {	
				//reached end of string and thus, end of search
				break;
			}
			
			if(movies[i].getDirector().equals(uD)) {
				System.out.println(movies[i].toString());
			}
		}
	}
	
	public void searchByGenre(String uG) {
		for(int i = 0; i < movies.length - 1; i++) {
			if(movies[i] == null) {	
				//reached end of string and thus, end of search
				break;
			}
			
			if(movies[i].getGenre().equals(uG)) {
				System.out.println(movies[i].toString());
			}
		}
	}
	
	public void listAllMovies() {
		for(int i = 0; i < movies.length - 1; i++) {
			if(movies[i] == null) {	
				//reached end of string and thus, end of search
				break;
			}
			
			System.out.println(movies[i].toString());
		}
	}
}
