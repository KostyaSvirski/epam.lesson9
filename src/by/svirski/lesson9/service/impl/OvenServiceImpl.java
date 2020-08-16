package by.svirski.lesson9.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson9.bean.impl.Oven;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.dao.factory.DaoFactory;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.tag.CustomTag;
import by.svirski.lesson9.util.validator.CustomValidator;
import by.svirski.lesson9.util.validator.impl.ValidatorForParameters;

public class OvenServiceImpl implements CustomService<Oven> {

	public OvenServiceImpl() {
	}

	@Override
	public List<Oven> find(String request) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		CustomDao applience = factory.getApplienceDao();
		String[] parameters = request.trim().split(",");
		CustomValidator validator = new ValidatorForParameters();
		if (validator.validate(parameters)) {
			try {
				List<String> foundList = applience.select(CustomTag.OVEN_TAG, parameters);
				List<Oven> listOfBeans = convertToBeanList(foundList);
				return listOfBeans;
			} catch (DaoException e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			throw new ServiceException("error in validation");
		}
	}

	private List<Oven> convertToBeanList(List<String> foundList) {
		List<Oven> listOfBeans = new ArrayList<Oven>();
		for (String line : foundList) {
			String[] parsedString = line.substring(line.indexOf(":")).trim().split(",");
			ArrayList<String> listOfParams = new ArrayList<String>();
			for (String parameter : parsedString) {
				listOfParams.add(parameter.substring(parameter.indexOf("=") + 1));
			}
			Oven oven = new Oven(Integer.parseInt(listOfParams.get(0)), Integer.parseInt(listOfParams.get(1)),
					Integer.parseInt(listOfParams.get(2)), Double.parseDouble(listOfParams.get(3)),
					Double.parseDouble(listOfParams.get(4)), Double.parseDouble(listOfParams.get(5)));
			listOfBeans.add(oven);
		}
		return listOfBeans;
	}

}
