import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author mhelia01
 * Class Panel
 */
public class MyPaintedPanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3761824826353393995L;
	
	
	private Point origin;
	private Point end;
	private Color couleur;
	private static String typeForme;
	private static boolean rempli;
	private static int contEpaisseur;

	public ArrayList<MyPaintedLabel> mesFormes = new ArrayList<MyPaintedLabel>();
	
	//Constructeur par fefault
	public MyPaintedPanel(){
		this.setOpaque(true);
	}
	
	//Constructeur avec BorderLayout
	public MyPaintedPanel(BorderLayout borderLayout) {
		// TODO Stub du constructeur généré automatiquement
		this.setOpaque(true);
		this.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		this.setBackground(Color.WHITE);	//Couleur de fond en blanc
		this.setForeground(Color.BLACK);
		this.setBounds(10, 46, 356, 462);
		this.setLayout(null);
		
		//Ecoute de la souris sur le panel
	    MouseAdapter adapter = new Listener();
	    addMouseMotionListener(adapter);
	    addMouseListener(adapter);
	}
	
	//---------------------------------------------------
	//--------------- Class ecoute souris ---------------
	//---------------------------------------------------
    class Listener extends MouseAdapter {

    	@Override
	    public void mousePressed(MouseEvent e) {
	    	super.mousePressed(e);
	    	
	    	origin = e.getPoint();
	    }
	    
    	@Override
	    public void mouseDragged(MouseEvent e) {
	    	super.mouseDragged(e);
	    	
	        end = e.getPoint();
	        repaint();	
	    }
	    
    	@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Stub de la méthode généré automatiquement	
			super.mouseReleased(e);
			
	        end = e.getPoint();
	        
	        if(origin != end){
		        if(couleur != null)
		        	mesFormes.add(new MyPaintedLabel(origin, end, couleur, typeForme, rempli, contEpaisseur));
		        else
		        	mesFormes.add(new MyPaintedLabel(origin, end, Color.RED, typeForme, rempli, contEpaisseur));
		        
		        repaint();
	        }
		}
    	
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		// TODO Stub de la méthode généré automatiquement
    		super.mouseReleased(e);
    		
        	for (int i = 0; i < mesFormes.size(); i++) {
    			MyPaintedLabel label = mesFormes.get(i);
    			System.out.println(label.getGraphics());
        	}
    	}
    }
    //---------------------------------------------------
    //--------------- Fin de la classe ecoute -----------
    
    //---------------- Parti du dessin ------------------
    public void drawn(Graphics arg0, Point debut, Point fin, Color laCouleur, String typeForme, boolean rempli, int contEpaisseur){ 
    	if(laCouleur != null)
    		arg0.setColor(laCouleur);
    	else
    		arg0.setColor(Color.RED);
	    
	    if(debut != null) {
		   	 
	        int tmp;
	 
	        int x1 = (int)(debut.getX());
	        int y1 = (int)(debut.getY());
	        int x2 = (int)(fin.getX());
	        int y2 = (int)(fin.getY());
	 
	        if(x1 > x2) { tmp = x1; x1 = x2; x2 = tmp; }
	        if(y1 > y2) { tmp = y1; y1 = y2; y2 = tmp; }
	 
	        if(typeForme == "ellipse"){
	        	if(rempli == false){
	        		Graphics2D g2 = (Graphics2D) arg0;
	        		
	        		Ellipse2D shape1 = new Ellipse2D.Float(x1, y1, x2-x1, y2-y1);
	        	      
	        		Stroke s = new BasicStroke(contEpaisseur+.0f,      // Width
	                           BasicStroke.CAP_SQUARE,    // End cap
	                           BasicStroke.JOIN_MITER,    // Join style
	                           10.0f,                     // Miter limit
	                           null, 					// Dash pattern    new float[] {16.0f,20.0f}
	                           0.0f);                     // Dash phase
	        		
	        	    g2.setStroke(s);
	        	    g2.draw(shape1);
	        	}
	        	else
	        		arg0.fillOval(x1, y1, x2-x1, y2-y1);
	        }
	        else{
	        	if(rempli == false){
	        		Graphics2D g2 = (Graphics2D) arg0;
	        		
	        	    Rectangle2D shape1 = new Rectangle2D.Float();
	        	    shape1.setFrame(x1, y1, x2-x1, y2-y1);
	        	      
	        		Stroke s = new BasicStroke(contEpaisseur+.0f,      // Width
	                           BasicStroke.CAP_SQUARE,    // End cap
	                           BasicStroke.JOIN_MITER,    // Join style
	                           10.0f,                     // Miter limit
	                           null, 					// Dash pattern		new float[] {16.0f,20.0f}
	                           0.0f);                     // Dash phase
	        		
	        	    g2.setStroke(s);
	        	    g2.draw(shape1);
	        	}
	        	else
	        		arg0.fillRect(x1, y1, x2-x1, y2-y1);
	        }
	    }
    	
    }
    
    public void paintComponent(Graphics arg0) {
    	// TODO Stub de la méthode généré automatiquement
    	super.paintComponent(arg0);
    	
    	//Formes enregistrer dans la liste (Objet : MyPaintedLabel)
    	for (int i = 0; i < mesFormes.size(); i++) {
			MyPaintedLabel label = mesFormes.get(i);
			drawn(arg0, label.getOrigin(), label.getEnd(), label.getCouleur(), label.getTypeForme(), label.isRempli(), label.getContEpaisseur());
			setLayout(new BorderLayout());
			add(label);
		}	
    	
    	//Affichage de la forme en cours
    	drawn(arg0, origin, end, couleur, typeForme, rempli, contEpaisseur);
    }
    
    
    //************ GETTERs & SETTERs ************//
    public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getTypeForme() {
		return typeForme;
	}

	public static void setTypeForme(String typeForme) {
		MyPaintedPanel.typeForme = typeForme;
	}

	public boolean isRempli() {
		return rempli;
	}

	public static void setRempli(boolean rempli) {
		MyPaintedPanel.rempli = rempli;
	}

	public static int getContEpaisseur() {
		return contEpaisseur;
	}

	public static void setContEpaisseur(int contEpaisseur) {
		MyPaintedPanel.contEpaisseur = contEpaisseur;
	}
}
