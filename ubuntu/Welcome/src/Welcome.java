/**
 * This program displays a greeting from the auther
 * 
 * @version 1.7.0_21 2013-07-08
 * @author yyh
 */
public class Welcome {
	public static void main(String[] args) {

		String[] greeting = new String[3];
		greeting[0] = "Welcome to Core Java";
		greeting[1] = "by Yang Yuhang";
		greeting[2] = "and by ";

		/*for (int i = 0; i < greeting.length; i++) {
			System.out.println(greeting[i]);
			System.out.println();
		}*/
		for (String i : greeting)
			System.out.println(i);
			
	}

}
