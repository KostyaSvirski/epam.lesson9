package by.svirski.lesson9.view;

import by.svirski.lesson9.controller.invoker.CustomInvoker;

public class AppMain {

	public AppMain() {
	}

	public static void main(String[] args) {
		CustomInvoker invoker = CustomInvoker.getInstance();
		String result = invoker.invoke("VacuumCleaner:POWER_CONSUMPTION=90 ");
		System.out.println(result);
	}

}
