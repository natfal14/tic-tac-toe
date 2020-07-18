
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Board board = new Board();
		board.printBoard();
		List<Integer> placedPieces = new ArrayList<>(); //to avoid replacing one piece with another if the slot is full
														//each used slot is placed into the list
		
		while(true) {
			
			Random rand = new Random();
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your placement: ");
			int userPlace = scan.nextInt();
			
			if(userPlace < 10 && userPlace > 0 && placedPieces.contains(userPlace) == false) {
			
				playNext(userPlace, board, 'X');
				board.printBoard();
				
				if(checkWinner(board))
					break;
				
				System.out.println();
				System.out.print("CPU's turn...");
				System.out.println();
				
				try
				{
				    Thread.sleep(1000);
				}
				catch(InterruptedException ex)
				{
				    Thread.currentThread().interrupt();
				}
				
				placedPieces.add(userPlace);
				
				int cpuPlace = rand.nextInt(9) + 1;
				
				while(placedPieces.contains(cpuPlace) == true) {
					cpuPlace = rand.nextInt(9) + 1;
				}
				
				playNext(cpuPlace, board, 'O');
				placedPieces.add(cpuPlace);
					
				
				board.printBoard();

				if(checkWinner(board))
					break;
			}
			
			else {
				System.out.print("Please enter a valid value");
				System.out.println();
			}
			
		}
	}
	
	
	// inserts a piece into the board with the given placementNum
	public static void playNext(int placementNum, Board board, char XO) {
		
		switch(placementNum) {
			case 1:
				board.topRow[0] = XO;
				break;
			case 2:
				board.topRow[2] = XO;
				break;
			case 3:
				board.topRow[4] = XO;
				break;
			case 4:
				board.midRow[0] = XO;
				break;
			case 5:
				board.midRow[2] = XO;
				break;
			case 6:
				board.midRow[4] = XO;
				break;
			case 7:
				board.botRow[0] = XO;
				break;
			case 8:
				board.botRow[2] = XO;
				break;
			case 9:
				board.botRow[4] = XO;
				break;
			default:
				break;
				
		}
		
	}
	
	public static boolean checkWinner(Board board) {

		List<Character> topRowList = Arrays.asList(board.topRow[0], board.topRow[2], board.topRow[4]);
		List<Character> midRowList = Arrays.asList(board.midRow[0], board.midRow[2], board.midRow[4]);
		List<Character> botRowList = Arrays.asList(board.botRow[0], board.botRow[2], board.botRow[4]);
		List<Character> leftCol = Arrays.asList(board.topRow[0], board.midRow[0], board.botRow[0]);
		List<Character> midCol = Arrays.asList(board.topRow[2], board.midRow[2], board.botRow[2]);
		List<Character> rightCol = Arrays.asList(board.topRow[4], board.midRow[4], board.botRow[4]);
		List<Character> diag1 = Arrays.asList(board.topRow[0], board.midRow[2], board.botRow[4]);
		List<Character> diag2 = Arrays.asList(board.topRow[4], board.midRow[2], board.botRow[0]);
		List<Character> userWin = new ArrayList(); 
		List<Character> cpuWin = new ArrayList(); 
		
		userWin.add('X');
		userWin.add('X');
		userWin.add('X');
		
		cpuWin.add('O');
		cpuWin.add('O');
		cpuWin.add('O');
		
		if(topRowList.equals(userWin) || midRowList.equals(userWin) || botRowList.equals(userWin)
				|| diag1.equals(userWin) || diag2.equals(userWin) || leftCol.equals(userWin) || midCol.equals(userWin)
				|| rightCol.equals(userWin)) {
			System.out.print("User wins! Congrats!");
			return true;
		}
		
		else if(topRowList.equals(cpuWin) || midRowList.equals(cpuWin) || botRowList.equals(cpuWin)
				|| diag1.equals(cpuWin) || diag2.equals(cpuWin) || leftCol.equals(cpuWin) || midCol.equals(cpuWin)
				|| rightCol.equals(cpuWin)) {
			System.out.print("CPU wins! Better luck next time!");
			return true;
		}
		
		else if(leftCol.contains(' ') == false && midCol.contains(' ') == false && rightCol.contains(' ') == false) {
			System.out.print("It's a tie!");
			return true;
		}
			return false;
		
	}

	
}
