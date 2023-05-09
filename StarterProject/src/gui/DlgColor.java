package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class DlgColor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtBlue;
	private String color;
	
	/*
	 * Posto su komponente dijaloga deklarisane kao privatne,
	 * da bismo im pristupili u klasi TestFrm potrebno je 
	 * definisati get metode
	 */
	public JTextField getTxtRed() {
		return txtRed;
	}

	public JTextField getTxtGreen() {
		return txtGreen;
	}

	public JTextField getTxtBlue() {
		return txtBlue;
	}


	public static void main(String[] args) {
		try {
			DlgColor dialog = new DlgColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getColor() {
		return color;
	}

	/**
	 * Create the dialog.
	 */
	public DlgColor() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRed = new JLabel("Red");
			GridBagConstraints gbc_lblRed = new GridBagConstraints();
			gbc_lblRed.insets = new Insets(0, 0, 5, 5);
			gbc_lblRed.gridx = 0;
			gbc_lblRed.gridy = 0;
			contentPanel.add(lblRed, gbc_lblRed);
		}
		{
			txtRed = new JTextField();
			GridBagConstraints gbc_txtRed = new GridBagConstraints();
			gbc_txtRed.insets = new Insets(0, 0, 5, 0);
			gbc_txtRed.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRed.gridx = 2;
			gbc_txtRed.gridy = 0;
			contentPanel.add(txtRed, gbc_txtRed);
			txtRed.setColumns(10);
		}
		{
			JLabel lblGreen = new JLabel("Green");
			GridBagConstraints gbc_lblGreen = new GridBagConstraints();
			gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
			gbc_lblGreen.gridx = 0;
			gbc_lblGreen.gridy = 1;
			contentPanel.add(lblGreen, gbc_lblGreen);
		}
		{
			txtGreen = new JTextField();
			GridBagConstraints gbc_txtGreen = new GridBagConstraints();
			gbc_txtGreen.insets = new Insets(0, 0, 5, 0);
			gbc_txtGreen.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGreen.gridx = 2;
			gbc_txtGreen.gridy = 1;
			contentPanel.add(txtGreen, gbc_txtGreen);
			txtGreen.setColumns(10);
		}
		{
			JLabel lblBlue = new JLabel("Blue");
			GridBagConstraints gbc_lblBlue = new GridBagConstraints();
			gbc_lblBlue.insets = new Insets(0, 0, 0, 5);
			gbc_lblBlue.gridx = 0;
			gbc_lblBlue.gridy = 2;
			contentPanel.add(lblBlue, gbc_lblBlue);
		}
		{
			txtBlue = new JTextField();
			GridBagConstraints gbc_txtBlue = new GridBagConstraints();
			gbc_txtBlue.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBlue.gridx = 2;
			gbc_txtBlue.gridy = 2;
			contentPanel.add(txtBlue, gbc_txtBlue);
			txtBlue.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							String red = txtRed.getText();
							String green = txtGreen.getText();
							String blue = txtBlue.getText();
							/*
							 * Prilikom parsiranja string vrednosti, moze doci do NumberFormatException,
							 * pa je potrebno obraditi ovaj izuzetak
							 * */
							int r = Integer.parseInt(red);
							int g = Integer.parseInt(green);
							int b = Integer.parseInt(blue);
							
							if(r<0 || r>255 || g<0 || g>255 || b<0 || b>255) {
								JOptionPane.showMessageDialog(null, "Enter numeric values between 0-255","RGB", JOptionPane.INFORMATION_MESSAGE);				
							}else {
								color = red + " " + green + " " + blue;
								setVisible(false);
							}
						}catch(NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Enter numeric values between 0-255","RGB", JOptionPane.INFORMATION_MESSAGE);				
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
