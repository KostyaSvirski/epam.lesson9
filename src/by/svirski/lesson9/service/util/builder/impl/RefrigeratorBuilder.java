package by.svirski.lesson9.service.util.builder.impl;

import java.util.ArrayList;

import by.svirski.lesson9.bean.impl.Refrigerator;
import by.svirski.lesson9.service.util.builder.CustomBuilder;

public class RefrigeratorBuilder implements CustomBuilder<Refrigerator> {

	public RefrigeratorBuilder() {
	}

	@Override
	public Refrigerator build(String lineOfParameters) {
		ArrayList<String> listOfParams = new ArrayList<String>();
		String[] parsedString = lineOfParameters.substring(lineOfParameters.indexOf(":")).trim().split(",");
		for (String parameter : parsedString) {
			listOfParams.add(parameter.substring(parameter.indexOf("=") + 1));
		}
		
		Refrigerator refrigerator = new Refrigerator(Integer.parseInt(listOfParams.get(0)),
				Integer.parseInt(listOfParams.get(1)), Double.parseDouble(listOfParams.get(2)),
				Double.parseDouble(listOfParams.get(3)), Integer.parseInt(listOfParams.get(4)),
				Integer.parseInt(listOfParams.get(5)));
		return refrigerator;
	}

}
