package by.svirski.lesson9.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson9.bean.impl.Refrigerator;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.dao.factory.DaoFactory;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.tag.CustomTag;
import by.svirski.lesson9.util.validator.CustomValidator;
import by.svirski.lesson9.util.validator.impl.ValidatorForParameters;

public class RefrigeratorServiceImpl implements CustomService<Refrigerator> {

	public RefrigeratorServiceImpl() {
	}

	@Override
	public List<Refrigerator> find(String request) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		CustomDao applience = factory.getApplienceDao();
		String[] parameters = request.trim().split(",");
		CustomValidator validator = new ValidatorForParameters();
		if (validator.validate(parameters)) {
			try {
				List<String> foundList = applience.select(CustomTag.REFRIGERATOR_TAG, parameters);
				List<Refrigerator> listOfBeans = convertToBeanList(foundList);
				return listOfBeans;
			} catch (DaoException e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			throw new ServiceException("error in validation");
		}
	}

	private List<Refrigerator> convertToBeanList(List<String> foundList) {
		List<Refrigerator> listOfBeans = new ArrayList<Refrigerator>();
		for (String line : foundList) {
			String[] parsedString = line.substring(line.indexOf(":")).trim().split(",");
			ArrayList<String> listOfParams = new ArrayList<String>();
			for (String parameter : parsedString) {
				listOfParams.add(parameter.substring(parameter.indexOf("=") + 1));
			}
			Refrigerator refrigerator = new Refrigerator(Integer.parseInt(listOfParams.get(0)),
					Integer.parseInt(listOfParams.get(1)), Double.parseDouble(listOfParams.get(2)),
					Double.parseDouble(listOfParams.get(3)), Integer.parseInt(listOfParams.get(4)),
					Integer.parseInt(listOfParams.get(5)));
			listOfBeans.add(refrigerator);
		}
		return listOfBeans;
	}

}
