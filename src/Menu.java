import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Menu extends JFrame {
	
	/**
	 * @author David
	 */
	
	// Déclaration des variables
	private static final long serialVersionUID = -43682627140142051L;
	private JPanel contentPane;
	private JCheckBox chckbxFilDeFer;
	private JCheckBox chckbxRemplie;
	private static JComboBox<Object> comboBox;
	private static JComboBox<Object> comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					// Titre de la Fenêtre
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
	public Menu(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Creation de la premiere section
		JPanel panel = new JPanel();
		panel.setLocation(5, 28);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(new Color(51, 204, 204));
		panel_1.setBounds(5, 51, 197, 402);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton BoutonCreer = new JButton("CREER");
		BoutonCreer.setBounds(47, 57, 108, 57);
		panel_1.add(BoutonCreer);
		BoutonCreer.setBackground(new Color(204, 204, 255));
			 
	    // On créé un listener permettant le chargement de la fenetre 1
		chargementPage1 listener = new chargementPage1(this);
	 
	    // On écoute des évènements de type "action" sur le bouton
		BoutonCreer.addActionListener(listener);
		
		// Mode fil de fer ou remplie
		chckbxFilDeFer = new JCheckBox("Fil de Fer");
		chckbxFilDeFer.setBounds(47, 163, 97, 23);
		
		chckbxRemplie = new JCheckBox("Remplie", true);
		chckbxRemplie.setBounds(47, 219, 97, 23);
			
		ButtonGroup groupeBox = new ButtonGroup();
		groupeBox.add(chckbxFilDeFer);
		groupeBox.add(chckbxRemplie);
		panel_1.add(chckbxFilDeFer);
		panel_1.add(chckbxRemplie);
		
		Label label_1 = new Label("Ou");
		label_1.setBounds(84, 192, 28, 22);
		panel_1.add(label_1);
		
		// Choix de la forme
		Label label = new Label("Choix de la forme :");
		label.setBounds(47, 267, 98, 22);
		panel_1.add(label);
				
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"rectangle", "ellipse"}));
		comboBox.setBounds(47, 295, 90, 20);
		panel_1.add(comboBox);
		
		// ******************************************* Creation de la deuxieme section *******************************************
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(212, 51, 208, 402);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBackground(new Color(51, 204, 204));
		
		JButton BoutonCreer1 = new JButton("CREER");
		BoutonCreer1.setBackground(new Color(204, 204, 255));
		BoutonCreer1.setBounds(59, 57, 97, 58);
		panel_2.add(BoutonCreer1);
		
	    // On créé le listener pour le chargement de la fenetre 2
		chargementPage2 listener1 = new chargementPage2(this);
	 
	    // On écoute des évènements de type "action" sur le bouton
		BoutonCreer1.addActionListener(listener1);
		
		// Choix de la forme
		Label label_2 = new Label("Choix de la forme :");
		label_2.setBounds(58, 211, 98, 22);
		panel_2.add(label_2);
		
		comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"rectangle", "ellipse"}));
		comboBox_1.setBounds(59, 239, 91, 20);
		panel_2.add(comboBox_1);
		
		// ***********************************Creation de la troisieme section ******************************************//
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_3.setBackground(new Color(51, 204, 204));
		panel_3.setBounds(430, 51, 205, 402);
		contentPane.add(panel_3);
		
		JButton BoutonCreer2 = new JButton("CREER");
		BoutonCreer2.setBackground(new Color(204, 204, 255));
		BoutonCreer2.setBounds(52, 53, 109, 60);
		panel_3.add(BoutonCreer2);
		
	    // On créé le listener pour le chargement de la fenetre 3
		chargementPage3 listener2 = new chargementPage3();
	 
	    // On écoute des évènements de type "action" sur le bouton
		BoutonCreer2.addActionListener(listener2);
		
		// Creation de la barre de menu 
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 715, 25);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu\r\n");
		menuBar.add(mnMenu);
		
		mnMenu.add("Ouvrir dessin");
		mnMenu.add("Quitter");
		
		JLabel lblTypeFormeFixe = new JLabel("Type forme fixe");
		lblTypeFormeFixe.setBounds(63, 26, 94, 14);
		contentPane.add(lblTypeFormeFixe);
		
		JLabel lblTypeSemifixe = new JLabel("Type semi-fixe");
		lblTypeSemifixe.setBounds(276, 28, 83, 14);
		contentPane.add(lblTypeSemifixe);
		
		JLabel lblTypeNonFixe = new JLabel("Type non fixe");
		lblTypeNonFixe.setBounds(502, 28, 83, 14);
		contentPane.add(lblTypeNonFixe);
		
	}
	
	public String getComboBox(){
		return comboBox.getSelectedItem().toString();
	}
	
	public String getComboBox_1(){
		return comboBox_1.getSelectedItem().toString();
	}

	public boolean getChckbxFilDeFer() {
		return chckbxFilDeFer.isSelected();
	}
	
	public boolean getChckbxRemplie(){
		return chckbxRemplie.isSelected();
	}
	
};
