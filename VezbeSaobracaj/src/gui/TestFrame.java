package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelCenter;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Forma za vezbanje");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelNorth.add(lblTitle);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnAntristres = new JButton("Antristres dugme");
		btnAntristres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Pritisnuli ste antistres dugme! 😁");
			}
		});
		btnAntristres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSouth.add(btnAntristres);
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0, 0, 43, 0, 0, 0, 71, 0, 0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel lblCrvena = new JLabel("Crvena");
		lblCrvena.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 1;
		panelCenter.add(lblCrvena, gbc_lblCrvena);
		
		JButton btnCrvena = new JButton("Oboji me u crveno!");
		btnCrvena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeBackgroundColor(Color.RED);
				dlm.add(0,lblCrvena.getText());
			}
		});
		btnCrvena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnCrvena = new GridBagConstraints();
		gbc_btnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrvena.gridx = 3;
		gbc_btnCrvena.gridy = 1;
		panelCenter.add(btnCrvena, gbc_btnCrvena);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					String boja = dlm.elementAt(list.getSelectedIndex());
					switch(boja) {
					case "Crvena":
						changeBackgroundColor(Color.RED);
						break;
					case "Plava":
						changeBackgroundColor(Color.BLUE);
						break;
					case "Zelena":
						changeBackgroundColor(Color.GREEN);
						break;
					}
				} catch (ArrayIndexOutOfBoundsException e2) {
					return;
				}
				
			}
		});
		list.setModel(dlm);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 5;
		gbc_list.gridwidth = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 5;
		gbc_list.gridy = 1;
		panelCenter.add(list, gbc_list);
		
		JLabel lblPlava = new JLabel("Plava");
		lblPlava.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 3;
		panelCenter.add(lblPlava, gbc_lblPlava);
		
		JButton btnPlava = new JButton("Oboji me u plavo!");
		btnPlava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeBackgroundColor(Color.BLUE);
				dlm.add(0,lblPlava.getText());
			}
		});
		btnPlava.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnPlava = new GridBagConstraints();
		gbc_btnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlava.gridx = 3;
		gbc_btnPlava.gridy = 3;
		panelCenter.add(btnPlava, gbc_btnPlava);
		
		JLabel lblZelena = new JLabel("Zelena");
		lblZelena.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		GridBagConstraints gbc_lblZelena = new GridBagConstraints();
		gbc_lblZelena.insets = new Insets(0, 0, 5, 5);
		gbc_lblZelena.gridx = 1;
		gbc_lblZelena.gridy = 5;
		panelCenter.add(lblZelena, gbc_lblZelena);
		
		JButton btnZelena = new JButton("Oboji me u zeleno!");
		btnZelena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeBackgroundColor(Color.GREEN);
				dlm.add(0,lblZelena.getText());
			}
		});
		btnZelena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnZelena = new GridBagConstraints();
		gbc_btnZelena.insets = new Insets(0, 0, 5, 5);
		gbc_btnZelena.gridx = 3;
		gbc_btnZelena.gridy = 5;
		panelCenter.add(btnZelena, gbc_btnZelena);
	}
	
	public void changeBackgroundColor(Color c) {
		panelCenter.setBackground(c);
	}

}
