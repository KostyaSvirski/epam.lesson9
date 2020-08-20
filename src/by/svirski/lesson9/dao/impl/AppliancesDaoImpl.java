package by.svirski.lesson9.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.svirski.lesson9.bean.Appliances;
import by.svirski.lesson9.bean.AppliancesTagType;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.service.util.builder.CustomBuilder;

public class AppliancesDaoImpl implements CustomDao {

	private static final String RESOURSE = "appliances";
	private static final String FILE = "file.path";

	public AppliancesDaoImpl() {
	}

	@Override
	public List<? extends Appliances> select(AppliancesTagType tag, String[] parameters) throws DaoException {
		ResourceBundle rb = ResourceBundle.getBundle(RESOURSE);
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get(rb.getString(FILE)));

			List<String> resultList = stream
					.filter(line -> (line.startsWith(tag.getTagName()) && checkLine(parameters, line)))
					.collect(Collectors.toList());
			List<? extends Appliances> listOfBeans = createListOfBeans(tag, resultList);
			return listOfBeans;
		} catch (IOException e) {
			throw new DaoException("file don't exist");
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}

	private List<? extends Appliances> createListOfBeans(AppliancesTagType tag, List<String> resultList) {
		List<Appliances> listOfBeans = new ArrayList<Appliances>();
		CustomBuilder<? extends Appliances> builder = tag.getBuilder();
		for(String line : resultList) {
			listOfBeans.add(builder.build(line));
		}
		return listOfBeans;
	}

	private boolean checkLine(String[] parameters, String line) {
		for (String parameterToCheck : parameters) {
			if (!line.contains(parameterToCheck.toUpperCase())) {
				return false;
			}
		}
		return true;
	}

}
