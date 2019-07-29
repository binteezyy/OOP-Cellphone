package cellphone;

import javax.swing.JOptionPane;

public class Cellphone {
	String number;
	int load = 0;
	
	void paLoad(int money, String title) {
		if (money <= 0) {
			JOptionPane.showMessageDialog(null, "Invalid amount!", title, 0);
		}
		else if (money > 0) {
			load += money;
			JOptionPane.showMessageDialog(null, "Loaded " + money + " to " + number , title, 2);
		}
	}
	
	void txt(String message, int sendto, String title) {
		if (load > 0) {
			load--;
			JOptionPane.showMessageDialog(null, "Message sent to " + sendto , title, 2);
		}
		else {
			JOptionPane.showMessageDialog(null, "Check operator service!", title, 2);
		}
	}
	
	void chkbal(String title) {
		JOptionPane.showMessageDialog(null, "Your balance is: " + load, title, 2);
	}
	
	void pasaLoad(int amount, long sendto, String title) {
		if (amount > load) {
			JOptionPane.showMessageDialog(null, "Insufficient balance!", title, 2);
		}else {
			load -= amount;
			JOptionPane.showMessageDialog(null, amount + " pesos sent to " + sendto , title, 2);
		}
	}
}
