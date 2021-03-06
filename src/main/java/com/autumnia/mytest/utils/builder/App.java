package com.autumnia.mytest.utils.builder;

public class App {

	public static void main(String[] args) {
		
		ITemplate template = new CTemplate.Builder()
				.setA(1)
				.setB(2)
				.build();

		System.out.println( template.toString() ) ;
		
		ITemplate template2 = new ITemplate.Fake( );
		template2.rate("뭐지");
		
		int result = new ITemplate.Smart( template  )
				.strToInt("888");
		System.out.println( result );
	}
}
