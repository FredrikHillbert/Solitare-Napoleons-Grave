import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

public class Card {

protected int xPos = 0;
protected int yPos = 0;
protected int thePile;
protected boolean faceUp;
protected String faceName;
protected int rank;
protected int suit;
protected Image image;
Point cardPoint;
	ImageIcon backSideOfCard;
	
	ImageIcon theImageCard;
	
	private String theFaceName;
	
	public Card(String faceName) {
		setFaceName(faceName);
		faceUp = false;
		backSideOfCard = new ImageIcon("./Images/b1fv.gif");
		theImageCard = new ImageIcon(setFaceName(faceName)); 
		rank = CalculateCardRank();
		suit = GetCardSuit();
		
	}

	public int getRank() {
		
		return rank;
	}
	

	public String setFaceName(String newFaceName) {
		List<String> vaildFaceNames = getValidFaceNames();
		
		if(vaildFaceNames.contains(newFaceName)) {
			theFaceName = newFaceName;
			return newFaceName;
		}
		else {return null; }
	}

	public static List<String> getValidFaceNames(){ 
		return Arrays.asList(	"./Images/h1.gif", "./Images/h2.gif", "./Images/h3.gif", "./Images/h4.gif", "./Images/h5.gif", "./Images/h6.gif", "./Images/h7.gif", "./Images/h8.gif", "./Images/h9.gif", "./Images/ht.gif", "./Images/hj.gif", "./Images/hq.gif", "./Images/hk.gif",
								"./Images/c1.gif", "./Images/c2.gif", "./Images/c3.gif", "./Images/c4.gif", "./Images/c5.gif", "./Images/c6.gif", "./Images/c7.gif", "./Images/c8.gif", "./Images/c9.gif" , "./Images/ct.gif", "./Images/cj.gif", "./Images/cq.gif", "./Images/ck.gif",
								"./Images/d1.gif", "./Images/d2.gif", "./Images/d3.gif", "./Images/d4.gif", "./Images/d5.gif", "./Images/d6.gif", "./Images/d7.gif", "./Images/d8.gif", "./Images/d9.gif", "./Images/dt.gif", "./Images/dj.gif", "./Images/dq.gif", "./Images/dk.gif",
								"./Images/s1.gif", "./Images/s2.gif", "./Images/s3.gif", "./Images/s4.gif", "./Images/s5.gif", "./Images/s6.gif", "./Images/s7.gif", "./Images/s8.gif", "./Images/s9.gif", "./Images/st.gif", "./Images/sj.gif", "./Images/sq.gif", "./Images/sk.gif");
	}
	public void setPosition(int currentPos[]) {
		
		this.xPos = currentPos[0];
		this.yPos= currentPos[1];
		cardPoint = new Point(xPos,yPos);
	}
	
	public String getPosition() {
		
		return String.valueOf(xPos) + " " + String.valueOf(yPos);
	}
	
	
	public int getPile() {
	    return thePile;
	  }

	  public void setPile(int p) {
	    thePile = p;
	  }
	
	

	//Ser ifall det är ett öppet kort
	public boolean isFaceUp() {
		return faceUp;
	}

	
	public void flip() { faceUp = !faceUp; }
	
	protected void paintComponent(Graphics g) {
		if(isFaceUp()) {
			
		g.drawImage(theImageCard.getImage(), (int)cardPoint.getX(), (int)cardPoint.getY(), theImageCard.getIconWidth(),theImageCard.getIconHeight(), null, theImageCard.getImageObserver());
		
		}
		else 
		{
			g.drawImage(backSideOfCard.getImage(), xPos, yPos, backSideOfCard.getIconWidth(),backSideOfCard.getIconHeight(), null, backSideOfCard.getImageObserver());
		}
		
	}

	public void MoveCard(Point currentPos, Point prevPos) {
		
		cardPoint.translate(
				
				(int)(currentPos.getX() - prevPos.getX()),
				(int)(currentPos.getY() - prevPos.getY())
				);
		
	}

	private int CalculateCardRank() {
		int number = 0;
		
		var theNumber = theFaceName.charAt(10);
		switch(theNumber) {
		
		case 'k': number = 13;
		break;
		case 'q': number = 12;
		break;
		case 'j': number = 11;
		break;
		case 't': number = 10;
		break;
		default: number = theNumber - '0';
		break;
		}
		
		
		return number;
	}
	private char GetCardSuit() {
		var theSuit = theFaceName.charAt(9);
		return theSuit;
	}

	
	
}
