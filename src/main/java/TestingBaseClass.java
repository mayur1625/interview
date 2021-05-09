import java.util.*;

public class TestingBaseClass {
    public static void main(String[] args) {
        // Stores regional movie ratings
        Map<String, Map<Integer, Set<Integer>>> regionalMovieRatings = new HashMap<>();

        // This will throw NullPointerException!
        //regionalMovieRatings.get("New York").get(5).add("Boyhood");

        // This will work
        regionalMovieRatings
                .computeIfAbsent("New York", region -> new HashMap<>())
                .computeIfAbsent(5, rating -> new HashSet<>())
                .add(101011);

        regionalMovieRatings
                .computeIfAbsent("New York", region -> new HashMap<>())
                .computeIfAbsent(5, rating -> new HashSet<>())
                .add(101012);



        int duplicateElement = 202012;

        regionalMovieRatings
                .computeIfAbsent("New York", region -> new HashMap<>())
                .computeIfAbsent(7, rating -> new HashSet<>())
                .add(duplicateElement);
        regionalMovieRatings
                .computeIfAbsent("New York", region -> new HashMap<>())
                .computeIfAbsent(7, rating -> new HashSet<>())
                .add(duplicateElement);

        regionalMovieRatings
                .computeIfAbsent("India", region -> new HashMap<>())
                .computeIfAbsent(3, rating -> new HashSet<>())
                .add(343434);
        System.out.println(regionalMovieRatings);
        System.out.println(regionalMovieRatings.get("India"));
    }
}
