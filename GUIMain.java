import java.awt.*;
import javax.swing.*;
public class GUIMain extends JFrame {
	static Panel pnMain;
	static Label lblMain;
	static Panel pnDOB;
	static Label lblDOB;
	static TextField tfMain;
	static JTextArea taresult;
	static Panel pnres;
	private static final long serialVersionUID = 1L;
	public GUIMain() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setTitle("Zodiac");
		setSize(300,300);
		pnMain = new Panel();
		pnDOB = new Panel();
		lblMain = new Label ("          Welcome        ",Label.CENTER);
		pnMain.add(lblMain);

		lblDOB = new Label ("Enter DOB:");
		pnDOB.add(lblDOB);

		tfMain = new TextField(10);
		tfMain.setEditable(true);
		pnDOB.add(tfMain);

		pnres = new Panel();
		taresult = new JTextArea();
		taresult.setText("**Output**");
		pnres.add(taresult);

		add(pnMain);
		add(pnDOB);
		add (pnres);

		tfMain.addActionListener(new OnDateEntered());
		setVisible(true);
	}
	public static void main(String [] args) {
		new GUIMain();
	}
}
