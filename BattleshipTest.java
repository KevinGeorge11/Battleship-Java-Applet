//Kevin George
//ICS 4U1   
//Java Get_Data_From_File - Battleship
//Feb 20,2015

import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class BattleshipTest extends Applet
{

    //Declare arrays to store data and pictures
    int[] [] inputData = new int [10] [10];
    Image pic[] = new Image [2];

    public void init ()
    {
	pic [0] = getImage (getCodeBase (), "water.png");
	pic [1] = getImage (getCodeBase (), "battleship.png");
	setLayout (null);
	
	//Get Data
	BufferedReader filein;
	try
	{
	    filein = new BufferedReader (new FileReader ("GridDATA.txt"));

	    for (int i = 0 ; i < 10 ; i++)
	    {
		String inputLine = filein.readLine () + " ";
		StringTokenizer st = new StringTokenizer (inputLine, " ");

		for (int j = 0 ; j < 10 ; j++)
		{
		    String eachNumber = st.nextToken ();
		    try
		    {
			inputData [j] [i] = Integer.parseInt (eachNumber);
		    }
		    catch (Exception e)
		    {
		    }

		}

	    }

	}
	//If error occurs then
	catch (IOException ioe)
	{
	    System.out.println ("Could not load file");
	}

    }


    public void paint (Graphics g)
    {
	//Draw graphics
	for (int i = 0 ; i < 10 ; i++)
	{
	    for (int j = 0 ; j < 10 ; j++)
	    {
		g.drawImage (pic [inputData [i] [j]], i * 50, j * 50, 50, 50, this);
	    }
	}
    }
}
