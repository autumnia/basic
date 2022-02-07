package com.autumnia.mytest.utils.singletone;

public class COne {
	public static  COne _instance = new COne();

//	private COne() {};
	
	public static COne getInstance()
	{
		if ( null == _instance )
			_instance = new COne();

		return _instance;
	}

	public String showData() {
		return this.getClass() + ":: showData() 뭐꼬" ;
			
	}

	public static void main(String[] args) {
		COne one = COne.getInstance();


		System.out.println( one.showData() );

		String className = new Object(){}.getClass().toString();
		String methodName = new Object(){}.getClass().getEnclosingMethod().toString();
		System.out.println( className );
		System.out.println( methodName );
	}
}
