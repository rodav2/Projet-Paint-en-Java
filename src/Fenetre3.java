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
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JCheckBox;


public class Fenetre3 extends JFrame {

	/**
	 * @author David
	 */
	// Declarations des variables
	private static final long serialVersionUID = 6705051562375346180L;
	private JPanel contentPane;
	public Point origin;
    public Point end;
	public ArrayList<MyPaintedLabel> mesFormes = new ArrayList<MyPaintedLabel>();
	private static JComboBox<Object> comboBox_2;
	private static JComboBox<Object> comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre3 frame = new Fenetre3();
					// Tire de la fenetre
					frame.setTitle("Dessin sur ordinateur");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre3() {
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
		
		// Permet de dessiner
		final MyPaintedPanel dessin = new MyPaintedPanel(new BorderLayout());
		dessin.setBounds(10, 46, 356, 471);
		this.contentPane.add(dessin);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(385, 46, 310, 126);
		contentPane.add(panel_1);
		
		// Creation de la barre de menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 715, 25);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu\r\n");
		menuBar.add(mnMenu);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_3.setBackground(Color.GREEN);
		panel_3.setBounds(385, 196, 309, 77);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		// Mode d'affichage remplie ou fil de fer
		JLabel lblModeAffichage = new JLabel("Mode affichage");
		lblModeAffichage.setBounds(75, 11, 160, 22);
		lblModeAffichage.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblModeAffichage);
		
		JCheckBox chckbxRemplie = new JCheckBox("Remplie");
		chckbxRemplie.setBounds(174, 45, 109, 23);
		
		JCheckBox chckbxFilDeFer = new JCheckBox("Fil de fer", true);
		chckbxFilDeFer.setBounds(31, 45, 109, 23);
				
		ButtonGroup groupeBox = new ButtonGroup();
		groupeBox.add(chckbxRemplie);
		groupeBox.add(chckbxFilDeFer);
		panel_3.add(chckbxRemplie);
		panel_3.add(chckbxFilDeFer);
		
		chckbxFilDeFer.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
				MyPaintedPanel.setRempli(false);
			}
		});
		chckbxRemplie.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
				MyPaintedPanel.setRempli(true);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(385, 280, 309, 130);
		contentPane.add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setLayout(null);
		
		// Mode ascii
		JLabel lblNewLabel = new JLabel("Mode ASCII");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(85, 11, 119, 22);
		panel_2.add(lblNewLabel);
		
		// 1er caractere
		JLabel lblerCaractre = new JLabel("1er caract\u00E8re :");
		lblerCaractre.setBounds(26, 44, 94, 14);
		panel_2.add(lblerCaractre);
		
		// 2eme caractere
		JLabel lblemeCaractre = new JLabel("2eme caract\u00E8re :");
		lblemeCaractre.setBounds(164, 44, 105, 14);
		panel_2.add(lblemeCaractre);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"*", "-", "+", "=", "$", "^", "\u00A3", "\u00A8", "!", "\u00A7", ":", "/", ".", ";", ",", "?", "#", "\"", "~", "&", "@", "\u00B0"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(119, 44, 35, 20);
		panel_2.add(comboBox);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"=", "-", "+", "*", "$", "^", "\u00A3", "\u00A8", "!", "\u00A7", ":", "/", ".", ";", ",", "?", "#", "\"", "~", "&", "@", "\u00B0"}));
		comboBox_1.setBounds(264, 41, 35, 20);
		panel_2.add(comboBox_1);
		
		JButton btnPasserEnMode = new JButton("Passer en mode ASCII");
		btnPasserEnMode.setBounds(64, 69, 175, 23);
		panel_2.add(btnPasserEnMode);
		
		JButton btnRetourEnMode = new JButton("Retour en mode couleur");
		btnRetourEnMode.setBounds(64, 96, 175, 23);
		panel_2.add(btnRetourEnMode);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(385, 421, 309, 96);
		contentPane.add(panel_4);
		
		JLabel lblForme = new JLabel("Forme");
		lblForme.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblForme.setBounds(120, 11, 67, 22);
		panel_4.add(lblForme);
		
		JLabel lblForme_1 = new JLabel("Forme :");
		lblForme_1.setBounds(10, 46, 92, 14);
		panel_4.add(lblForme_1);
		
		comboBox_2 = new JComboBox<Object>();
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"rectangle", "ellipse"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(10, 60, 92, 20);
		panel_4.add(comboBox_2);
		
		//Ecoute du ComboBox
		comboBox_2.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
				MyPaintedPanel.setTypeForme(getComboBox_2());
			}
		});
		
		JLabel lblTaille = new JLabel("Taille :");
		lblTaille.setBounds(120, 46, 70, 14);
		panel_4.add(lblTaille);
		
		JLabel lblProfondeur = new JLabel("Profondeur :");
		lblProfondeur.setBounds(211, 46, 88, 14);
		panel_4.add(lblProfondeur);
		
		JComboBox<Object> comboBox_4 = new JComboBox<Object>();
		comboBox_4.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_4.setToolTipText("");
		comboBox_4.setBounds(211, 60, 88, 20);
		panel_4.add(comboBox_4);
		
		comboBox_3 = new JComboBox<Object>();
		comboBox_3.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "4", "6", "8", "10", "12", "14"}));
		comboBox_3.setToolTipText("");
		comboBox_3.setBounds(120, 60, 70, 20);
		panel_4.add(comboBox_3);
		
		//Ecoute du ComboBox
		comboBox_3.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
				MyPaintedPanel.setContEpaisseur(getComboBox_3());
			}
		});
		
		mnMenu.add("Ouvrir");
		mnMenu.add("Sauvegarder");
		mnMenu.add("Quitter");
		
		//Créer le bouton
        final javax.swing.JButton button = new JButton();
        button.setBounds(87, 57, 152, 23);
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
	}
	
	//************ GETTERs & SETTERs ************//
	public String getComboBox_2() {
		return comboBox_2.getSelectedItem().toString();
	}

	public int getComboBox_3() {
		return Integer.parseInt(comboBox_3.getSelectedItem().toString());
	}
}
