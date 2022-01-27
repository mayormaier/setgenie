import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {
    private String[] searchTerms;
    private List<Workout> searchResult;

    public Search(String ... terms){
        searchTerms = terms;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Terms:").append(Arrays.toString(searchTerms));
        sb.append("\nResults:");
        for (Workout w: searchResult){
            sb.append("\t").append(w.toString());
        }
        return sb.toString();
    }

    public String[] getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String[] searchTerms) {
        this.searchTerms = searchTerms;
    }

    public List<Workout> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Workout> searchResult) {
        this.searchResult = searchResult;
    }

    public List<Workout> executeSearch(List<Workout> workoutList){
        List<Workout> returnList = new ArrayList<>();
        for (Workout w: workoutList){
            for (String s: searchTerms){
                if (Integer.toString(w.getWorkoutDistance()).contains(s) || w.getWorkoutName().contains(s) || w.getWorkoutOwner().toString().contains(s) ){
                    returnList.add(w);
                }
            }
        }
        this.searchResult = returnList;
        return returnList;
    }
}
