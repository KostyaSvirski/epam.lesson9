package by.svirski.lesson9.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.service.tag.CustomTag;

public class ApplienceDaoImpl implements CustomDao {

	public ApplienceDaoImpl() {
	}

	@Override
	public List<String> select(CustomTag tag, String[] parameters) throws DaoException {
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get("D:\\java\\EPAM\\svirski2\\task9\\appliances_db.txt"));
			List<String> resultList = stream
					.filter(line -> (line.startsWith(tag.getTagName()) && checkLine(parameters, line)))
					.collect(Collectors.toList());
			return resultList;
		} catch (IOException e) {
			throw new DaoException(e.getMessage());
		} finally {
			stream.close();
		}
	}

	private boolean checkLine(String[] parameters, String line) {
		for (String parameterToCheck : parameters) {
			if (!line.contains(parameterToCheck)) {
				return false;
			}
		}
		return true;
	}

}
