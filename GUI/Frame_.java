package GUI;
/**
 * Gui class
 * @author EtiReznikov
 */
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import competitors.Competitor;
import files.ReadAndWriteXlsx;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class Frame_ {

	private JFrame frmRelThrowdownTeens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_ window = new Frame_();
					window.frmRelThrowdownTeens.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame_() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelThrowdownTeens = new JFrame();
		frmRelThrowdownTeens.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\etire\\eclipse-workspace\\Teens2019\\CrossfitREL.png"));
		frmRelThrowdownTeens.setTitle("R.E.L ThrowDown Teens");
		frmRelThrowdownTeens.setBounds(100, 100, 356, 145);
		frmRelThrowdownTeens.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuBar menuBar= new MenuBar();
		
		Menu settings = new Menu("הגדרות");
		settings.setFont(new Font("Tahoma", Font.ITALIC, 13));
		menuBar.add(settings);  // the menu-bar adds this menu
		MenuItem openFileMenu = new MenuItem("עדכן קובץ");
		MenuItem numofcompetitors = new MenuItem("עדכן מספר מתחרים");
		openFileMenu.setFont(new Font("Tahoma", Font.ITALIC, 13));
		numofcompetitors.setFont(new Font("Tahoma", Font.ITALIC, 13));
		settings.add(openFileMenu); // the menu adds this item
		settings.add(numofcompetitors); // the menu adds this item
		openFileMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(null,"xlsx");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					ReadAndWriteXlsx.FILENAME = fileChooser.getSelectedFile().getPath().toString();
				}

			}
		});
		
		numofcompetitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("הזן מספר מתחרים");
				label.setFont(new Font("Tahoma", Font.ITALIC, 13));
				String num=JOptionPane.showInputDialog(label);
				try {
					ReadAndWriteXlsx.numofcompetitors=Integer.parseInt(num);
				}
				catch (Exception exc) {

					JLabel label2 = new JLabel("נא להזין מספר");
					label2.setFont(new Font("Tahoma", Font.ITALIC, 13));
					JOptionPane.showMessageDialog(null,label2,"",JOptionPane.WARNING_MESSAGE);
				}
				}

		});
		
		frmRelThrowdownTeens.setMenuBar(menuBar);
		String[] events= {"1","2","3","4"};
				final JComboBox EventnumComboBox = new JComboBox(events);
				EventnumComboBox.setSelectedItem(null);
				EventnumComboBox.setFont(new Font("Tahoma", Font.ITALIC, 16));
			
				
				JButton EnterResultButton = new JButton("\u05D4\u05D6\u05DF \u05EA\u05D5\u05E6\u05D0\u05D5\u05EA");
				EnterResultButton.setFont(new Font("Tahoma", Font.ITALIC, 16));
				EnterResultButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String value=(String)EventnumComboBox.getSelectedItem();

					
						
						try {
							ReadAndWriteXlsx.readandrate(Integer.parseInt(value));
							JLabel label = new JLabel("התוצאות הוזנו, אפשר להמשיך! ");
							label.setFont(new Font("Tahoma", Font.ITALIC, 13));
							JOptionPane.showMessageDialog( null,label,"התוצאות הוזנו, אפשר להמשיך! ", JOptionPane.WARNING_MESSAGE);
						} catch (NumberFormatException e1) {
							JLabel label = new JLabel("אופס... משהו השתבש, תנסו שוב");
							label.setFont(new Font("Tahoma", Font.ITALIC, 13));
							JOptionPane.showMessageDialog( null,label,"", JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}catch (FileNotFoundException e2) {
							JLabel label = new JLabel( "אופס! צריך לסגור את האקסל קודם");
							label.setFont(new Font("Tahoma", Font.ITALIC, 13));
							JOptionPane.showMessageDialog(null,label,"", JOptionPane.WARNING_MESSAGE);
							
						} catch (IOException e1) {
							JLabel label = new JLabel("אופס... משהו השתבש, תנסו שוב");
							label.setFont(new Font("Tahoma", Font.ITALIC, 13));
							JOptionPane.showMessageDialog( null,label,"", JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}
						
				});
			
			
			
			
			JLabel EventNumLabel = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05DE\u05E7\u05E6\u05D4");
			EventNumLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			GroupLayout groupLayout = new GroupLayout(frmRelThrowdownTeens.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(EnterResultButton)
								.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(EventnumComboBox, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addGap(7)))
						.addComponent(EventNumLabel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addGap(11))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(EventNumLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(EventnumComboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(EnterResultButton)
						.addContainerGap())
			);
			frmRelThrowdownTeens.getContentPane().setLayout(groupLayout);
		ImageIcon logo=new ImageIcon("CrossfitREL.png");
			
		
}
}
