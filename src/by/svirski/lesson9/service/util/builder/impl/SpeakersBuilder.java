package by.svirski.lesson9.service.util.builder.impl;

import java.util.ArrayList;

import by.svirski.lesson9.bean.impl.Speakers;
import by.svirski.lesson9.service.util.builder.CustomBuilder;

public class SpeakersBuilder implements CustomBuilder<Speakers> {

	public SpeakersBuilder() {
	}

	@Override
	public Speakers build(String lineOfParameters) {
		ArrayList<String> listOfParams = new ArrayList<String>();
		String[] parsedString = lineOfParameters.substring(lineOfParameters.indexOf(":")).trim().split(",");
		for (String parameter : parsedString) {
			listOfParams.add(parameter.substring(parameter.indexOf("=") + 1));
		}

		Speakers speakers = new Speakers(Integer.parseInt(listOfParams.get(0)), Integer.parseInt(listOfParams.get(1)),
				listOfParams.get(2), Integer.parseInt(listOfParams.get(3)));
		return speakers;
	}

}
