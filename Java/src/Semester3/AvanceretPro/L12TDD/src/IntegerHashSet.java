public class IntegerHashSet {

    private Integer[] buckets;
    private int currentSize;
    private final String DELETED = "DELETED";

    public IntegerHashSet(int bucketsLength) {
        buckets = new Integer[bucketsLength];
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    public boolean contains(Integer x) {
        boolean found = false;
        int index = hashValue(x);
        while (!found && buckets[index] != null) {
            if (buckets[index].equals(x)) {
                found = true;
            } else {
                index = (index + 1) % buckets.length;
            }
        }
        return found;
    }

    public boolean add(Integer x) {
        boolean found = false;
        int index = hashValue(x);
        while (!found && buckets[index] != null) {
            if (buckets[index].equals(x)) {
                found = true;
            } else {
                index = (index + 1) % buckets.length;
            }
        }
        if (!found) {
            buckets[index] = x;
            currentSize++;
        }
        return !found;
    }

    public boolean remove(Integer x) {
        boolean found = false;
        int index = hashValue(x);
        while (!found && buckets[index] != null) {
            if (buckets[index].equals(x)) {
                found = true;
            } else {
                index = (index + 1) % buckets.length;
            }
        }
        if (found) {
            buckets[index] = null;
            currentSize--;
        }
        return found;
    }

    private int hashValue(Integer x) {
        return x % buckets.length;
    }

    public String writeOut() {
        String out = "[";
        for (int i = 0; i < buckets.length; i++) {
            out += i + ":" + buckets[i] + ", ";
        }
        return out + "]";
    }
}
