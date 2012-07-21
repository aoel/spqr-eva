/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.*;

public class JavaApplication6 {
    
	public static void main(String[] args) {
        JavaApplication6 rfbibl = new JavaApplication6();
        
		System.out.println("************ Beleglauf V001 startet ***************");
		
		rfbibl.belege();
		
        System.out.println("************ Beleglauf beendet ********************");
	}
	
	public void belege() {
        short anzFB01 = 0;
        short anzZBSEG1 = 0;
        short anzZBSEG2 = 0;
        short anzBBTAX = 0;
		
		try {
			
			File f = new File(".", "beleg.dat");
			
			BufferedReader in = new BufferedReader(new FileReader(f));
			String FB01 =  "1FB01";
			String ZBSEG = "2ZBSEG";
			String BBTAX = "2BBTAX";
			boolean bSatz1 = true;
			
			String zeile = null;
		    while ((zeile = in.readLine()) != null) {
			   //System.out.println("Gelesene Zeile: " + zeile);
			   if (FB01.equals(zeile.substring(0,FB01.length()))) { 
				   ++anzFB01;
				   displayFB01(zeile);
			   }
			   
			   if (ZBSEG.equals(zeile.substring(0,ZBSEG.length())) && bSatz1) { 
				   displayZBSEG1(zeile);
				   bSatz1 = false;
				   ++anzZBSEG1;
			   } else {

			     if (ZBSEG.equals(zeile.substring(0,ZBSEG.length())) && !bSatz1) { 
				     displayZBSEG2(zeile);
				     bSatz1 = true;
				     ++anzZBSEG2;
			     }
			   }
			   
			   if (BBTAX.equals(zeile.substring(0,BBTAX.length()))) { 
				   displayBBTAX(zeile);
				   ++anzBBTAX;
			   }

			   //System.out.println("\n\n\n");
		    }
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
		System.out.println("\n");	
		System.out.println("Statistik:");	
		System.out.println("    Anzahl Kopfsätze = " + anzFB01);	
		System.out.println("    Anzahl Positionen, Haben = " + anzZBSEG1);	
		System.out.println("    Anzahl Postitionen, Soll = " + anzZBSEG2);	
		System.out.println("    Anzahl Steuersätze = " + anzBBTAX);	
	}
	
	void displayFB01(String zeile) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Kopfsatz:");
		System.out.println("    BLDAT, Rechnungsdatum = "+zeile.substring(21,29));
		System.out.println("    BLART, Belegart = "+zeile.substring(29,31));
		System.out.println("    BUKRS, Buchungskreis = "+zeile.substring(31,35));
		System.out.println("    BUDAT, Buchungsdatum = "+zeile.substring(35,43));
		System.out.println("    WAERS, Belegwährung = "+zeile.substring(45,50));
		System.out.println("    WWERT, Datum = "+zeile.substring(70,78));
		System.out.println("    XBLNR, Rechnungsnummer = "+zeile.substring(78,94));
		System.out.println("    XMWST, Rechnungsnummer = "+zeile.substring(153,154));

	}

	void displayZBSEG1(String zeile) {
		System.out.println("Pos1:");
		System.out.println("    Buchungsschlüssel = "+zeile.substring(31,33));
		System.out.println("    Rechnungsbetrag = "+zeile.substring(41,49));
		System.out.println("    UmSt-Kz = "+zeile.substring(49,51));
		System.out.println("    Geschäftsbereich = "+zeile.substring(52,55));
		System.out.println("    Zuordnungsnummer = "+zeile.substring(85,91));
		System.out.println("    Positionstext = "+zeile.substring(102,125));
		System.out.println("    Zahlungsbedingungsschlüssel = "+zeile.substring(152,157));
		System.out.println("    Fibunr = "+zeile.substring(181,188));
		System.out.println("    Skonto, Tage 1 = "+zeile.substring(235,237));
		System.out.println("    Skonto, Prozent 1 = "+zeile.substring(239,244));
		System.out.println("    Skonto, Tage 2 = "+zeile.substring(244,248));
		System.out.println("    Skonto, Prozent 2 = "+zeile.substring(248,253));
		System.out.println("    Frist für Nettokondition = "+zeile.substring(253,255));
	}
	
	void displayZBSEG2(String zeile) {
		System.out.println("Pos2:");
		System.out.println("    Buchungsschlüssel = "+zeile.substring(31,33));
		System.out.println("    Rechnungsbetrag = "+zeile.substring(41,49));
		System.out.println("    UmSt-Kz = "+zeile.substring(49,51));
		System.out.println("    Geschäftsbereich = "+zeile.substring(52,55));
		System.out.println("    Kostenstelle = "+zeile.substring(55,65));
		System.out.println("    Auftragsnummer = "+zeile.substring(66,77));
		System.out.println("    Rechnungsnummer = "+zeile.substring(79,92));
		System.out.println("    Positionstext = "+zeile.substring(92,116));
		System.out.println("    Erlöskonto = "+zeile.substring(174,187));
	}

	void displayBBTAX(String zeile) {
		System.out.println("BBTAX:");
		System.out.println("    Steuerbetrag = "+zeile.substring(37,47));
		System.out.println("    UmSt-Kz = "+zeile.substring(47,49));
		System.out.println("    Buchungsschlüssel = "+zeile.substring(49,51));
	}

}
