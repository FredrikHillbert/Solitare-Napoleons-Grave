import java.awt.Color;
import java.awt.Graphics;

public class TheSevenPile extends PileOfCards {
	
		public TheSevenPile(int[]xy) {
			super(xy);
			cardValueAllowed = 7;
			isDraggable = false;
		}
		
		@Override
		public void alterDeckValue() {
			cardValueAllowed ++;
		}
		@Override
		public void paintComponent(Graphics g) {
			if(deck.size() == 0) {
				g.setColor(Color.MAGENTA.darker());
				g.fillRect(x, y, width, height);
				
			} else {
				for(Card currentCard : deck) {
					currentCard.paintComponent(g);
				}
			}
		}

}
