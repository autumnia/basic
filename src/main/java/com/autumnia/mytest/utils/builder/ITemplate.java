package com.autumnia.mytest.utils.builder;

import lombok.Data;

public interface ITemplate {
	public void rate(String target);
	
	
	final class Fake implements ITemplate {
		public Fake() {}

		@Override
		public void rate(String target) {
			// TODO Auto-generated method stub
			System.out.println( String.format("Fake rate: %s", target));
			
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
