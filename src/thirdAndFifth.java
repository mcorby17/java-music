import java.util.Scanner;

public class thirdAndFifth {
	
	static Scanner userInput = new Scanner(System.in);
	
	public enum Notes {
		AF, A, AS, BF, B, BS, CF, C, CS, DF, D, DS, EF, E, ES, FF, F, FS, GF, G, GS;
		
		public void showNext(){
			System.out.println(Notes.values()[this.ordinal()+1]);
		}
		
		public Notes returnNext(){
			return Notes.values()[this.ordinal()+1];
		}
		
		// Takes a note from the user and converts it to a Notes enum
		public static Notes getUserNoteInput(){
			
			int notesIndex = 0;
			boolean validNote = true;
			
			System.out.print("Enter a note: ");
			
			String userNote = userInput.nextLine();
			
			// Get the first letter to determine the starting range of the note
			char letter = Character.toLowerCase(userNote.charAt(0));
			
			do {
				
				switch(letter){
				case 'a':
					notesIndex = 1;
					break;
				case 'b':
					notesIndex = 4;
					break;
				case 'c':
					notesIndex = 7;
					break;
				case 'd':
					notesIndex = 10;
					break;
				case 'e':
					notesIndex = 13;
					break;
				case 'f':
					notesIndex = 16;
					break;
				case 'g':
					notesIndex = 19;
					break;
				default:
					System.out.println("That is not a musical letter.");
					validNote = false;
				}
				
				if(notesIndex != 0)
					validNote = true;
					
			} while(!validNote);
			
			// Now to see if a sharp or flat was entered (# or b)
			
			// if statement checks if the length is greater than 1. If so, there's a sharp or flat.
			if(userNote.length() > 1){
				
				char sharpOrFlat = userNote.charAt(1);
				
				switch(sharpOrFlat){
					case '#':
						notesIndex++;	//Bumps up the tone a semitone
						break;
					case 'b':
						notesIndex--;	//Bumps down the tone a semitone
						break;
				}
				
			}
			
			return Notes.values()[notesIndex];
			
		}
		
		public Notes getMajorThird(){
			
			// Can add 6 to index to get to next note
			
			// Need to make adding loop back to beginning if one of the last 6 notes
			
			// Then have to determine if it needs to be sharp or flat
				// This relies of key signature
				// Maybe make a new class that deals with key signatures
				// Could return an array of notes in the key
			
		}
		
	}
	
	
	
	public static void main(String[] args){
		
		Notes userNote = Notes.getUserNoteInput();
		
		System.out.println(userNote.toString());
		
	}

}
