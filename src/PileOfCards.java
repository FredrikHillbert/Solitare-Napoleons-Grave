import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PileOfCards {

	final public static int width = 100;
	final public static int height = 100;
	public ArrayList<Card> deck = new ArrayList<Card>(52);
	protected int y;
	protected int x;

	protected int cardValueAllowed;
	protected boolean isDraggable;
	protected boolean empty = false;
	

public PileOfCards(int[]xy) {
	
	x= xy[0];
	y = xy[1];
}

	public PileOfCards() {
	
	}
	
	public ArrayList<Card> getDeck(){
		return deck;
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void addNewCard(Card current) {
		
		 deck.add(current);
		
	}
	
	public boolean containtsDeckSpace(int x, int y) {
		 return this.x<=x && this.y<=y && x <= this.x+width && y <= this.y+height;

	    }
	
	public boolean CanCardBeAdded(int x) {
		
		return x == cardValueAllowed;
		
	}
	
	 public boolean CanBeDragged() {
		    return isDraggable;
		  }

	
	public Card dealTopCard() {
		
		return deck.get(deck.size()-1);
		}
	
	public void removeTopCard() {
		
		deck.remove(deck.size()-1);
	}
	
	public int[] getPosition() {
		
		int[] pos = {x, y};
		return pos;
	}
	
	public void paintComponent(Graphics g) {
		if(deck.size() == 0) {
			g.setColor(Color.blue.darker());
			g.fillRect(x, y, width, height);
			
		} else {
			for(Card currentCard : deck) {
				currentCard.paintComponent(g);
			}
		}
	}
	
	public boolean allowedToDragCards(int x, int y, PileOfCards d) {
		return d.containtsDeckSpace(x, y) && d.CanBeDragged();
		
	}
	
	public void alterPile(PileOfCards lastDeck,PileOfCards currentDeck, int decknumber) {
		Card c = lastDeck.dealTopCard();
		currentDeck.addNewCard(c);
		 lastDeck.removeTopCard();
		    c.flip();
		    c.setPosition(currentDeck.getPosition());
		    c.setPile(decknumber);
		    c = null;}
	public void alterDeckValue() {}
	

	
	
	
	
	
	
	
	
	
	
}
