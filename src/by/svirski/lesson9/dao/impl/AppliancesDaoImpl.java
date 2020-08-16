package by.svirski.lesson9.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.service.tag.CustomTag;

public class AppliancesDaoImpl implements CustomDao {

	private static final String RESOURSE = "appliances";
	private static final String FILE = "file.path";

	public AppliancesDaoImpl() {
	}

	@Override
	public List<String> select(CustomTag tag, String[] parameters) throws DaoException {
		ResourceBundle rb = ResourceBundle.getBundle(RESOURSE);
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get(rb.getString(FILE)));

			List<String> resultList = stream
					.filter(line -> (line.startsWith(tag.getTagName()) && checkLine(parameters, line)))
					.collect(Collectors.toList());
			return resultList;
		} catch (IOException e) {
			throw new DaoException(e.getMessage());
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
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
