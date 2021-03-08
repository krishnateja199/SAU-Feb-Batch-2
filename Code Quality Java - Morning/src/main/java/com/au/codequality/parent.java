package com.au.codequality;

public class parent {
	int age;
	String name;
	String city = "city";
	String str = "";
	static String state = "Hyderabad   Secundrabad";
	int count = 0;

	public static void main(String[] args) throws CloneNotSupportedException {
		parent object = new parent();
		Object app = object.printClass(object.getClass());
		app.getClass();
		try {
			int n = object.getNum();
			System.err.println(n);
		} 
		catch (ArithmeticException e) {
			e.getMessage();
		}
		Object o = object.clone();
		System.err.println(o);
	}

	private int getNum() {
		count++;
		int a = 0;
		int b;
		if (a == 0) {
			b = 0;
		} else if (a == 1) {
			b = 1;
		} else if (a == 5) {
			b = 5;
		} else {
			b = 12;
		}
		return b;
	}
	private Class<? extends parent> printClass(Class<? extends parent> app) {
		int[] arrayInt = new int[5];
		for (int i = 0; i < arrayInt.length; i++) {
			if (i == 2)
				break;
		}
		return app;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		super.clone();
		int beginIndex = 1;
		char char1 = 'a';
		String init = "human is a livingThing!";
		String changed = init.replace("Human is", "It's");
		changed = changed.replace("\\.\\.\\.", ";");
		return(changed.indexOf(char1, beginIndex));
	}

}
