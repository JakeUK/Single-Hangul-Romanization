package hangulromanization;

import java.io.UnsupportedEncodingException;

public class Main {

	private final int base = 44032;
	private final int const1 = 17;
	private final int vowel = 19;
	private final int const2 = 27;
	
	private final String[] const1_r = {"g", "kk", "n", "d", "tt", "r", "m", "b", "pp", "s", "ss", "", "j", "jj", "ch", "k", "t", "p", "h"};
	private final String[] vowel_r = {"a", "ae", "ya", "yae", "eo", "e", "yeo", "ye", "o", "wa", "wae", "oe", "yo", "u", "wo", "we", "wi", "yu", "eu", "ui", "i"};
	private final String[] const2_r = {"", "k", "k", "ks", "n", "nj", "nh", "t", "l", "lg", "lm", "lb", "ls", "lt", "lp", "lh", "m", "p", "bs", "t", "t", "ng", "t", "t", "k", "t", "p", "t"};
	
	public Main() throws UnsupportedEncodingException {
		FUtil.clearFile();
		int row = 1;
		
		for(int c1 = 0; c1 <= const1; c1++) {
			for(int v = 0; v <= vowel; v++) {
				for(int c2 = 0; c2 <= const2; c2++) {
					
					int uniDec = (c1 * 588) + (v * 28) + (c2) + base;
					String hexS = Integer.toHexString(uniDec);
					String hangul = new String(hexStringToByteArray(hexS), "UTF-16");
					//System.out.println(hangul);
					
					
					String romanized = const1_r[c1] + vowel_r[v] + const2_r[c2];
					
					FUtil.append("" + row + "," + hangul + "," + romanized + "\n");
					row++;
					
				}
			}
		}
		
		FUtil.write();
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public static void main(String args[]) throws UnsupportedEncodingException {
		Main m = new Main();
	}
	
}
