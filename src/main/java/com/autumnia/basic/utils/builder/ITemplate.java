package com.autumnia.basic.utils.builder;

public interface ITemplate {
    public int a = 0;
    public int b = 0;	
	
	public void rate(String target); 
	
	
	final class Fake implements ITemplate {
		public Fake() {}

		@Override
		public void rate(String target) {
			// TODO Auto-generated method stub
			System.out.println( "rate 출력");
			
		}
	}
	
	final class Smart {
		private final ITemplate origin;
		
		public Smart( ITemplate template ) {
			this.origin = template;
		}
		
		public int strToInt(String value)  {
			return Integer.parseInt( value );
		}
	}
}
