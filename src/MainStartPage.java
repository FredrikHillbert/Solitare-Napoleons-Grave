import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainStartPage extends JFrame implements ActionListener {

	
	
	JButton reset;
	JPanel buttonPanel;
	JPanel s;
	Button restartButton;
		public MainStartPage() {
			init();
		}
		
			
			
		public void init() {
			restartButton = new Button("New Game");
			restartButton.addActionListener(this);
			add("South", restartButton);
			s = new GameSpace();
			add(s);
			setVisible(true);
			setSize(700,700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			}
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == restartButton) {
			        getContentPane().removeAll();
			        repaint();
			    }
			
		}
		
		
		public void repaint() {
			init();
			
		}
		
		public static void main(String[] args) {
			  new MainStartPage();
		}
}
