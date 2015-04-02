import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author David
 *
 */
public class chargementPage1 implements ActionListener{
			
		
		private Menu m;
		
		public chargementPage1(Menu m){
			this.setM(m);
		}
	
		public void actionPerformed (ActionEvent event)
	    {				
			MyPaintedPanel.setTypeForme(m.getComboBox());
			MyPaintedPanel.setRempli(m.getChckbxRemplie());
			Fenetre1 frame1= new Fenetre1();
			frame1.setTitle("Dessin sur ordinateur");
			frame1.setVisible(true);		
		}

		//************ GETTERs & SETTERs ************//
		public Menu getM() {
			return m;
		}

		public void setM(Menu m) {
			this.m = m;
		}
		
};
		
	

