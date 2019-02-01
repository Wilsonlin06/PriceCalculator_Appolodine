package pricecalculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class pricecalculator {
	private JFrame frmAppolodineBeautyart;
	private JTextField b_price;
	private JTextField dc;
	private JTextField tax;
	private JTextField o_price;
	private JCheckBox chckbxCashDiscount;
	private JCheckBox chckbxTax;
	private JTextField c_dc;
	private JTextField f_price;
	private JTextField o_dc;
	boolean taxselect,cdcselect,odcselect;
	final DecimalFormat df= new DecimalFormat("###.00");
	private JButton btnReset;
	private JLabel lblOtherDiscount;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pricecalculator window = new pricecalculator();
					window.frmAppolodineBeautyart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pricecalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppolodineBeautyart = new JFrame();
		frmAppolodineBeautyart.setTitle("Appolodine Beauty*Art");
		frmAppolodineBeautyart.setIconImage(Toolkit.getDefaultToolkit().getImage(pricecalculator.class.getResource("/about_files/Icon-Gray.png")));
		frmAppolodineBeautyart.setBackground(new Color(0, 0, 0));
		frmAppolodineBeautyart.getContentPane().setBackground(new Color(255, 105, 180));
		frmAppolodineBeautyart.setBounds(100, 100, 450, 300);
		frmAppolodineBeautyart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppolodineBeautyart.getContentPane().setLayout(null);
		
		tax = new JTextField();
		tax.setEditable(false);
		tax.setBounds(304, 160, 116, 22);
		frmAppolodineBeautyart.getContentPane().add(tax);
		tax.setColumns(10);
		
		chckbxTax = new JCheckBox("Tax:");
		chckbxTax.setBackground(new Color(255, 105, 180));
		chckbxTax.setSelected(true);
		chckbxTax.setBounds(236, 159, 56, 25);
		frmAppolodineBeautyart.getContentPane().add(chckbxTax);
		
		
		b_price = new JTextField();
		b_price.setEditable(false);
		b_price.setBounds(304, 68, 116, 22);
		frmAppolodineBeautyart.getContentPane().add(b_price);
		b_price.setColumns(10);
		

		c_dc = new JTextField();
		c_dc.setBounds(304, 101, 116, 22);
		frmAppolodineBeautyart.getContentPane().add(c_dc);
		c_dc.setColumns(10);
		
		
		dc = new JTextField(null);
		dc.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String oprc = o_price.getText(); //Original price
				String d_c = dc.getText(); //Discount
				double tx,cdc,d,prs;
				if(oprc != null){ //If Original price != empty
					try{ //Original price
						tx = Double.parseDouble(oprc)*0.045;
						tax.setText(df.format(tx));//Set tax						
						b_price.setText(df.format(Double.parseDouble(oprc)));
						if(dc.getText() != null){ //If Discount != empty
							try{ //Discount
								if(d_c.contains("%")){
									d = Double.parseDouble(d_c.substring(0, d_c.length()-1));
									prs = Double.parseDouble(oprc)*(100-d)/100;
									b_price.setText(df.format(prs));
								}else{
									prs = Double.parseDouble(oprc) - Double.parseDouble(d_c);
									b_price.setText(df.format(prs));
								}
								if(Double.parseDouble(oprc) >= 39) cdc = Double.parseDouble(b_price.getText())*0.05;
								else cdc = 0.0;
								c_dc.setText(df.format(cdc));
							}catch(Exception e){ //Discount
								b_price.setText(oprc);
								if(Double.parseDouble(oprc) >= 39) cdc = Double.parseDouble(b_price.getText())*0.05;
								else cdc = 0.0;
								c_dc.setText(df.format(cdc));
							}
						}else{
							b_price.setText(df.format(oprc));
							if(Double.parseDouble(oprc) >= 39) cdc = Double.parseDouble(b_price.getText())*0.05;
							else cdc = 0.0;
							c_dc.setText(df.format(cdc));
						}
						chck();
					}catch(Exception e){ //Original price
						b_price.setText(null);
						f_price.setText(null);
						tax.setText(null);
						c_dc.setText(null);
					}
				}else{
					b_price.setText(null);
					f_price.setText(null);
					tax.setText(null);
					c_dc.setText(null);
				}
			}
		});
		dc.setBounds(187, 68, 105, 22);
		frmAppolodineBeautyart.getContentPane().add(dc);
		dc.setColumns(10);		
		o_price = new JTextField(null);
		o_price.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String oprc = o_price.getText(); //Original price
				String d_c = dc.getText(); //Discount
				double tx,cdc,d,prs;
				if(oprc != null){ //If Original price != empty
					try{ //Original price
						tx = Double.parseDouble(oprc)*0.045;
						tax.setText(df.format(tx));//Set tax
						b_price.setText(df.format(Double.parseDouble(oprc)));
						if(d_c != null){ //If Discount != empty
							try{ //Discount
								if(d_c.contains("%")){
									d = Double.parseDouble(d_c.substring(0, d_c.length()-1));
									prs = Double.parseDouble(oprc)*(100-d)/100;
									b_price.setText(df.format(prs));
								}else{
									prs = Double.parseDouble(oprc) - Double.parseDouble(d_c);
									b_price.setText(df.format(prs));
								}
								if(Double.parseDouble(oprc) >= 39) cdc = Double.parseDouble(b_price.getText())*0.05;
								else cdc = 0.0;
								c_dc.setText(df.format(cdc));
							}catch(Exception e){ //Discount
								b_price.setText(oprc);
								if(Double.parseDouble(oprc) >= 39) cdc = Double.parseDouble(b_price.getText())*0.05;
								else cdc = 0.0;
								c_dc.setText(df.format(cdc));
							}
						}else{
							b_price.setText(df.format(oprc));
							if(Double.parseDouble(oprc) >= 39) cdc = Double.parseDouble(b_price.getText())*0.05;
							else cdc = 0.0;
							c_dc.setText(df.format(cdc));
						}
						chck();
					}catch(Exception e){ //Original price
						b_price.setText(null);
						f_price.setText(null);
						tax.setText(null);
						c_dc.setText(null);
					}
				}else{
					b_price.setText(null);
					f_price.setText(null);
					tax.setText(null);
					c_dc.setText(null);
				}
			}
		});
		o_price.setBounds(59, 68, 116, 22);
		frmAppolodineBeautyart.getContentPane().add(o_price);
		o_price.setColumns(10);
		
		chckbxCashDiscount = new JCheckBox("Cash Discount:");
		chckbxCashDiscount.setBackground(new Color(255, 105, 180));
		chckbxCashDiscount.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				chck();
			}
		});
		chckbxCashDiscount.setBounds(179, 100, 113, 25);
		frmAppolodineBeautyart.getContentPane().add(chckbxCashDiscount);
		
		
		JLabel lblPriceCalculator = new JLabel("Price Calculator");
		lblPriceCalculator.setFont(new Font("Georgia", Font.BOLD, 16));
		lblPriceCalculator.setBounds(169, 14, 141, 16);
		frmAppolodineBeautyart.getContentPane().add(lblPriceCalculator);
		
		JLabel lblOriginalPrice = new JLabel("Original Price");
		lblOriginalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOriginalPrice.setBounds(76, 46, 86, 16);
		frmAppolodineBeautyart.getContentPane().add(lblOriginalPrice);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscount.setBounds(214, 45, 56, 16);
		frmAppolodineBeautyart.getContentPane().add(lblDiscount);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(342, 46, 56, 16);
		frmAppolodineBeautyart.getContentPane().add(lblPrice);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 195, 408, 10);
		frmAppolodineBeautyart.getContentPane().add(separator);
		
		JLabel lblFinalPrice = new JLabel("Final Price:");
		lblFinalPrice.setBounds(228, 205, 64, 16);
		frmAppolodineBeautyart.getContentPane().add(lblFinalPrice);
		
		f_price = new JTextField();
		f_price.setBounds(304, 202, 116, 22);
		frmAppolodineBeautyart.getContentPane().add(f_price);
		f_price.setColumns(10);
		
		o_dc = new JTextField();
		o_dc.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				chck();
			}
		});
		o_dc.setBounds(304, 130, 116, 22);
		frmAppolodineBeautyart.getContentPane().add(o_dc);
		o_dc.setColumns(10);
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(0, 0, 0));
		btnReset.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				o_price.setText("");
				b_price.setText("");
				dc.setText("");
				f_price.setText("");
				c_dc.setText("");
				tax.setText("");
				chckbxCashDiscount.setSelected(false);
				chckbxTax.setSelected(true);
			}
		});
		btnReset.setBounds(59, 201, 97, 25);
		frmAppolodineBeautyart.getContentPane().add(btnReset);
		
		lblOtherDiscount = new JLabel("Other Discount:");
		lblOtherDiscount.setBounds(199, 134, 93, 16);
		frmAppolodineBeautyart.getContentPane().add(lblOtherDiscount);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(pricecalculator.class.getResource("/about_files/Logo-sm.png")));
		lblNewLabel.setBounds(40, 121, 122, 41);
		frmAppolodineBeautyart.getContentPane().add(lblNewLabel);
		chckbxTax.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				chck();	
			}
		});	
	}
	
	public void chck(){
		double cdc = Double.parseDouble(c_dc.getText()), //Cash discount
				tx = Double.parseDouble(tax.getText()), //Tax
				bprc = Double.parseDouble(b_price.getText()); //The price after discount
		String odc = o_dc.getText(); 
		if(chckbxTax.isSelected()){
			if(chckbxCashDiscount.isSelected()){
				if(odc != null){
					try{
						if(odc.contains("%")){
							double amt = Double.parseDouble(odc.substring(0, odc.length()-1));
							double af_amt = bprc*amt/100;
							f_price.setText(df.format(bprc-cdc-af_amt+tx));
						}else{
							double amt = Double.parseDouble(odc);
							f_price.setText(df.format(bprc-amt-cdc+tx));
						}
					}catch(Exception e){
						f_price.setText(df.format(bprc-cdc+tx));
					}
				}else{
					f_price.setText(df.format(bprc-cdc+tx));
				}
			}else{
				if(odc != null){
					try{
						if(odc.contains("%")){
							double amt = Double.parseDouble(odc.substring(0, odc.length()-1));
							double af_amt = bprc*amt/100;
							f_price.setText(df.format(bprc-af_amt+tx));
						}else{
							double amt = Double.parseDouble(odc);
							f_price.setText(df.format(bprc-amt+tx));
						}
					}catch(Exception e){
						f_price.setText(df.format(bprc+tx));
					}
				}else{
					f_price.setText(df.format(bprc+tx));
				}	
			}
		}else{
			if(chckbxCashDiscount.isSelected()){
				if(odc != null){
					try{
						if(odc.contains("%")){
							double amt = Double.parseDouble(odc.substring(0, odc.length()-1));
							double af_amt = bprc*amt/100;
							f_price.setText(df.format(bprc-cdc-af_amt));
						}else{
							double amt = Double.parseDouble(odc);
							f_price.setText(df.format(bprc-amt-cdc));
						}
					}catch(Exception e){
						f_price.setText(df.format(bprc-cdc));
					}
				}else{
					f_price.setText(df.format(bprc-cdc));
				}
			}else{
				if(odc != null){
					try{
						if(odc.contains("%")){
							double amt = Double.parseDouble(odc.substring(0, odc.length()-1));
							double af_amt = bprc*amt/100;
							f_price.setText(df.format(bprc-af_amt));
						}else{
							double amt = Double.parseDouble(odc);
							f_price.setText(df.format(bprc-amt));
						}
					}catch(Exception e){
						f_price.setText(df.format(bprc));
					}
				}else{
					f_price.setText(df.format(bprc));
				}	
			}
		}
	}
}