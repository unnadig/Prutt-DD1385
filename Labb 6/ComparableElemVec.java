import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class ComparableElemVec<E extends Comparable<E>> implements SparseVec<E> {
	TreeMap<Integer, E> treeMap;

	ComparableElemVec() {
		this.treeMap = new TreeMap<Integer, E>();
	}

	@Override
	public void add(E elem) {
		int prevKey = minIndex();
		if ((prevKey > 0) || (prevKey == -1)) {
			add(0, elem);
			return;
		}

		Set<Integer> keySet = treeMap.keySet();
		for (Integer key : keySet) {
			if (!keySet.contains(key+1)) {
				add(key+1, elem);
				return;
			}
		}
	}

	@Override
	public void add(int pos, E elem) {
		int posVar = pos;
		if (posVar < 0) {
			posVar = 0;
		}

		treeMap.put(posVar, elem);
	}

	@Override
	public int indexOf(E elem) {
		// use entrySet()?
		Set<Integer> keySet = treeMap.keySet();
		for (Integer key : keySet) {
			if (get(key) == elem) {
				return key;
			}
		}

		return -1;
	}

	@Override
	public void removeAt(int pos) {
		treeMap.remove(pos);
	}

	@Override
	public void removeElem(E elem) {
		// use entrySet()?
		Set<Integer> keySet = treeMap.keySet();
		for (Integer key : keySet) {
			if (get(key) == elem) {
				removeAt(key);
				return;
			}
		}
		return;
	}

	@Override
	public int size() {
		return treeMap.size();
	}

	@Override
	public int minIndex() {
		if(size() == 0) {
			return -1;
		} else {
			return treeMap.firstKey();
		}
	}

	@Override
	public int maxIndex() {
		if (size() == 0) {
			return -1;
		} else {
			return treeMap.lastKey();
		}
	}

	@Override
	public E get(int pos) {
		return treeMap.get(pos);
	}

	@Override
	public Object[] toArray() {
		// use entrySet()?
		Object[] elemArray = new Object[maxIndex()+1];
		Set<Integer> keySet = treeMap.keySet();
		for (Integer key : keySet) {
			elemArray[key] = get(key);
		}

		return elemArray;
	}

	@Override
	public List<E> sortedValues() {
		// use entrySet()?
		ArrayList<E> elemArrayList = new ArrayList<E>();
		Set<Integer> keySet = treeMap.keySet();
		for (Integer key : keySet) {
			elemArrayList.add(get(key));
		}

		return elemArrayList;
	}

	@Override
	public String toString() {
		// use entrySet()?
		StringBuilder sb = new StringBuilder();
		Set<Integer> keySet = treeMap.keySet();
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