public class DictionaryBST<K extends Comparable<K>, V> implements
Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
		// TODO
		Node found = find(key);
		return found != null ? found.value : null;

	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO
		return false;
	}

	@Override
	public V put(K key, V value) {
		// TODO
		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
		}else {
			// Locate the parent node
			Node parent = null;
			Node current = root;
			while (current != null) {
				if (newNode.key.compareTo(current.key) > 0) {
					parent = current;
					current = current.left;
				} else if (newNode.key.compareTo(current.key) < 0) {
					parent = current;
					current = current.right;
				} else {
					V oldValue = current.value;
					current.value = value;
					return oldValue;
				}
			}
				if (newNode.key.compareTo(parent.key) > 0) {
					parent.left = newNode;
				} else {
					parent.right = newNode;
				}
			}
		return null;
	}



	@Override
	public V remove(K key) {
		// TODO
		return null;
	}

	@Override
	public int size() {
		// TODO
		return -1;
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}


	}

}
