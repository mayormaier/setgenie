package setgenie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

public class Search {
    private String[] searchTerms;
    private List<Workout> searchResult;
    private LocalDateTime searchTime;

    public Search(String... terms) {

        searchTerms = terms;
        searchTime = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Terms:").append(Arrays.toString(searchTerms));
        sb.append("\nResults:");
        for (Workout w : searchResult) {
            sb.append("\n\t").append(w.toString());
        }
        return sb.toString();
    }

    public String[] getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String[] searchTerms) {
        this.searchTerms = searchTerms;
    }

    public List<Workout> getSearchResult(List<Workout> workoutList) {
        if (searchTime == null){
            executeSearch(workoutList);
        }
        return searchResult;
    }

    public void setSearchResult(List<Workout> searchResult) {
        this.searchResult = searchResult;
    }

    public List<Workout> executeSearch(List<Workout> workoutList) {
        List<Workout> returnList = new ArrayList<>();
        for (Workout w : workoutList) {
            for (String s : searchTerms) {
                if (Integer.toString(w.getWorkoutDistance()).contains(s) || w.getWorkoutName().contains(s)
                        || w.getWorkoutOwner().toString().contains(s)) {
                    returnList.add(w);
                }
            }
        }
        this.searchResult = returnList;
        this.searchTime = LocalDateTime.now();
        return returnList;
    }
}
