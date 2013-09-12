import java.util.ArrayList;


public class Queue<E> {
	private ArrayList<E> v;
	public Queue(){
		v = new ArrayList<E>();
	}
	public void enqueue(E e) {
		v.add(e);
	}
	public E dequeue() {
		E e = v.get(0);
		v.remove(0);
		return e;
	}
	public boolean isEmpty() {
		return v.isEmpty();
	}
	
	

}
