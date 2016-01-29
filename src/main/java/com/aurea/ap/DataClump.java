package com.aurea.ap;

public class DataClump {
    public static class E {	
	public static final int a = 0;
	public static final int b = 1;
	public static final int c = 2;
    }

    
    public static void methodOne(int a, int b, int c){
	
    }

    public static void methodTwo(int a, int b, int c){
	
    }
    
    public static void methodThree(int a, int b, int c){
	
    }
    
    public static void main(char[][] args){ 
	methodOne(E.a, E.b, E.c);
	methodTwo(E.a, E.b, E.c);
	methodThree(E.a, E.b, E.c);
    }
        
}
