package by.svirski.lesson9.view;

import by.svirski.lesson9.controller.invoker.CustomInvoker;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		CustomInvoker invoker = CustomInvoker.getInstance();
		String result = invoker.invoke("Refrigerator:");
		System.out.println(result);
	}

}
