package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmIgrac extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList list = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIgrac frame = new FrmIgrac();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmIgrac() {
		setTitle("Igraci");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.YELLOW);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Forma za dodavanje igraca");
		lblNaslov.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelNorth.add(lblNaslov);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.PINK);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnDijalog = new JButton("Dijalog igrac");
		btnDijalog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgIgrac dijalog = new DlgIgrac();
				dijalog.setVisible(true);
				dlmInputNoDuplicates(dijalog.getTextFieldIme().getText() + " " + 
				dijalog.getTextFieldPrezime().getText(), dlm);
			}
		});
		btnDijalog.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelSouth.add(btnDijalog);
		
		JButton btnModifikacija = new JButton("Modifikacija");
		btnModifikacija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexOdabranogIgraca = list.getSelectedIndex();
				if(indexOdabranogIgraca == -1) {
					JOptionPane.showMessageDialog(null, "Prvo selektujte element sa liste!");
				}
				else {
					DlgIgrac dijalog = new DlgIgrac();
					String odabraniIgrac = dlm.get(list.getSelectedIndex());
					String[] razdvojenoImeIPrezime = odabraniIgrac.split(" ");
					if(razdvojenoImeIPrezime.length == 1) {
						dijalog.setTextFieldPrezime(razdvojenoImeIPrezime[0]);
					}else {
						dijalog.setTextFieldIme(razdvojenoImeIPrezime[0]);
						dijalog.setTextFieldPrezime(razdvojenoImeIPrezime[1]);
					}
					dijalog.setVisible(true);
					if(! dlm.contains(dijalog.getTextFieldIme().getText() + " " +
					dijalog.getTextFieldPrezime().getText())) {
						dlm.add(indexOdabranogIgraca, dijalog.getTextFieldIme().getText() +
								" " + dijalog.getTextFieldPrezime().getText());
						dlm.remove(indexOdabranogIgraca+1);
					}
					
				}
			}
		});
		btnModifikacija.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelSouth.add(btnModifikacija);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{100, 300, 200, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 30, 0, 30, 0, 30, 0, 30, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel lblPrva = new JLabel("Dusan Vlahovic");
		
		JButton btnJedan = new JButton("Vlahovic");
		btnJedan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlmInputNoDuplicates(lblPrva.getText(), dlm);
			}
		});
		btnJedan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnJedan = new GridBagConstraints();
		gbc_btnJedan.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJedan.insets = new Insets(0, 0, 5, 5);
		gbc_btnJedan.gridx = 0;
		gbc_btnJedan.gridy = 0;
		panelCenter.add(btnJedan, gbc_btnJedan);
		
		
		lblPrva.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints gbc_lblPrva = new GridBagConstraints();
		gbc_lblPrva.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrva.gridx = 1;
		gbc_lblPrva.gridy = 0;
		panelCenter.add(lblPrva, gbc_lblPrva);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		panelCenter.add(scrollPane, gbc_scrollPane);
		
		list.setModel(dlm);
		scrollPane.setViewportView(list);
		
		JLabel lblDruga = new JLabel("Dusan Tadic");
		
		JButton btnDva = new JButton("Tadic");
		btnDva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlmInputNoDuplicates(lblDruga.getText(), dlm);
			}
		});
		btnDva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnDva = new GridBagConstraints();
		gbc_btnDva.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDva.insets = new Insets(0, 0, 5, 5);
		gbc_btnDva.gridx = 0;
		gbc_btnDva.gridy = 2;
		panelCenter.add(btnDva, gbc_btnDva);
		
		
		lblDruga.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints gbc_lblDruga = new GridBagConstraints();
		gbc_lblDruga.insets = new Insets(0, 0, 5, 5);
		gbc_lblDruga.gridx = 1;
		gbc_lblDruga.gridy = 2;
		panelCenter.add(lblDruga, gbc_lblDruga);
		
		JLabel lblTreca = new JLabel("Aleksandar Mitrovic");
		
		JButton btnTri = new JButton("Mitrovic");
		btnTri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlmInputNoDuplicates(lblTreca.getText(), dlm);
			}
		});
		btnTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnTri = new GridBagConstraints();
		gbc_btnTri.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTri.insets = new Insets(0, 0, 5, 5);
		gbc_btnTri.gridx = 0;
		gbc_btnTri.gridy = 4;
		panelCenter.add(btnTri, gbc_btnTri);
		
		
		lblTreca.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints gbc_lblTreca = new GridBagConstraints();
		gbc_lblTreca.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreca.gridx = 1;
		gbc_lblTreca.gridy = 4;
		panelCenter.add(lblTreca, gbc_lblTreca);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Unesi igraca");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.isEnabled()) {
					textField.setEnabled(true);
				}else {
					textField.setEnabled(false);
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBackground(Color.PINK);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 6;
		panelCenter.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if( (c>='A' && c<='Z') || (c>='a' && c<='z') || c==KeyEvent.VK_ENTER ||
						c==KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE) {
					if(c == KeyEvent.VK_ENTER) {
						dlmInputNoDuplicates(textField.getText(), dlm);
						textField.setText("");
					}
				}else {
					e.consume();
				}
			}
		});
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		panelCenter.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblIgraci = new JLabel("Igraci");
		lblIgraci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblIgraci = new GridBagConstraints();
		gbc_lblIgraci.insets = new Insets(0, 0, 0, 5);
		gbc_lblIgraci.gridx = 0;
		gbc_lblIgraci.gridy = 8;
		panelCenter.add(lblIgraci, gbc_lblIgraci);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null) {
					dlmInputNoDuplicates(comboBox.getSelectedItem().toString(), dlm);
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Milinkovic Savic", "Jovic", "Gudelj"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 8;
		panelCenter.add(comboBox, gbc_comboBox);
	}
	
	public void dlmInputNoDuplicates(String s, DefaultListModel<String> dlm) {
		if(dlm.contains(s) || s.isBlank()) {
			return;
		}else {
			dlm.add(0, s);
		}
	}

}
