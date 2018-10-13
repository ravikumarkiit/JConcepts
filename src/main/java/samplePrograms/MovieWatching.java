package samplePrograms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MovieWatching {
	
    public static Boolean ifAllMovieViewable(Collection<Movie> movies) {
    	List<Movie> originalCopy = (List)movies;
        List<Movie> toVerifyCopy = new ArrayList<Movie>();
        
    	boolean overlapsFlag = false;
    	for(Movie movieToVerify : originalCopy) {
    		toVerifyCopy.clear();
    		toVerifyCopy.addAll(originalCopy);
    		toVerifyCopy.remove(movieToVerify);
    		for(Movie movie : toVerifyCopy) {
    			overlapsFlag = isOverlapping(movieToVerify.getStart(), movieToVerify.getEnd(), movie.getStart(), movie.getEnd());
    			if(overlapsFlag) {
    				return !overlapsFlag;
    			}
    		}
    		/*if(overlapsFlag) {
				System.out.println("breakOutside");
				break;
			}*/
    	}
    	return !overlapsFlag;
    }
    
    public static boolean ifAllMovieViewableJava8(Collection<Movie> movies) {
    	List<Movie> list = new ArrayList<>(movies);
    	/*BiPredicate<Movie, Movie> isOverlap = (movie1, movie2) -> movie1.getStart().before(movie2.getEnd()) && movie2.getStart().before(movie1.getEnd());
    	return !list.stream().anyMatch(movie -> {
    		return movies.stream().filter(m -> m!=movie).anyMatch(against -> isOverlap.test(movie, against));
    	});*/
    	
    	Condition condition = (movie1, movie2) -> movie1.getStart().before(movie2.getEnd()) && movie2.getStart().before(movie1.getEnd());
    	return !list.stream().anyMatch(movie -> {
    		return movies.stream().filter(m -> m!=movie).anyMatch(against -> condition.isOverlap(movie, against));
    	});
    		
    }
    
    interface Condition {
    	boolean isOverlap(Movie movie1, Movie movie2);
    } 
    
    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:20"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        System.out.println(MovieWatching.ifAllMovieViewable(movies));
        System.out.println(MovieWatching.ifAllMovieViewableJava8(movies));
    }
}

class Movie {
    private Date start, end;
    
    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
    
    public String toString() {
    	return start.toString() + " "+ end.toString();
    }
}
