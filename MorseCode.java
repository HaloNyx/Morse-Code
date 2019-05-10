//Juleen Chen
//ICS3UF, Ms. Krasteva
//15/01/2018
//MorseCode - ISP assignment. Teaches the user the basics of Morse code, includes a Morse code to english and an english to Morse code translator. Also includes a randomised ten-question quiz, and records high scores.

//Instance variable dictionary:
//Name:            Type:             Purpose:
//temp             String            Used to store user input before parsing.
//choice           int               The user's choice in mainMenu.
//MAXLENGTH        static final int  The length of playerNames and playerScores arrays.
//question         int[]             An array of ten randomized numbers determining the order the questions in quiz output in.
//questionCount    int               The number of questions the user has attempted.
//correctCount     int               The number of questions the user has answered correctly.
//option           int               The user's choice in quiz.
//playerNames      String[]          An array containing the top ten scoring players' names.
//playerScores     String[]          An array containing the top ten scoring players' scores.
//questionList     String[]          An array of all the quiz questions.
//answerList       String[]          An array of the correct answers to each question in questionList (with corresponding indices).

// The "MorseCode" class.
import java.awt.*;
import hsa.Console;
import javax.swing.JOptionPane;
import java.io.*;

public class MorseCode
{
    Console c;           // The output console

    String temp;
    int choice;
    static final int MAXLENGTH = 10;
    int[] question = new int [MAXLENGTH];
    int questionCount = 0;
    int correctCount;
    int option;
    String[] playerNames = new String [MAXLENGTH];
    String[] playerScores = new String [MAXLENGTH];
    String[] questionList = {"What are the code characters used in Morse Code called? \n1. Dots and dashes \n2. Points and slashes \n3. On and offs \n4. True and false \n",  //answer: 1
	"Which character is represented by \"-\" in morse code? \n1. \"A\" \n2. \"T\" \n3. \"E\" \n4. \"0\"\n",  //answer: 2
	"Which is the correct translation for \"MORSE\" in Morse code? \n1. -.-.\\---\\.-.\\...\\.\\ \n2. --\\....\\.-.\\...\\.\\ \n3. --\\-.--\\.-.\\....\\.\\ \n4. --\\---\\.-.\\...\\.\\\n",  //answer: 4
	"The english translation for \".-..\\..\\..-.\\.\\\" is: \n1. Live \n2. Life \n3. Lose \n4. Love \n",  //answer: 2
	"Which is the correct translation of the numbers 0 to 9 in Morse code? \n1. -----\\.----\\..---\\...--\\....-\\.....\\-....\\--...\\---..\\----. \n2. -....\\.-...\\..-..\\...-.\\....-\\.----\\-.---\\--.--\\---.-\\----.\n3. .\\..\\...\\....\\.....\\-\\--\\---\\----\\-----\n4. .\\-\\..\\--\\...\\---\\....\\----\\.....\\-----\n",  //answer: 1
	"Which of the following is most commonly used to convey Morse code messages?\n1. Writing out symbols on paper\n2. Light and sound\n3. A typewriter or keyboard.\n4. Blinking\n",  //answer: 2
	"Which character is represented by \".-\" in Morse code?\n1. 1\n2. i\n3. A\n4. 3\n",  //answer: 3
	"Which of the following translate to \"HELLO\"?\n1. .--\\.\\--\\--\\..\n2. ....\\.\\.-..\\.-..\\---\n3. -.-\\...\\-\\-\\....\n4. -.-\\...\\---\\---\\----\n",  //answer: 2
	"Which of the following equate to 5?\n1. -----\\\n2. .\\ plus --\n3. --.--\\ minus .----\\\n4. ....-\\ plus .----\\\n",  //answer: 4
	"Which of the following is correct?\n1. A \"-\" is a longer signal than a \".\"\n2. A \".\" is a longer signal than a \"-\"\n3. A \"-\" and a \".\" are the same length\n4. \".\" and  \"-\" have nothing to do with timing\n"}; //answer: 1
    String[] answerList = {"1", "2", "4", "2", "1", "2", "3", "2", "4", "1"};

    //title - clears the screen and displays the title.
    private void title ()
    {
	c.clear ();
	c.print ("", 35);
	c.println ("Morse Code");
	c.println ();
    }

    //pauseProgram - pauses the program until the user presses a key.
    private void pauseProgram ()
    {
	c.println ();
	c.print ("Press any key to continue: ");
	c.getChar ();
    }

    
    //splashScreen - shows an animation.
    //try block 1 - can throw Exception
    //catch block 1 - catches Exception
    
    public void splashScreen ()
    {
	SplashScreen i = new SplashScreen (c);
	i.start ();
	try//try block 1
	{
	    Thread.sleep (22000);
	}
	catch (Exception e)//catch block 1
	{
	}
    }

    //mainMenu - the main menu.
    
    //while loop 1 - loops until the user enters a valid choice value.
    
    //if statement 1 - throws exception if the user's choice less than 1 or greater than 8.
    
    //try block 1 - can throw NumberFormatException or IllegalArgument Exception.
    //catch block 1 - catches NumberFormatException, displays JOptionPane error message "Please enter a number."
    //catch block 1 - catches IllegalArgummentException, displays JOptionPane error message "Please enter a valid choice (A number from 1 to 8)."
    
    public void mainMenu ()
    {
	c.clear ();
	c.setTextBackgroundColor (new Color (200, 250, 200));
	questionCount = 0;
	correctCount = 0;
	while (true)//while loop 1
	{
	    try//try block 1
	    {
		title ();
		c.println ("1. Instructions");
		c.println ("2. Introduction to Morse code");
		c.println ("3. English to Morse code translator");
		c.println ("4. Morse code to English translator");
		c.println ("5. Quiz");
		c.println ("6. High scores");
		c.println ("7. Erase high scores");
		c.println ("8. Exit");
		c.println ();
		c.print ("Enter your choice: ");
		temp = c.readLine ();
		choice = Integer.parseInt (temp);
		if (choice < 1 || choice > 8)//if statement 1
		{
		    throw new IllegalArgumentException ("Please enter a valid choice (A number from 1 to 8).");
		}
		break;
	    }
	    catch (NumberFormatException e)//catch block 1
	    {
		JOptionPane.showMessageDialog (null, "Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    catch (IllegalArgumentException e)//catch block 2
	    {
		JOptionPane.showMessageDialog (null, e.getMessage (), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    //instructions - description of the program and its functions
    public void instructions ()
    {
	title ();
	c.println ("Hello! This program can teach you morse code and also allows you to translate   from english to morse code and vice versa. There is also a quiz to test your    knowledge on morse code translation once you are finished learning, and the     program records your high scores. Individual sets of instructions are included  in each individual portion of the program.");
	pauseProgram ();
    }

    //introduction - an introduction to Morse code - includes a conversion chart from english characters to Morse code
    public void introduction ()
    {
	title ();
	c.println ("Morse code is a code in which the alphabet of the english language are          represented by combinations of short and long signals of light or sound.        Short signals are dots, or \".\", and long signals are dashes, or \"-\". The        following chart shows letters, numbers, and their morse code equivalents: ");
	c.println ();
	c.println ("Letters:");
	c.print ("A    .-", 20);
	c.print ("B    -...", 20);
	c.print ("C    -.-.", 20);
	c.print ("D    -..", 20);
	c.print ("E    .", 20);
	c.print ("F    ..-.", 20);
	c.print ("G    --.", 20);
	c.print ("H    ....", 20);
	c.print ("I    ..", 20);
	c.print ("J    .---", 20);
	c.print ("K    -.-", 20);
	c.print ("L    .-..", 20);
	c.print ("M    --", 20);
	c.print ("N    -.", 20);
	c.print ("O    ---", 20);
	c.print ("P    .--.", 20);
	c.print ("Q    --.-", 20);
	c.print ("R    .-.", 20);
	c.print ("S    ...", 20);
	c.print ("T    -", 20);
	c.print ("U    ..-", 20);
	c.print ("V    ...-", 20);
	c.print ("W    .--", 20);
	c.print ("X    -..-", 20);
	c.print ("Y    -.--", 20);
	c.print ("Z    --..", 20);
	c.println ();
	c.println ();
	c.println ("Numbers:");
	c.print ("1    .----", 20);
	c.print ("2    ..---", 20);
	c.print ("3    ...--", 20);
	c.print ("4    ....-", 20);
	c.print ("5    .....", 20);
	c.print ("6    -....", 20);
	c.print ("7    --...", 20);
	c.print ("8    ---..", 20);
	c.print ("9    ----.", 20);
	c.print ("0    -----", 20);
	c.println ();
	pauseProgram ();
    }

    
    //engToMorse - English to Morse code translator.
    
    //while loop 1 - loops until the user enters a vaild string to translate.
    //for loop 1  - loops through the user's input to make sure that all characters entered were valid.
    
    //if statement 1 - throws exception if the character is not translatable.
    
    //try block 1 - can throw IllegalArgumentException
    //catch block 1 - catches IllegalArgumentException - displays JOptionPane error message "Please only enter letters, numbers, or blank spaces into the translator."
    public void engToMorse ()
    {
	while (true)//while loop 1
	{
	    title ();
	    c.print ("Enter a string in English that you wish to translate into Morse code: ");

	    temp = c.readLine ();
	    c.println ();

	    try//try block 1
	    {
		for (int i = 0 ; i < temp.length () ; i++) // for loop 1
		{
		    if ((temp.charAt (i) < 'A' || temp.charAt (i) > 'Z') && (temp.charAt (i) < 'a' || temp.charAt (i) > 'z') && (temp.charAt (i) < '0' || temp.charAt (i) > '9') && temp.charAt (i) != ' ')//if statement 1
		    {
			throw new IllegalArgumentException ();
		    }
		}
		break;
	    }
	    catch (IllegalArgumentException e)//catch block 1
	    {
		JOptionPane.showMessageDialog (null, "Please only enter letters, numbers, or blank spaces into the translator.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	c.println ("The translation is: " + returnMorse (temp));
	c.println ();
	c.println ("Note: \".\" represents a dot, \"-\" represents a dash,\"\\\" indicates the end of an   individual character sequence (including blank spaces), and \" \" (a blank space) is used to represent a space between words.");
	pauseProgram ();
    }

    //returnMorse - returns the Morse translation of the user's input.

    //Local variable dictionary:
    //Name:            Type:             Purpose:
    //arrMorse         String[]          An array of all the program-translatable characters in Morse Code.
    //arrLowerCase     char[]            An array of all the lower case letters as well as numerical characters.
    //arrUpperCase     char[]            An array of all the upper case letters as well as numerical characters.
    //ARRLENGTH        final int         The length of the arrMorse, arrLowerCase, and arrUpperCase arrays.
    //morse            String            The morse code translation of the user's input.

    //for loop 1 - loops through the characters in the user's input.
    //for loop 2 - loops through the arrLowerCase and arrUpperCase arrays to find the correct indice of the entered character so that the corresponding morse value can be stored.

    //if statement 1 - checks to see if the user input character matches the array element. If yes, the corresponding morse element is added to the translation.
    private String returnMorse (String temp)
    {
	String[] arrMorse = {".-\\", "-...\\", "-.-.\\", "-..\\", ".\\", "..-.\\", "--.\\", "....\\", "..\\", ".---\\", "-.-\\", ".-..\\", "--\\", "-.\\", "---\\", ".--.\\", "--.-\\", ".-.\\", "...\\", "-\\", "..-\\", "...-\\", ".--\\", "-..-\\", "-.--\\", "--..\\", ".----\\", "..---\\", "...--\\", "....-\\", ".....\\", "-....\\", "--...\\", "---..\\", "----.\\", "-----\\", " \\"};
	char[] arrLowerCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
	char[] arrUpperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
	final int ARRLENGTH = 37;
	String morse = "";
	for (int i = 0 ; i < temp.length () ; i++)//for loop 1
	{
	    for (int x = 0 ; x < ARRLENGTH ; x++)//for loop 2
	    {
		if (temp.charAt (i) == arrLowerCase [x] || temp.charAt (i) == arrUpperCase [x])//if statement 1
		{
		    morse = morse + arrMorse [x];
		    break;
		}
	    }
	}
	return morse;
    }

    
    //morseToEng - Morse code to english translator.
    
    //while loop 1 - loops until the user enters a valid string to translate.
    //for loop 1 - loops through the user input to check whether or not all characters are translatable.
    
    //if statement 1 - throws exception if user input character is untranslatable.
    //if statement 2 - throws exception if morse code sequence did not exist and therefore could not be translated.
    
    //try block 1 - can throw IllegalArgumentException
    //catch block 1 - catches IllegalArgumentException, displays JOptionPane error message "Please enter only '.', '-', '\\', or ' '." or "You typed a morse code sequence that does not exist. Please try again."

    public void morseToEng ()
    {
	while (true)//while loop 1
	{
	    title ();
	    c.print ("Enter a string in morse code that you wish to translate into english. Use \".\" torepresent a dot, \"-\" to represent a dash, put \"\\\" between morse sequences for   individual characters (including blank spaces), and \" \" (a blank space) to      represent a space between words. For example, enter ....\\.\\.-..\\.-..\\---\\ \\-\\....\\.\\.-.\\.\\ to receive the translation \"hello there\": ");
	    temp = c.readLine ();
	    c.println ();
	    try//try block 1
	    {
		for (int i = 0 ; i < temp.length () ; i++)//for loop 1
		{
		    if (temp.charAt (i) != ' ' && temp.charAt (i) != '\\' && temp.charAt (i) != '.' && temp.charAt (i) != '-')//if statement 1
		    {
			throw new IllegalArgumentException ("Please enter only '.', '-', '\\', or ' '.");
		    }
		}
		if (returnEng (temp).equals (""))//if statement 2
		{
		    throw new IllegalArgumentException ("You typed a morse code sequence that does not exist. Please try again.");
		}
		c.println ("The translation is: " + returnEng (temp));
		c.println ();
		c.println ("Note: Morse code is not case sensitive.");
		pauseProgram ();
		break;
	    }
	    catch (IllegalArgumentException e)//catch block 1
	    {
		JOptionPane.showMessageDialog (null, e.getMessage (), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    //returnEng - returns the english translation of the user's input.

    //Local variable dictionary:
    //Name:            Type:             Purpose:
    //arrMorse         String[]          An array of all the program-translatable characters in Morse Code.
    //arrLowerCase     char[]            An array of all the lower case letters as well as numerical characters.
    //ARRLENGTH        final int         The length of the arrMorse and arrLowerCase arrays.
    //sequenceExists   boolean           Used to check whether or not the morswe sequence the user entered exists.
    //eng              String            The english translation of the user's input.

    //for loop 1 - loops through the user input looking for backslash character marking the beginning/end of a sequence
    //for loop 2 - loops through the user input looking for the next backslash character marking the other end of the morse code sequence, creating a full sequence
    //for loop 3 - loops through the arrMorse array to check which element matches the sequence produced after going through the previous two for loops to match it to the corresponding english characters.
    
    //if statement 1 - checks for backslash to start a character sequence
    //if statement 2 - checks for backslash to end a character sequence
    //if statement 3 - compares resulting character sequence with array elements and stores corresponding english character to the english translation
    //if statement 4 - if the morse code sequence could not be translated, a blank string will automatically cause the program to return to morseToEng, where it throws an exception.
    
    private String returnEng (String temp)
    {
	String[] arrLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "};
	String[] arrMorse = {"\\.-", "\\-...", "\\-.-.", "\\-..", "\\.", "\\..-.", "\\--.", "\\....", "\\..", "\\.---", "\\-.-", "\\.-..", "\\--", "\\-.", "\\---", "\\.--.", "\\--.-", "\\.-.", "\\...", "\\-", "\\..-", "\\...-", "\\.--", "\\-..-", "\\-.--", "\\--..", "\\.----", "\\..---", "\\...--", "\\....-", "\\.....", "\\-....", "\\--...", "\\---..", "\\----.", "\\-----", "\\ "};
	final int ARRLENGTH = 37;
	boolean sequenceExists = false;
	String eng = "";
	temp = "\\" + temp;
	for (int i = 0 ; i < temp.length () ; i++)//for loop 1
	{
	    sequenceExists = false;
	    if (temp.charAt (i) == '\\')//if statement 1
	    {
		for (int y = i + 1 ; y < temp.length () ; y++)//for loop 2
		{
		    if (temp.charAt (y) == '\\')//if statement 2
		    {
			for (int x = 0 ; x < ARRLENGTH ; x++)//for loop 3
			{
			    if (temp.substring (i, y).equals (arrMorse [x]))//if statement 3
			    {
				eng = eng + arrLetters [x];
				sequenceExists = true;
				break;
			    }
			}
		    }
		}
		if (sequenceExists = false)//if statement 4
		{
		    break;
		}
	    }
	}
	return eng;
    }

    //returnQuestion - returns a list of ten numbers whose randomised order determines the order of questions in quiz.

    //Local variable dictionary:
    //Name:            Type:             Purpose:
    //temporary        int               The temporary random number which may be stored into question[].
    //repeat           boolean           Used to check whether or not temporary has already occured within the existing elements of question[].
    //counter          int               Used to loop through the elements of the question[] array.

    //while loop 1 - loops until all ten spaces in the question array have been filled
    //for loop 1 - loops through existing elements in question[] to check whether or not temporary has already occured.
    
    //if statement 1 - checks to see whether or not temporary has already occured as an element in question[].
    //if statement 2 - if temporary is not a repetition, program proceeds to store temporary as the next element in question[].
    
    private int[] returnQuestion ()
    {
	int temporary;
	boolean repeat;
	int counter = 0;
	if (questionCount == 0)
	{
	    while (counter < MAXLENGTH)//while loop 1
	    {
		repeat = false;
		temporary = (int) (10 * Math.random () + 1);

		for (int i = 0 ; i <= counter ; i++)//for loop 1
		{
		    if (temporary == question [i])//if statement 1
		    {
			repeat = true;
			break;
		    }
		}
		if (repeat == false)//if statement 2
		{
		    question [counter] = temporary;
		    counter++;
		}
	    }
	}
	questionCount++;
	return question;
    }

    //quiz - displays the quiz question and asks the user for their answer.
    
    //Local variable dictionary:
    //Name:            Type:             Purpose:
    //tempPosition     int               The indice of the question that is to be displayed.
    //tempAnswer       String            The corresponding answer to the displayed question.

    //while loop 1 - loops unitl the user has entered a valid option.
    
    //if statement 1 - throws an excepion if option is less than one or greater than four
    //if statement 2 - checks to see whether the user's answer was correct, if correct, displays a message
    //else statement 2 - if the user was incorrect, displays another message
    
    //try block 1 - can throw NumberFormatException and IllegalArgumentException
    //catch block 1 - catches NumberFormatException, displays JOptionPane error message "Please enter a number."
    //catch block 2 - catches IllegalArgumentException, displays JOptionPane error message "Please enter a valid choice (1 to 4)."
    
    public void quiz ()
    {
	int tempPosition = returnQuestion () [questionCount - 1] - 1;
	String tempAnswer = answerList [tempPosition];

	title ();
	c.println (questionList [tempPosition]);
	c.print ("Enter the choice number of your answer: ");
	while (true)//while loop 1
	{
	    try//try block 1
	    {
		c.setCursor (9, 40);
		c.println ();
		c.setCursor (9, 40);
		temp = c.readLine ();
		option = Integer.parseInt (temp);
		if (option < 1 || option > 4)//if statement 1
		{
		    throw new IllegalArgumentException ("Please enter a valid choice (1 to 4).");
		}
		if (option == Integer.parseInt (tempAnswer))//if statement 2
		{
		    correctCount++;
		    temp = "You're correct.";
		}
		else//else statement 2
		{
		    temp = "You're incorrect.\nThe correct answer was: " + tempAnswer;
		}
		pauseProgram ();
		break;
	    }
	    catch (NumberFormatException e)//catch block 1
	    {
		JOptionPane.showMessageDialog (null, "Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    catch (IllegalArgumentException e)//catch block 2
	    {
		JOptionPane.showMessageDialog (null, e.getMessage (), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

    }


    //display - displays current progress after each completed quiz question, and a final score at the end. Updates highScores if user's new score is applicable.
    
    //Local variable dictionary:
    //Name:               Type:             Purpose:
    //line                String            The input line from the file highScores.txt.
    //notSwapped          boolean           Used to check whether or not any positional swapping occured between elements of playerScores[] when rearranging score order.
    //largerThan          boolean           Used to check whether or not the user's new score surpasses any existing scores.
    //tempScoreElement    String            Used to store temporarily displaced playerScore[] elements while swapping.
    //tempNameElement     String            Used to store temporarily displaced playerNames[] elemets while swapping.
    //counter             int               Used to count how many lines have been read in the file.
    //counterName         int               Used to count the number of names that have been stored from the file into the playerNames[] array.
    //counterScore        int               Used to count the number of scores that have been stored from the file into the playerScores[] array.
    //score               double            The user's newest obtained score.
    //input               BufferedReader    Reads from the highScores.txt file.
    //output              PrintWriter       Writes to the highScores.txt file.
    //tempFile            File              Used with exists to determine whether or not a high scores file (highScores.txt) already exists.
    //exists              boolean           Returns true if highScores.txt already exists, returns false if otherwise. Determines whether or not a default document needs to be created.
    
    //while loop 1 - loops until the user has entered a valid player name
    //while loop 2 - loops until all values have been stored into the playerName and playerScore arrays
    //while loop 3 - loops until all elements are in the right order (greatest to least)  
    //for loop 1 - loops until all necessary lines of text have been printed
    //for loop 2 - loops until all elements are in the right order (greatest to least)
    //for loop 3 - loops until all elements are in the right order (greatest to least), this time including the newest score (if applicable)
    //for loop 4 - loops until all updated values have been saved into the highScores.txt file
    
    //if statement 1 - if user has not completed all ten questions, then displays current progress
    //else statement 1 - if user has completed all questions, then displays final score and asks for player name, as well as updates high scores
    //if statement 2 - throws exception if user enters a player name larger than 20 characters
    //if statement 3 - if the highScores.txt file does not exist yet, then create a new default file
    //if statement 4 - if line counter is odd, then store the line to the playerNames[] array
    //else statement 4 - if line counter is even, then store the line to the playerScores[] array
    //if statement 5 - if two elements are not in order by size, then proceed to switch them
    //if statement 6 - if the player's newest obtained score is larger than any of the existing high scores, then replace that score and re-order the high scores properly.

    //try block 1 - can throw IllegalArgumentException
    //catch block 1 - catches IllegalArgumentException, displays JOptionPane error message "Please enter a player name with a length of 20 characters or under."
    //try block 2 - can throw IOException
    //catch block 2 - catches IOException
    //try block 3 - can throw IOException
    //catch block 3 - catches IOException
    
    public void display ()
    {
	String line;
	boolean notSwapped = false;
	boolean largerThan = false;
	String tempScoreElement;
	String tempNameElement;
	String tempPlayerName;
	int counter = 0;
	int counterName = 0;
	int counterScore = 0;
	double score;
	BufferedReader input;
	PrintWriter output;

	title ();
	c.println (temp);
	c.println ("Your answer was: " + option);
	c.println ();
	c.println ("You have answered " + questionCount + " question(s).");
	c.println ("Out of those, you have answered " + correctCount + " correctly.");
	score = ((double) correctCount / (double) questionCount) * 100;

	if (questionCount < 10)//if statement 1
	{
	    c.print ("Your current score is ");
	    c.print (score, 0, 2);
	    c.println ("%.");
	}
	else//else statement 1
	{
	    c.print ("Your final score is ");
	    c.print (score, 0, 2);
	    c.println ("%.");
	    c.println ();
	    c.print ("Enter your player name: ");
	    while (true)//while loop 1
	    {
		try//try block 1
		{
		    c.setCursor (11, 24);
		    c.println ();
		    c.setCursor (11, 24);
		    tempPlayerName = c.readLine ();
		    if (tempPlayerName.length () > 20)//if statement 2
		    {
			throw new IllegalArgumentException ("Please enter a player name with a length of 20 characters or under.");
		    }
		    break;
		}
		catch (IllegalArgumentException e)//catch block 1
		{
		    JOptionPane.showMessageDialog (null, e.getMessage (), "Error", JOptionPane.ERROR_MESSAGE);
		}
	    }
	    File tempFile = new File ("highScores.txt");
	    boolean exists = tempFile.exists ();
	    if (exists == false)//if statement 3
	    {
		try//try block 2
		{
		    output = new PrintWriter (new FileWriter ("highScores.txt"));
		    for (int i = 0 ; i < MAXLENGTH ; i++)//for loop 1
		    {
			output.println ("--");
			output.println ("-1");
		    }
		    output.close ();
		}
		catch (IOException e)//catch block 2
		{
		}
	    }

	    try//try block 3
	    {
		input = new BufferedReader (new FileReader ("highScores.txt"));
		line = input.readLine ();
		while (counterScore < MAXLENGTH)//while loop 2
		{
		    if (counter % 2 == 0)//if statement 4
		    {
			playerNames [counterName] = line;
			counterName++;
		    }
		    else//else statement 4
		    {
			playerScores [counterScore] = line;
			counterScore++;
		    }
		    counter++;
		    line = input.readLine ();
		}
		while (notSwapped == false)//while loop 3
		{
		    notSwapped = true;
		    for (int i = 0 ; i < MAXLENGTH - 1 ; i++)//for loop 2
		    {

			if (Double.parseDouble (playerScores [i]) < Double.parseDouble (playerScores [i + 1]))//if statement 5
			{
			    tempScoreElement = playerScores [i];
			    tempNameElement = playerNames [i];
			    playerScores [i] = playerScores [i + 1];
			    playerNames [i] = playerNames [i + 1];
			    playerScores [i + 1] = tempScoreElement;
			    playerNames [i + 1] = tempNameElement;
			    notSwapped = false;
			}
		    }
		}

		for (int i = 0 ; i < MAXLENGTH - 1 ; i++)//for loop 3
		{
		    if (Double.parseDouble (playerScores [i]) < score)//if statement 6
		    {
			tempScoreElement = playerScores [i];
			tempNameElement = playerNames [i];
			playerScores [i] = Double.toString (score);
			playerNames [i] = tempPlayerName;
			playerScores [i + 1] = tempScoreElement;
			playerNames [i + 1] = tempNameElement;
			break;
		    }
		}
		output = new PrintWriter (new FileWriter ("highScores.txt"));
		for (int i = 0 ; i < MAXLENGTH ; i++)//for loop 4
		{
		    output.println (playerNames [i]);
		    output.println (playerScores [i]);
		}
		output.close ();
	    }

	    catch (IOException e)//catch block 3
	    {
	    }
	}
	pauseProgram ();
    }


    //highScores - displays the top ten high scores.
    
    //Local variable dictionary:
    //Name:               Type:             Purpose:
    //line                String            The input line from the file highScores.txt.
    //input               BufferedReader    Reads from the highScores.txt file.
    //output              PrintWriter       Writes to the highScores.txt file.
    //tempFile            File              Used with exists to determine whether or not a high scores file (highScores.txt) already exists.
    //exists              boolean           Returns true if highScores.txt already exists, returns false if otherwise. Determines whether or not a default document needs to be created.

    //while loop 1 - loops until all values have been stored into the playerName and playerScore arrays
    //while loop 2 - loops until all elements are in the correct order (greatest to least)
    //for loop 1 - loops until all necessary lines have been printed
    //for loop 2 - loops until all elements are in the correct order (greatest to least)
    //for loop 3 - prints player names and high scores on the console
    
    //if statement 1 - if highScores.txt file does not exist yet, then create a default file.
    //if statement 2 - if line counter is odd, then save line to playerNames[]
    //else statement 2 - if line counter is even, then save line to playerScores[]
    //if statement 3 - if two array elements are not in order from greatest to least, then proceed to reorder array until arranged properly
    //if statement 4 - throws exception if there are no high scores to display
    //if statement 5 - displays "--" for no recorded score if there are high scores to display but there are less than ten scores
    
    //try block 1 - can throw IOException
    //catch block 1 - catches IOException
    //try block 2 - can throw IOException and NullPointerException
    //catch block 2 - catches IOException
    //catch block 3 - catches NullPointerException, displays JOptionPane error message "There are no high scores on record. Play through the quiz at least one time to show scores." 
    
    public void highScores ()
    {
	String line;
	BufferedReader input;
	File tempFile = new File ("highScores.txt");
	boolean exists = tempFile.exists ();
	PrintWriter output;
	if (exists == false)//if statement 1
	{
	    try//try block 1
	    {
		output = new PrintWriter (new FileWriter ("highScores.txt"));
		for (int i = 0 ; i < MAXLENGTH ; i++)//for loop 1
		{
		    output.println ("--");
		    output.println ("-1");
		}
		output.close ();
	    }
	    catch (IOException e)//catch block 1
	    {
	    }
	}
	try//try block 2
	{
	    input = new BufferedReader (new FileReader ("highScores.txt"));
	    line = input.readLine ();
	    boolean notSwapped = false;
	    String tempScoreElement;
	    String tempNameElement;
	    int counter = 0;
	    int counterName = 0;
	    int counterScore = 0;
	    while (counterScore < MAXLENGTH)//while loop 1
	    {
		if (counter % 2 == 0)//if statement 2
		{
		    playerNames [counterName] = line;
		    counterName++;
		}
		else//else statement 2
		{
		    playerScores [counterScore] = line;
		    counterScore++;
		}
		counter++;
		line = input.readLine ();
	    }
	    while (notSwapped == false)//while loop 2
	    {
		notSwapped = true;
		for (int i = 0 ; i < MAXLENGTH - 1 ; i++)//for loop 2
		{

		    if (Double.parseDouble (playerScores [i]) < Double.parseDouble (playerScores [i + 1]))//if statement 3
		    {
			tempScoreElement = playerScores [i];
			tempNameElement = playerNames [i];
			playerScores [i] = playerScores [i + 1];
			playerNames [i] = playerNames [i + 1];
			playerScores [i + 1] = tempScoreElement;
			playerNames [i + 1] = tempNameElement;
			notSwapped = false;
		    }
		}
	    }
	    title ();
	    if (Double.parseDouble (playerScores [0]) == -1)//if statement 4
	    {
		throw new NullPointerException ("There are no high scores on record. Play through the quiz at least one time to show scores.");
	    }

	    c.print ("Rank", 10);
	    c.print ("Player Name", 40);
	    c.println ("Score");

	    for (int i = 0 ; i < MAXLENGTH ; i++)//for loop 3
	    {
		c.print (Integer.toString (i + 1), 10);
		c.print (playerNames [i], 40);
		if (Double.parseDouble (playerScores [i]) == -1)//if statement 5
		{
		    c.println ("--");
		}
		else
		{
		    c.println (Double.parseDouble (playerScores [i]) + "%");
		}
	    }
	    pauseProgram ();
	}
	catch (IOException e)//catch block 2
	{
	}
	catch (NullPointerException e)//catch block 3
	{
	    JOptionPane.showMessageDialog (null, e.getMessage (), "Error", JOptionPane.ERROR_MESSAGE);
	}
    }

    
    //eraseScores - erases existing highScore data
    
    //Local variable dictionary:
    //Name:               Type:             Purpose:
    //line                String            The input line from the file highScores.txt.
    //output              PrintWriter       Writes to the highScores.txt file.

    //for loop 1 - loops until all necessary lines of text have been printed.
    
    //try block 1 - can throw IOException
    //catch block 1 - catches IOException
    
    public void eraseScores ()
    {
	String line;
	BufferedReader input;
	PrintWriter output;
	title ();
	try//try block 1
	{
	    output = new PrintWriter (new FileWriter ("highScores.txt"));
	    for (int i = 0 ; i < MAXLENGTH ; i++)//for loop 1
	    {
		output.println ("--");
		output.println ("-1");
	    }
	    output.close ();
	    c.println ("All high scores have been erased.");
	    pauseProgram ();
	}
	catch (IOException e)//catch block 1
	{
	}
    }

    //goodbye - Shows exit screen for 2.5 seconds, then exits the program.
    
    //try block 1 - can throw Exception
    //catch block 1 - catches Exception
    public void goodbye ()
    {
	title ();
	c.println ("Thank you for using the Morse code learning program.");
	c.println ("Program created by: Juleen Chen");
	try//try block 1
	{
	    Thread.sleep (2500);
	}
	catch (Exception e)//catch block 1
	{
	}
	c.close ();
    }

    //MorseCode - Class constructor
    public MorseCode ()
    {
	c = new Console ("Morse Code");
    }

    //Main Method - controls program flow
    //while loop 1 - loops quiz and display until all ten questions have been answered
    
    public static void main (String[] args)
    {
	MorseCode a = new MorseCode ();
	a.splashScreen ();
	while (true)
	{
	    a.mainMenu ();
	    if (a.choice == 1)
		a.instructions ();
	    else if (a.choice == 2)
		a.introduction ();
	    else if (a.choice == 3)
		a.engToMorse ();
	    else if (a.choice == 4)
		a.morseToEng ();
	    else if (a.choice == 5)
	    {
		while (a.questionCount < 10)//while loop 1
		{
		    a.quiz ();
		    a.display ();
		}
	    }
	    else if (a.choice == 6)
		a.highScores ();
	    else if (a.choice == 7)
		a.eraseScores ();
	    else if (a.choice == 8)
		break;
	}
	a.goodbye ();
    }
}
