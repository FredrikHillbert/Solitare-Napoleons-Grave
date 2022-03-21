import java.awt.Graphics;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;
public class GameSpace extends JPanel{

	private static int[][] pilePlacement= {
			 	{200, 20},  {350, 20},  {500, 20},
			    {200, 200}, {350, 200}, {500, 200},
			    {200, 400}, {350, 400}, {500, 400},
			    {10, 10}, {10, 500}, {600, 500}
			  };
	private final PileOfCards[] theDeck = {new TheSevenPile(pilePlacement [0]), new GroundPile(pilePlacement [1]), new TheSevenPile(pilePlacement [2]),
		    new GroundPile(pilePlacement [3]), new TheSixPile(pilePlacement [4]), new GroundPile(pilePlacement [5]),
		    new TheSevenPile(pilePlacement [6]), new GroundPile(pilePlacement [7]), new TheSevenPile(pilePlacement [8]),
		    new faceDownPile(pilePlacement [9]), new DiscardPile(pilePlacement [10]), new SavePile(pilePlacement [11])};
	
	
	
	private boolean isCardSelected = false;
	Point prevPosForCard;
	private Card card;
	private int prevPileInt;
		
	
	public GameSpace() {
		ClickListener clickListener =new ClickListener();
		DragListener dragListener = new DragListener();
		addMouseListener(clickListener);
		addMouseMotionListener(dragListener);
		theDeck[9].shuffle();
		placeStartingCards();
	}

	
	private void placeStartingCards() {
		for( int i = 1; i < 8; i+=2){
			theDeck[9].alterPile(theDeck[9], theDeck[i], i);
			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < 12; i++) {
			theDeck[i].paintComponent(g);
		}
		if(card != null) {card.paintComponent(g);}
	}
	
	
	private class ClickListener extends MouseAdapter{
		
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
				
				if(theDeck[9].containtsDeckSpace(x, y) && theDeck[9].getDeck().size()>0) {
					theDeck[9].alterPile(theDeck[9], theDeck[10], 10);
			
					
				}
				else {
				for(PileOfCards deck : theDeck) {
					
					if(deck.allowedToDragCards(x, y, deck) && deck.getDeck().size() > 0) {
						card = deck.dealTopCard();
						isCardSelected = true;
						prevPosForCard = e.getPoint();
						break;
					}
					else {isCardSelected = false;}
				}
			}
				revalidate();
				repaint();
		}
		public void mouseReleased(MouseEvent e) {
			
			int x = e.getX();
			int y = e.getY();
			if(card != null) {
				addingCardToNewDeck(x, y);
				card = null;
			}
			repaint();
		}
			
	}

	
	private class DragListener extends MouseMotionAdapter{
		
		public void mouseDragged(MouseEvent e) {
			if(isCardSelected) {
				Point currentPosForCard = e.getPoint();
				if(card != null) 
				{
					card.MoveCard(currentPosForCard, prevPosForCard);
					prevPosForCard = currentPosForCard;
					
				}
			}
			revalidate();
			repaint();
		}
		
	}
	
	private void addingCardToNewDeck(int x, int y) {
		
		for(int i = 0; i<12; i++) {
			if(theDeck[i].containtsDeckSpace(x, y) && theDeck[i].CanCardBeAdded(card.getRank())) {
				theDeck[i].addNewCard(card);
				card.setPosition(theDeck[i].getPosition());
				prevPileInt = card.getPile();
				card.setPile(i);
				theDeck[prevPileInt].removeTopCard();
				theDeck[i].alterDeckValue();
			}
		}
	card.setPosition(theDeck[card.getPile()].getPosition());
	}
	
	private void alterPile(PileOfCards lastDeck, PileOfCards currentDeck, int decknumber) {
		card = lastDeck.dealTopCard();
		currentDeck.addNewCard(card);
		lastDeck.removeTopCard();
		card.flip();
		card.setPosition(currentDeck.getPosition());
		card.setPile(decknumber);
		card = null;
	}

}

