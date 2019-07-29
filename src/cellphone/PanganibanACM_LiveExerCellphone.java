package cellphone;

import javax.swing.JOptionPane;

public class PanganibanACM_LiveExerCellphone {
	public static void main(String[] args) {
	String number = "";
	String error = "";
	do {
		number = (String) JOptionPane.showInputDialog(null, error + "Enter your number: ", "Cellphone", JOptionPane.DEFAULT_OPTION,  null, null,"09167618265");
		if (number.isEmpty()) {
			System.exit(0);
		}
		try {
			long n = Long.parseLong(number);
		} catch (NumberFormatException | NullPointerException e) {
			error += "Invalid number! \n";
			continue;
		}

		if(number.length() == 11) {
			break;
		}
		else {
			error += "Invalid number! \n";
		}
	}while(true);
	
	Cellphone cp = new Cellphone();
	cp.number = number;
	
	String choices[] = {"Re-Load", "Text/Message", "Check Balance", "Pasa-Load", "Exit"};
	String title = cp.number;
	String input = "";
	
	do {
		String choice = (String) JOptionPane.showInputDialog(null, "Choose one",  title , JOptionPane.DEFAULT_OPTION, null, choices, choices[0]);
		if (choice.equals("Re-Load")) {
			try {
				input = (String) JOptionPane.showInputDialog(null, "Enter amount: ", title, JOptionPane.DEFAULT_OPTION,  null, null,"amount");
				if (input.isEmpty()) {
					continue;
				}
				cp.paLoad(Integer.parseInt(input), title);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input!", title, 0);
			}
		}
		else if (choice.equals("Text/Message")) {
			input = (String) JOptionPane.showInputDialog(null, "Enter message: ", title, JOptionPane.DEFAULT_OPTION,  null, null,"msg");
			if (input.isEmpty()) {
				continue;
			}
			try {
				number = (String) JOptionPane.showInputDialog(null, "To: ", title, JOptionPane.DEFAULT_OPTION,  null, null,"number");
				if (number.isEmpty()) {
					continue;
				}
				cp.txt(input, Integer.parseInt(number), title);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid number!", title, 0);
			}
		}
		else if (choice.equals("Check Balance")) {
			cp.chkbal(title);
		}
		else if (choice.equals("Pasa-Load")) {
			int inp = 0;
			input = (String) JOptionPane.showInputDialog(null, "Enter amount: ", title, JOptionPane.DEFAULT_OPTION,  null, null,"amount");
			if (input.isEmpty()) {
				continue;
			}
			try {
				inp = Integer.parseInt(input);
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid number!", title, 0);
				continue;
			}
			try {
				number = (String) JOptionPane.showInputDialog(null, "To: ", title, JOptionPane.DEFAULT_OPTION,  null, null,"number");
				if (number.isEmpty()) {
					continue;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid number!", title, 0);
				continue;
			}
			long num = 0;
			try {
				num = Long.parseLong(number);
			}catch (NumberFormatException | NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Invalid number!", title, 0);
				continue;
			}
			if (number.length() == 11) {
				cp.pasaLoad(Integer.parseInt(input), num, title);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid number!", title, 0);
			}
			
		} else {
			System.out.println("Exit normally !");
			break;
		}
		} while(true);
	}
}
