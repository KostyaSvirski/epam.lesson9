package by.svirski.lesson9.service.util.builder.impl;

import java.util.ArrayList;

import by.svirski.lesson9.bean.impl.Laptop;
import by.svirski.lesson9.service.util.builder.CustomBuilder;

public class LaptopBuilder implements CustomBuilder<Laptop> {

	public LaptopBuilder() {
	}

	@Override
	public Laptop build(String lineOfParameters) {
		ArrayList<String> listOfParams = new ArrayList<String>();
		String[] parsedLine = lineOfParameters.substring(lineOfParameters.indexOf(":")).trim().split(",");
		for (String parameterToParse : parsedLine) {
			listOfParams.add(parameterToParse.substring(parameterToParse.indexOf("=") + 1));
		}
		
		Laptop laptop = new Laptop(Double.parseDouble(listOfParams.get(0)), listOfParams.get(1),
				Integer.parseInt(listOfParams.get(2)), Integer.parseInt(listOfParams.get(3)),
				Double.parseDouble(listOfParams.get(4)), Integer.parseInt(listOfParams.get(5)));
		return laptop;
	}

}
