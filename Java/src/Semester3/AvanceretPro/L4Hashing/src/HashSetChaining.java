/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetChaining {
	private Node[] buckets;
	private int currentSize;

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength the length of the buckets array
	 */
	public HashSetChaining(int bucketsLength) {
		buckets = new Node[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 *
	 * @param x an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		int h = hashValue(x);
		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
			} else {
				current = current.next;
			}
		}
		return found;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		int h = hashValue(x);
		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
				// Already in the set
			} else {
				current = current.next;
			}
		}
		if (!found) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.next = buckets[h];
			buckets[h] = newNode;
			currentSize++;
		} if (loadFactor() > 0.75) {
			rehash();
		}
		return !found;
	}

	/**
	 * Removes an object from this set.
	 *
	 * @param x an object
	 * @return true if x was removed from this set, false if x was not an element of this set
	 */
	public boolean remove(Object x) {
		int h = hashValue(x);
		Node current = buckets[h];
		Node previous = null;
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
				if (previous == null) {
					buckets[h] = current.next;
				} else {
					previous.next = current.next;
				}
				currentSize--;
			} else {
				previous = current;
				current = current.next;
			}
		}
		return found;
	}

	public void rehash() {
		Node[] temp = buckets;
		buckets = new Node[2 * temp.length];
		for (int i = 0; i < temp.length; i++) {
			Node current = temp[i];
			while (current != null) {
				Node next = current.next;
				int h = hashValue(current.data);
				current.next = buckets[h];
				buckets[h] = current;
				current = next;
			}
		}
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		return h;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	public double loadFactor(){
		return(double) currentSize /buckets.length;
	}

	// method only for test purpose
	void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			Node temp = buckets[i];
			if (temp != null) {
				System.out.print(i + "\t");
				while (temp != null) {
					System.out.print(temp.data + "\t");
					temp = temp.next;
				}
				System.out.println();
			}
		}
	}

	class Node {
		public Object data;
		public Node next;
	}
}
