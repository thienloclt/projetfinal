package monprojet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String s2 = "dd00s";
		
		String regex3 = "^[a-zA-Z]{2}+\\d{3}";
		
        Matcher matcher3 = (Pattern.compile(regex3)).matcher(s2);
        
        System.out.println(matcher3.matches());
	}

}
