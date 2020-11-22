package ds.string;

public class ValidNumber {

	public static void main(String[] args) {
		String s = "96 e5";
//		char a = 'a';
//		System.out.println(Character.isDigit('0'));
		System.out.println(isNumber(s));
	}
	
	public static boolean isNumber(String s) {
        String input = s.trim();
        
        if(input.indexOf(' ')>=0)
        	return false;
        
        if(input == null || input.isEmpty())
			return false;
        
        if(input.length() == 1)
        	return Character.isDigit(input.charAt(0));
        
        int e = input.indexOf('e');
        
        if(e>-1) {
        	String left = input.substring(0, e);
            String right = input.substring(e+1, input.length());
            if(right.length()==0)
            	return false;
        	return isValidExp(right) == true ? isNumber(left) : false;
        } else {
        	return isValidNumber(input);
        }
    }
	
	public static boolean isValidExp(String s) {
		if(s.indexOf('.')> -1)
            return false;
		if(s.length()==1 && (s.indexOf('-') > -1 || s.indexOf('+') > -1))
			return false;
		
		return isValidNumber(s);
	}
	
	public static boolean isValidNumber(String s) {
		// check for invalid chars. at this stage space is not allowed. sign char is allowed only at pos 0
		if(s.indexOf('+')>0 || s.indexOf('-')>0 || s.indexOf(' ')>=0)
            return false;
		
		// check for multiple . position
		if(s.indexOf('.') != s.lastIndexOf('.'))
			return false;
		if(s.charAt(0)=='-' || s.charAt(0)=='+')
			s=s.substring(1);
		if(s.charAt(0)=='.')
			s=s.substring(1);
		
		if(s.length()==0) 
			return false;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) != '.' && !Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
