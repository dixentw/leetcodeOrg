package idv.myleetcode;

/**
 * Hello world!
 *
 */
public class App{
    public boolean parlindrome(String s){
        for(int i=0, j=s.length()-1; i<j; i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public int getSingle(int[] A){
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                int num = A[j];
                if (((num >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result = result | ((count[i] % 3) << i);
        }
        return result;
    }

    public int getSingle2(int[] A){
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for(int i=0; i<A.length; i++){
            twos = twos | (ones & A[i]);
            System.out.println(twos);
            ones = ones ^ A[i];
            System.out.println(ones);
            threes = ~ (twos & ones);
            System.out.println(threes);
            ones = ones & threes;
            twos = twos & threes;
        }
        return ones;
    }

	public String reverse(String s){
		char[] buf = s.toCharArray();
		int start = 0;
		int end = buf.length-1;
		while(start <= end){
			char tmp = buf[start];
			buf[start] = buf[end];
			buf[end] = tmp;
			start++;
			end--;
		}
		return new String(buf);
	}
}
