package by.svirski.lesson9.service.util.builder.impl;

import java.util.ArrayList;

import by.svirski.lesson9.bean.impl.Oven;
import by.svirski.lesson9.service.util.builder.CustomBuilder;

public class OvenBuilder implements CustomBuilder<Oven> {

	public OvenBuilder() {
	}

	@Override
	public Oven build(String lineOfParameters) {
		ArrayList<String> listOfParams = new ArrayList<String>();
		String[] parsedLine = lineOfParameters.substring(lineOfParameters.indexOf(":")).trim().split(",");
		for (String parameter : parsedLine) {
			listOfParams.add(parameter.substring(parameter.indexOf("=") + 1));
		}
		
		Oven oven = new Oven(Integer.parseInt(listOfParams.get(0)), Integer.parseInt(listOfParams.get(1)),
				Integer.parseInt(listOfParams.get(2)), Double.parseDouble(listOfParams.get(3)),
				Double.parseDouble(listOfParams.get(4)), Double.parseDouble(listOfParams.get(5)));
		return oven;
	}

}
