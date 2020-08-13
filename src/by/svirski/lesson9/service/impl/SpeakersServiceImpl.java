package by.svirski.lesson9.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson9.bean.impl.Speakers;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.dao.factory.DaoFactory;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.tag.CustomTag;

public class SpeakersServiceImpl implements CustomService<Speakers> {

	public SpeakersServiceImpl() {
	}

	@Override
	public List<Speakers> find(String request) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		CustomDao applience = factory.getApplienceDao();
		String[] parameters = request.trim().split(",");
		try {
			List<String> foundList = applience.select(CustomTag.SPEAKERS_TAG, parameters);
			List<Speakers> listOfBeans = convertToBeanList(foundList);
			return listOfBeans;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	private List<Speakers> convertToBeanList(List<String> foundList) {
		List<Speakers> listOfBeans = new ArrayList<Speakers>();
		for (String line : foundList) {
			String[] parsedString = line.substring(line.indexOf(":")).trim().split(",");
			ArrayList<String> listOfParams = new ArrayList<String>();
			for (String parameter : parsedString) {
				listOfParams.add(parameter.substring(parameter.indexOf("=") + 1));
			}
			Speakers speakers = new Speakers(Integer.parseInt(listOfParams.get(0)),
					Integer.parseInt(listOfParams.get(1)), Double.parseDouble(listOfParams.get(2)),
					Double.parseDouble(listOfParams.get(3)), Integer.parseInt(listOfParams.get(4)));
			listOfBeans.add(speakers);
		}
		return listOfBeans;
	}

}
