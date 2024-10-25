package search;

public abstract class SearchPattern<E extends Comparable<E>> {

    // Template method med søgeskabelonen
    public final boolean search(E m) {
        boolean found = false;
        init();
        while (!found && !isEmpty()) {
            E k = select();
            if (m.equals(k)) found = true;
            else split(m);
        }
        return found;
    }

    // Primitive metoder der kaldes fra Template Method og overskrives i subklasser
    protected abstract void init();

    protected abstract boolean isEmpty();

    protected abstract E select();

    protected abstract void split(E m);
}