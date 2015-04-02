import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JMenu;

public class Fenetre1 extends JFrame {

	/**
	 * @author David
	 */
	// Declarations des variables
	private static final long serialVersionUID = -788267919462268937L;
	private JPanel contentPane;
	public Point origin;
    public Point end;
	public ArrayList<MyPaintedLabel> mesFormes = new ArrayList<MyPaintedLabel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre1 frame1 = new Fenetre1();
					// Titre de la Fenêtre
					frame1.setTitle("Dessin sur ordinateur");
					frame1.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

	/**
	 * Create the frame.
	 */
	public Fenetre1() {
		// Ne peut pas être redimensionné
		this.setResizable(false);
		// Parametrage de la Jframe
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 574);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final MyPaintedPanel dessin = new MyPaintedPanel(new BorderLayout());
		this.contentPane.add(dessin);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(385, 46, 309, 141);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(386, 214, 309, 294);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mode ASCII");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(96, 35, 119, 22);
		panel_2.add(lblNewLabel);
		
		JLabel lblerCaractre = new JLabel("1er caract\u00E8re :");
		lblerCaractre.setBounds(38, 112, 104, 14);
		panel_2.add(lblerCaractre);
		
		JLabel lblemeCaractre = new JLabel("2eme caract\u00E8re :");
		lblemeCaractre.setBounds(38, 166, 104, 14);
		panel_2.add(lblemeCaractre);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"*", "-", "+", "=", "$", "^", "\u00A3", "\u00A8", "!", "\u00A7", ":", "/", ".", ";", ",", "?", "#", "\"", "~", "&", "@", "\u00B0"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(152, 109, 92, 20);
		panel_2.add(comboBox);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"=", "-", "+", "*", "$", "^", "\u00A3", "\u00A8", "!", "\u00A7", ":", "/", ".", ";", ",", "?", "#", "\"", "~", "&", "@", "\u00B0"}));
		comboBox_1.setBounds(152, 163, 92, 20);
		panel_2.add(comboBox_1);
		
		JButton btnPasserEnMode = new JButton("Passer en mode ASCII");
		btnPasserEnMode.setBounds(38, 215, 231, 23);
		panel_2.add(btnPasserEnMode);
		
		JButton btnRetourEnMode = new JButton("Retour en mode couleur");
		btnRetourEnMode.setBounds(38, 249, 231, 23);
		panel_2.add(btnRetourEnMode);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 715, 25);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu\r\n");
		menuBar.add(mnMenu);
		
		mnMenu.add("Ouvrir");
		mnMenu.add("Sauvegarder");
		mnMenu.add("Quitter");
		
		//Créer le bouton
        final javax.swing.JButton button = new JButton();
        button.setBounds(85, 55, 151, 23);
        button.setText("Choisir une couleur");
                
        //Ajouter un evenement sur le click de la souris
        MouseAdapter actionListener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Color background = JColorChooser.showDialog(null,
                        "JColorChooser Sample", null);
                if (background != null) {
                	panel_1.setBackground(background);
                	dessin.setCouleur(background);
                }
            }
        };
        button.addMouseListener(actionListener);
        panel_1.setLayout(null);
                
        panel_1.add(button);
        panel_1.setSize(310, 140);
        panel_1.setVisible(true);
        
	    // On créé le listener pour quitter 
		//quitterPage listenerQuitter = new quitterPage();
	 
	    // On écoute des évènements de type "action" sur le bouton quitter du menu
		//boutonQuitter.addActionListener(listenerQuitter);
	}
}


