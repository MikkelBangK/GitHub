/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private static final String DELETED = "DELETED";

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 *
	 * @param x
	 *            an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		boolean found = false;
		int i = 0;

		while (!found && i < buckets.length) {
			if (buckets[i] == x) {
				found = true;
			}
			i++;
		}
		return found;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		int h = hashValue(x);
		boolean next = false;
		if(buckets[h] == null || buckets[h] == DELETED){
			buckets[h] = x;
			currentSize++;
		}else {
			int i = h;
			while (!next){
				if(buckets[(i) % buckets.length] == null || buckets[i % buckets.length] == DELETED){
					buckets[(i) % buckets.length] =x;
					next =true;
					currentSize++;
				}
				i++;
			}
		}
		return next;
	}

	/**
	 * Removes an object from this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x was removed from this set, false if x was not an
	 *         element of this set
	 */
	public boolean remove(Object x) {
		// TODO
		boolean deleted = false;
		if(contains(x)){
			for(int i = 0; i < buckets.length; i++){
				if(buckets[i] == x){
					buckets[i] = DELETED;
					currentSize--;
					deleted = true;
				}

			}
		}
		return deleted;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		return h;
	}

	// method only for test purpose
	public void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			System.out.println(i + "\t" + buckets[i]);
		}
	}

}
