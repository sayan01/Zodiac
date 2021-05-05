import java.awt.event.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class OnDateEntered implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent evt){
		String date = GUIMain.tfMain.getText();
		GUIMain.tfMain.setText("");
		String[] ddmmyy = date.trim().split("[/ -.+]+");
		boolean isleap = false;
		try {
			for (int i =0;i<3;i++){
				String a = ddmmyy[i];
			}
		}catch(Exception nPE){
			GUIMain.taresult.setText("Invalid Date!");
			System.out.println(nPE.toString());
		}
		int yr = Integer.parseInt(ddmmyy[2]);
		int mt = Integer.parseInt(ddmmyy[1]);
		int dt = Integer.parseInt(ddmmyy[0]);
		isleap = ((yr % 4 == 0 && yr % 100 != 0) || yr % 400 == 0);
		int[] nod = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(isleap) nod[2] = 29;
		if( (mt > 12 ) || (dt > nod[mt] ) ||  (yr<1900&&yr>99)){ 
			GUIMain.taresult.setText("Invalid Date!");
			return;
		}
		if(yr<99){
			if(yr<=32){
				yr+=100;
			}
			yr = 1900+yr;
			System.out.println("Year auto corrected to " + yr);
		}
		Calendar current = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.set(yr, mt-1, dt);
		if(dob.after(current)){
			GUIMain.taresult.setText("Invalid Date!");
			return;
		}
		GUIMain.taresult.setText("Your Zodiac Sign is : " + getzod(dt,mt));
		System.out.println(current.getTime());
		System.out.println("\n"+dob.getTime());
		long daysOld = ChronoUnit.DAYS.between(dob.toInstant(), current.toInstant());
		long hoursOld = ChronoUnit.HOURS.between(dob.toInstant(), current.toInstant());
		long minsOld = ChronoUnit.MINUTES.between(dob.toInstant(), current.toInstant());
		GUIMain.taresult.append("\nand you are \t"+daysOld+" days old or,");
		GUIMain.taresult.append("\n\t"+hoursOld+" hours old or, ");
		GUIMain.taresult.append("\n\t"+minsOld+" minutes old");
	}
	public static String getzod(int dt,int mt){
		int[] limits = { 0,20,19,21,20,21,21,23,23,23,23,22,22} ;
		String [] zodlist = {"","Aquarius","Pisces","Aries","Taurus","Gemini","Cancer","Leo","Virgo","Libra","Scropio","Sagittarius", "Capricorn" };
		int mylim = limits[mt];
		String zod ="";
		if(dt >= mylim ){
			zod = zodlist[mt];
		}
		else if ( mt > 1){
			zod = zodlist[mt-1];
		}
		else zod = zodlist[12];
		return zod;
	}
}
