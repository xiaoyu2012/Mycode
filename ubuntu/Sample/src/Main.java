class ST<Key, Value> {
	
}

public class Main {

	public static void main(String[] args) {
		Queue<String> s = new Queue<String>();
		s.enqueue("sdfsds");
		s.enqueue("fdf");
		while (!s.isEmpty())
			System.out.println(s.dequeue());
	}
	
}

