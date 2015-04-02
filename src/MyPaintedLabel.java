/**
 * 
 */

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

/**
 * @author mhelia01
 *
 */
public class MyPaintedLabel extends JLabel {
	
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 7351178603927221362L;
	
	private Point origin;
	private Point end;
	private Color couleur;
	private String typeForme;
	private boolean rempli;
	private int contEpaisseur;

    //Constructeur par default
	public MyPaintedLabel(){
        //Rendre Opaque
        this.setOpaque(true);        
	}
	
	//Constructeur avec parametre
	public MyPaintedLabel(Point origin, Point end, Color laCouleur, String typeForme, boolean rempli, int contEpaisseur){
        //Rendre Opaque
        this.setOpaque(true);
        
        this.origin = origin;
        this.end = end;
        this.couleur = laCouleur;
        this.typeForme = typeForme;
        this.rempli = rempli;
        this.contEpaisseur = contEpaisseur;
	}
	
	//************ GETTERs & SETTERs ************//
	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getTypeForme() {
		return typeForme;
	}

	public void setTypeForme(String typeForme) {
		this.typeForme = typeForme;
	}

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean rempli) {
		this.rempli = rempli;
	}

	public int getContEpaisseur() {
		return contEpaisseur;
	}

	public void setContEpaisseur(int contEpaisseur) {
		this.contEpaisseur = contEpaisseur;
	}

}
