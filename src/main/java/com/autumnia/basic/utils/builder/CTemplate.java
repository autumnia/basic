package com.autumnia.basic.utils.builder;

/**
 * @author autumn
 *
 */
public class CTemplate implements ITemplate {
	private int value;
	private int a = 0;
	private int b = 0;

	@Override
	public String toString() {
		return "CTemplate [value=" + value + ", a=" + a + ", b=" + b + "]";
	}	
	
	@Override
	public void rate(String target) {
		// TODO Auto-generated method stub
		
	}

	// #######################################################
	// constructor
	// #######################################################
	public CTemplate(float value) {
		this( (int)value);
	}		
	
	public CTemplate(String value) {
		this( CTemplate.parse( value ) );
	}	
	
	public CTemplate(int value) {
		// 
		this.value = value;
	}
	
	// #######################################################
	// builder
	// #######################################################	
	final static class Builder {
        private int a = 0;
        private int b = 0;

        public Builder() { }

        public Builder setA(int v) {
            a = v;
            return this;
        }

        public Builder setB(int v) {
            b = v;
            return this;
        }
        
        public CTemplate build() {
            return new CTemplate(this);
        }     
	}	
	
	private CTemplate(Builder builder) {
	    a = builder.a;
	    b = builder.b;
	}	
	

	// #######################################################
	// Utility 
	// #######################################################
	public int getValue() {
		return this.value;
	}
	
	public static int parse(String value)  {
		return Integer.parseInt( value );
	}
	
	
	
}
