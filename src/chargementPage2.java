import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author David
 *
 */
public class chargementPage2 implements ActionListener{
		
		private Menu m;
	
		public chargementPage2(Menu m){
			this.setM(m);
		}
	
		public void actionPerformed (ActionEvent event)
	    {		
			MyPaintedPanel.setTypeForme(m.getComboBox_1());
			MyPaintedPanel.setRempli(false);
			Fenetre2 frame2= new Fenetre2();
			frame2.setTitle("Dessin sur ordinateur");
			frame2.setVisible(true);
		}

		//************ GETTERs & SETTERs ************//
		public Menu getM() {
			return m;
		}

		public void setM(Menu m) {
			this.m = m;
		}
};
		
	

