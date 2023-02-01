import java.net.*;
import java.util.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class BrailleAlfaBeto
	{
	Vector <Braille>  string; // lista di braille
	Scanner input;
	int copyBraille[][];
	BrailleAlfaBeto()
		{
		copyBraille = new int [3][2];
		reset(copyBraille);
		string = new Vector<Braille>();
		//boolean wordFinished = false;
		try
			{
			input = new Scanner(new FileInputStream(openFile()));
			//input.useDelimiter(",");
			//System.out.println("Letto Il file, lo analizzo");
			while(input.hasNextLine())
				pushBrailleInString(input.hasNextInt()); // controllo se il taken dello scanner è un intero, se lo è carico il braille, altrimenti carico il braille nullo
			System.out.println(toString());
			}
		  catch (FileNotFoundException fNFE1)
			{
			System.out.println("file non trovato");
			}
		
		}
	void pushBrailleInString(boolean isBraille)
		{
		reset(copyBraille);
		if(isBraille) // se è un braille lo carico in braille word, altrimenti mi va bene il braille vuoto che corrisponde ad uno spazio
			{
			//System.out.println("braille trovato");
			for(int i=0;i<3;i++)
					{
					//System.out.print("\n");
					for(int j=0; j<2; j++)
						{
						copyBraille[i][j]=input.nextInt();
						//System.out.print(copyBraille[i][j]);
						}
					}
			}
		 else	
			input.next(); //se non lo è mando il taken avanti per cercare altri braille
		string.add(new Braille(copyBraille)); //carico a prescindere se è braille o meno il braille, se lo è carico lui altrimenti carico braille vuoto
		}
		
	void reset(int braille[][])
		{
		for(int i=0;i<3;i++)
			{
			for(int j=0; j<2; j++)
				{
				braille[i][j]=0;
				//System.out.print(braille[i][j]);
				}
			}
		}
		
	public String toString()
		{
		String s="IL MESSAGGIO CONTIENE:\n";
		// for(int i=0; i<string.size();i++)
			// {
			// s+=(string.elementAt(i).toString1()+"\n-");
			// }
		for(int i=0; i<string.size();i++)
			{
			s+=(string.elementAt(i).carAlfabetico);
			}
		return s;
		}
		
	// void stampaCarattere(int braille[][]) //stampa un singolo carattere
		// {
		
		// }
		
	File openFile() 
     {
	 File fa= null;
     JFileChooser fc = new JFileChooser();
	 FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Braille & TXT Files", "labs", "txt");
	 fc.setFileFilter(filter);
     int returnVal = fc.showOpenDialog(null);
     if(returnVal == JFileChooser.APPROVE_OPTION)
       {
       // try
         // {
		 System.out.println("hai aperto "+ fc.getName(fc.getSelectedFile()));
		 fa = fc.getSelectedFile();
         // }
       // catch(FileNotFoundException fNFE2)
         // {
         // System.out.println("file non trovato"); 
         // } 
       }
	 return fa;
     }
	 
	class Braille
		{
		int brailleWord [][];
		char carAlfabetico;
		Braille(int mat[][])
			{
			carAlfabetico= ' ';
			brailleWord= new int[3][2];
			for(int i=0;i<3;i++)
				{
				for(int j=0; j<2; j++)
					{
					brailleWord[i][j]=mat[i][j];
					//System.out.print(braille[i][j]);
					}
				}
			setCharAlpha(); //stabilisco il carattere alfabetico associato al braille
			}
		void setCharAlpha()
			{
			if(	brailleWord[0][0]==0 && brailleWord[0][1]==0 && 
				brailleWord[1][0]==0 &&	brailleWord[1][1]==0 &&
				brailleWord[2][0]==0 && brailleWord[2][1]==0 	 )
				{
				carAlfabetico=' ';
				}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='a';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='b';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='c';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='d';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='e';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='f';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='g';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='h';
					}
			else if(brailleWord[0][0]==0 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='i';
					}
			else if(brailleWord[0][0]==0 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==0	)
					{
					carAlfabetico='j';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='k';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='l';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='m';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='n';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='o';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='p';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='q';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='r';
					}
			else if(brailleWord[0][0]==0 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='s';
					}
			else if(brailleWord[0][0]==0 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==0	)
					{
					carAlfabetico='t';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==1	)
					{
					carAlfabetico='u';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==1	)
					{
					carAlfabetico='v';
					}
			else if(brailleWord[0][0]==0 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==1 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==0 && brailleWord[2][1]==1	)
					{
					carAlfabetico='w';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==0 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==1	)
					{
					carAlfabetico='x';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==1 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==1	)
					{
					carAlfabetico='y';
					}
			else if(brailleWord[0][0]==1 && brailleWord[0][1]==0 && 
					brailleWord[1][0]==0 &&	brailleWord[1][1]==1 &&
					brailleWord[2][0]==1 && brailleWord[2][1]==1	)
					{
					carAlfabetico='z';
					}
			}
		// void reset()
			// {
			// for(int i=0;i<3;i++)
				// {
				// for(int j=0; j<2; j++)
					// {
					// brailleWord [i][j]=0;
					//System.out.print(braille[i][j]);
					// }
				// }
			// }
		
		String toString1() // ritorna
			{
			String s="";
			for(int i=0;i<3;i++)
				{
				s+= "\n";
				for(int j=0; j<2; j++)
					s+=brailleWord[i][j];
				}
			return s;
			}
		}
	
	public static void main(String[] args)
		{
		BrailleAlfaBeto world = new BrailleAlfaBeto();
		}
		
	}