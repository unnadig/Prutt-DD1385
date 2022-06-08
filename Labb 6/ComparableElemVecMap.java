import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class ComparableElemVecMap<E extends Comparable<E>> extends TreeMap<Integer,E> implements SparseVec<E> {
	ComparableElemVecMap() {
		super();
	}

	public void add(E elem) {
		int prevKey = minIndex();
		if ((prevKey > 0) || (prevKey == -1)) {
			add(0, elem);
			return;
		}

		Set<Integer> keySet = keySet();
		for (Integer key : keySet) {
			if (!keySet.contains(key+1)) {
				add(key+1, elem);
				return;
			}
		}
	}

	public void add(int pos, E elem) {
		int posVar = pos;
		if (posVar < 0) {
			posVar = 0;
		}

		put(posVar, elem);
	}

	public int indexOf(E elem) {
		// use entrySet()?
		Set<Integer> keySet = keySet();
		for (Integer key : keySet) {
			if (get(key) == elem) {
				return key;
			}
		}

		return -1;
	}

	public void removeAt(int pos) {
		remove(pos);
	}

	public void removeElem(E elem) {
		// use entrySet()?
		Set<Integer> keySet = keySet();
		for (Integer key : keySet) {
			if (get(key) == elem) {
				removeAt(key);
				return;
			}
		}

		return;
	}
	
	public int size() {
		return super.size();
	}

	public int minIndex() {
		if(size() == 0) {
			return -1;
		} else {
			return firstKey();
		}
	}

	public int maxIndex() {
		if (size() == 0) {
			return -1;
		} else {
			return lastKey();
		}
	}

	public E get(int pos) {
		return super.get(pos);
	}

	public Object[] toArray() {
		// use entrySet()?
		Object[] elemArray = new Object[maxIndex()+1];
		Set<Integer> keySet = keySet();
		for (Integer key : keySet) {
			elemArray[key] = get(key);
		}

		return elemArray;
	}

	public List<E> sortedValues() {
		// use entrySet()?
		ArrayList<E> elemArrayList = new ArrayList<E>();
		Set<Integer> keySet = keySet();
		for (Integer key : keySet) {
			elemArrayList.add(get(key));
		}

		return elemArrayList;
	}

	public String toString() {
		// use entrySet()?
		StringBuilder sb = new StringBuilder();
		Set<Integer> keySet = keySet();
		for (Integer key : keySet) {
			E value = get(key);
			sb.append(key);
			sb.append(" ");
			sb.append(value);
			sb.append(System.getProperty("line.separator"));
		}

		sb.setLength(sb.length()-1);
		return sb.toString();
	}
}