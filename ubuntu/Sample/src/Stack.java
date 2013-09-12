import java.util.ArrayList;

public class Stack<E> {
	private ArrayList<E> v;
	public Stack() {
		v = new ArrayList<E>();
	}
	public void push(E e) {
		v.add(e);
	}
	public E pop() {
		E e = v.get(v.size()-1);
		v.remove(v.size()-1);
		return e;
	}
	public boolean isEmpty() { return v.isEmpty(); }
	public int size() { return v.size(); }
}
