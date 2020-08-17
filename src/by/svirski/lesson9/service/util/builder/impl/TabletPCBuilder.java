package by.svirski.lesson9.service.util.builder.impl;

import java.util.ArrayList;

import by.svirski.lesson9.bean.impl.TabletPC;
import by.svirski.lesson9.service.util.builder.CustomBuilder;

public class TabletPCBuilder implements CustomBuilder<TabletPC> {

	public TabletPCBuilder() {
	}

	@Override
	public TabletPC build(String lineOfParameters) {
		ArrayList<String> listOfParams = new ArrayList<String>();
		String[] parsedString = lineOfParameters.substring(lineOfParameters.indexOf(":")).trim().split(",");
		for (String parameterToParse : parsedString) {
			listOfParams.add(parameterToParse.substring(parameterToParse.indexOf("=") + 1));
		}
		
		TabletPC tabletPC = new TabletPC(Integer.parseInt(listOfParams.get(0)), Integer.parseInt(listOfParams.get(1)),
				Integer.parseInt(listOfParams.get(2)), Integer.parseInt(listOfParams.get(3)), listOfParams.get(4));
		return tabletPC;
	}

}
