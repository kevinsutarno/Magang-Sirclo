
public class Fiiva {
	
	void fiiva(int number) {
		for (int i = number ; i > 0; i--) {
			System.out.print(number - 1);
			System.out.print(number - 1);
			for(int j = 0; j<number; j++) {
				System.out.print(number+1);
			}
			System.out.println();
			number = number - 1;
		}
	}
	
	public static void main (String[] args) {
		Fiiva fiv = new Fiiva();
		fiv.fiiva(5);
	}
}
