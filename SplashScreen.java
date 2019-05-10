//Juleen Chen
//ICS 3UF, Ms. Krasteva
//15/01/2018
//SplashScreen - draws a "MORSE CODE" animation used in the MorseCode class
//               Note: The morse code characters located on the letters are the morse translation of the letters they are placed upon.

import java.awt.*;
import hsa.Console;
import java.lang.*; 

public class SplashScreen extends Thread
{
    private Console c;

    //draw - draws the "MORSE CODE" animation
    
    //Local variable dictionary:
    //Name:          Type:             Purpose:
    //letters        Color             The colour of the letters
    //morse          Color             The colour of the morse code characters
    //background     Color             The background colour
    
    //try block 1 - can throw Exception
    //catch block 1 - catches Exception
    public void draw ()
    {

	Color letters = new Color (150, 250, 150);
	Color morse = new Color (150, 150, 150);
	Color background = new Color (0, 50, 0);
	c.setTextBackgroundColour (background);
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);
	//loop used for animate the draw
	for (int x = 0 ; x < 550 ; x++)
	{
	    c.setFont (new Font ("SansSerif", Font.BOLD, 150));
	    c.setColour (background);
	    c.fillRect (-499 + x, 91, 541, 110);
	    c.fillRect (-499 + x, 309, 474, 93);

	    c.setColor (letters);
	    c.drawString ("MORSE", -500 + x, 200);

	    c.setColor (morse);
	    c.fillRect (-488 + x, 94, 15, 103);
	    c.fillRect (-403 + x, 94, 15, 103);

	    c.fillRect (-363 + x, 119, 15, 53);
	    c.fillRect (-285 + x, 119, 15, 53);
	    c.fillRect (-338 + x, 183, 43, 15);

	    c.fillRect (-230 + x, 139, 43, 15);
	    c.fillOval (-247 + x, 179, 20, 20);
	    c.fillOval (-180 + x, 179, 20, 20);

	    c.fillOval (-110 + x, 183, 18, 18);
	    c.fillOval (-110 + x, 133, 18, 18);
	    c.fillOval (-110 + x, 91, 18, 18);

	    c.fillOval (-39 + x, 133, 20, 20);

	    c.setFont (new Font ("Courier", Font.BOLD, 150));
	    c.setColor (letters);
	    c.drawString ("CODE", -410 + x, 400);
	    try//try block 1
	    {
		Thread.sleep (20);
	    }
	    catch (Exception e)//catch block 1
	    {
	    }
	}
    }

    //Class constructor
    public SplashScreen (Console con)
    {
	c = con;
    }


    //run - runs the draw method animation
    public void run ()
    {
	draw ();
    }
}
