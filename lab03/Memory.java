import java.util.Scanner;
import java.util.Random;

public class Memory extends CardGame {
	private Card firstCard;
	private Card secondCard;
	private Card[][] memoryDeck;
	private int guesses;
	public int count;

	public static final int MAX_GUESSES = 52;
	
	public Memory(){
		count = 0;
		guesses = 0;
		memoryDeck = new Card[4][13];
		int row = 0;
		int col = 0;
		while(row < 4){
			col = 0;
			while( col < 13 ){
				Random r = new Random();
				int card = r.nextInt(52);
				if(!deck[card].faceUp){
					memoryDeck[row][col] = new Card(deck[card]);
					deck[card].flip();
					col++;
				}	
			}
			row++;
		}
	}

	public void printGame(){
		for( int r = 0; r < 4; r++ ){
			for(int c = 0; c < 13; c++){
				if( !memoryDeck[r][c].isFlipped()){
					System.out.printf("%8s","******");
				}
				else {
					System.out.printf( "%8s",memoryDeck[r][c]);
				}
				
			}
			System.out.println();
		}
	}
	public boolean isMatch() {
		if(firstCard.getValue() == secondCard.getValue()) {
				firstCard.flip();
				secondCard.flip();
				count++;
				return true;
		}
		return false;
	}

	@Override
	public void play() {
		for( int r = 0; r < 4; r++ ){
			for(int c = 0; c < 13; c++){
					System.out.printf( "%8s",memoryDeck[r][c]);
			}
			System.out.println();
		}
		// TODO Auto-generated method stub
		printGame();

		while(!win() || guesses < MAX_GUESSES){
			System.out.println();

			System.out.print("Enter row and column of card: ");
			Scanner in = new Scanner(System.in);
			int row1 = in.nextInt();
			int column1 = in.nextInt();
			while (row1 > 3 || column1 > 12){
				System.out.println("these numbers are invalid for this game!");
				row1 = in.nextInt();
				column1 = in.nextInt();
			}
			firstCard = memoryDeck[row1][column1];
			memoryDeck[row1][column1] = firstCard;
			while (memoryDeck[row1][column1].faceUp == true){
				System.out.println("This card has already been flipped!");
				row1 = in.nextInt();
				column1 = in.nextInt();
				firstCard = memoryDeck[row1][column1];
				memoryDeck[row1][column1] = firstCard;
			}
			System.out.println(firstCard.toString());
			
			System.out.print("Enter row and column of card: ");
			int row2 = in.nextInt();
			int column2 = in.nextInt();
			while (row2 > 3 || column2 > 12){
				System.out.println("these numbers are invalid for this game!");
				row2 = in.nextInt();
				column2 = in.nextInt();
			}
			while (row2 == row1 && column1 == column2){
				System.out.println("You cannot pick the same card twice!");
				row2 = in.nextInt();
				column2 = in.nextInt();
			}
			secondCard = memoryDeck[row2][column2];
			memoryDeck[row2][column2] = secondCard;
			while (memoryDeck[row2][column2].faceUp == true){
				System.out.println("This card has already been flipped!");
				row2 = in.nextInt();
				column2 = in.nextInt();
				secondCard = memoryDeck[row2][column2];
				memoryDeck[row2][column2] = secondCard;
			}
			guesses++;

			System.out.println(secondCard.toString());
		
			if(isMatch()){
				memoryDeck[row1][column1].faceUp = true;
				memoryDeck[row2][column2].faceUp = true;
				System.out.println("Match Found!");
			}
			else{
				System.out.println("No Match!");
			}

			printGame();
		}

		if (win()){
			System.out.println("YOU WON !!");
		}
		else{
			System.out.println("YOU LOST !!");
		}
		
	}

	@Override
	public boolean win() {
		if (count == 26) return true;
		return false;
	}	
}