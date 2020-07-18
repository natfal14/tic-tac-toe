
public class Board {
	public static char[] topRow = {' ', '|', ' ', '|', ' '};
	public static char[] midRow = {' ', '|', ' ', '|', ' '};
	public static char[] botRow = {' ', '|', ' ', '|', ' '};
	public static char[] sep = {'-', '+', '-', '+', '-'};
	
	public static void printBoard() {
		
		System.out.print(topRow);
		System.out.println();
		System.out.print(sep);
		System.out.println();
		System.out.print(midRow);
		System.out.println();
		System.out.print(sep);
		System.out.println();
		System.out.print(botRow);
		System.out.println();
		
	}
}
