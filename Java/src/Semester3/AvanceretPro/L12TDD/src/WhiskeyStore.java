import java.util.ArrayList;

public class WhiskeyStore {

    private ArrayList whiskies;

    public WhiskeyStore() {
        this.whiskies = new ArrayList<>();
    }

    public ArrayList getWhiskies() {
        return new ArrayList<>(whiskies);
    }

    public void addWhisky(Object whisky) {
        whiskies.add(whisky);
    }
}
