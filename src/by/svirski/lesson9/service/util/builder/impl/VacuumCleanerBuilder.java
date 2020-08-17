package by.svirski.lesson9.service.util.builder.impl;

import java.util.ArrayList;

import by.svirski.lesson9.bean.impl.VacuumCleaner;
import by.svirski.lesson9.service.util.builder.CustomBuilder;

public class VacuumCleanerBuilder implements CustomBuilder<VacuumCleaner> {

	public VacuumCleanerBuilder() {
	}

	@Override
	public VacuumCleaner build(String lineOfParameters) {
		ArrayList<String> listOfParams = new ArrayList<String>();
		String[] parsedString = lineOfParameters.substring(lineOfParameters.indexOf(":")).trim().split(",");
		for (String parameterToParse : parsedString) {
			listOfParams.add(parameterToParse.substring(parameterToParse.indexOf("=") + 1));
		}

		VacuumCleaner vacuumCleaner = new VacuumCleaner(Integer.parseInt(listOfParams.get(0)), listOfParams.get(1),
				listOfParams.get(2), listOfParams.get(3), Integer.parseInt(listOfParams.get(4)),
				Integer.parseInt(listOfParams.get(5)));
		return vacuumCleaner;
	}

}
