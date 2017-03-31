package idv.line;

import java.util.*;
import java.math.BigInteger;

public class Solution{
	public BigInteger fib(int n){
		if(n==0){
			return BigInteger.ZERO;
		}
		if(n==1){
			return BigInteger.ONE;
		}
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		for(int i=1; i<n; i++){
			BigInteger tmp = b;
			b = a.add(b);
			a = tmp;
		}
		return b;
	}

}
