package by.svirski.lesson9.view;

import by.svirski.lesson9.controller.invoker.CustomInvoker;

public class View {

	public View() {
	}

	public static void main(String[] args) {
		CustomInvoker invoker = CustomInvoker.getInstance();
		String result = invoker.invoke("Refrigerator:");
		System.out.println(result);
	}

}
