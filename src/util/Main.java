package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String padding = "---------------------------------------------------------------";
	static String rg = "^[0-9]+$|(?i)end|(?i)GENERAL|(?i)VIP|(?i)VVIP|(!?)ASCENDING|(!?)DESCENDING";
	public static int groupsCapacity = 4;
	public static String input(){
		String inp = " ";
		boolean regex = false;
		while(true){
			try{
				inp = br.readLine();
				StringTokenizer st = new StringTokenizer(inp);
				inp = st.nextToken();
				regex = Pattern.matches(rg, inp);
			}catch(Exception e){
				e.printStackTrace();
			}
			if (regex == true){
				inp = inp.toUpperCase();
				return inp;
			}
			else {
				System.out.print("Invalid Type for Input. Please try again.\nInput : ");
			}
		}
	}

	public static void main(String[] args) {;
		 SmartStoreApplication.getInstance().test().run(); // builder patter, test mode
		// SmartStoreApplication.getInstance().run(); // normal mode

		//SmartStoreApplication.getInstance().details().run();

	}
}
