package com.autumnia.basic.utils.string;

public class StringPefomance {
	private static final String TEXT = "0123456789" ;
	
	public static float basicString () 	{
		String result = "";
		
		long startTime = System.currentTimeMillis();
		for ( int i=0; i<100000; i++) {
			result += TEXT;
		}
		long endTime = System.currentTimeMillis();
		
		float elapseTime = (endTime-startTime)/1000.0f;
		
		return elapseTime;
		
	}

	public static float stringBuffer() 	{
		StringBuffer sb = new StringBuffer(10000000);  // 쓰레드 동기화가 필요한 곳
		
		long startTime = System.currentTimeMillis();
		for ( int i=0; i<1000000; i++) {
			sb.append(TEXT);
		}
		long endTime = System.currentTimeMillis();
		
		float elapseTime = (endTime-startTime)/1000.0f;
		
		sb.setLength(0);
		sb = null;
		
		return elapseTime;
	}	
	
	public static float stringBuilder() 	{
		StringBuilder sb = new StringBuilder(10000000);
		
		long startTime = System.currentTimeMillis();
		for ( int i=0; i<1000000; i++) {
			sb.append(TEXT);
		}
		long endTime = System.currentTimeMillis();
		
		float elapseTime = (endTime-startTime)/1000.0f;
		
		sb.setLength(0);
		sb = null;
		
		return elapseTime;
	}		
	
	public static void main(String[] args) 	{
		// TODO Auto-generated method stub
		
		float result = basicString ();
		System.out.println( " basicString  실행시간(초): " + result );
		
		result = stringBuffer();
		System.out.println( " test2 실행시간(초): " + result );
		
		result = stringBuilder();
		System.out.println( " test3 실행시간(초): " + result );

	}

}
