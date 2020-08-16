package by.svirski.lesson9.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson9.bean.impl.VacuumCleaner;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.dao.factory.DaoFactory;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.tag.CustomTag;
import by.svirski.lesson9.util.validator.CustomValidator;
import by.svirski.lesson9.util.validator.impl.ValidatorForParameters;

public class VacuumCleanerServiceImpl implements CustomService<VacuumCleaner> {

	public VacuumCleanerServiceImpl() {
	}

	@Override
	public List<VacuumCleaner> find(String request) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		CustomDao applience = factory.getApplienceDao();
		String[] parameters = request.trim().split(",");
		CustomValidator validator = new ValidatorForParameters();
		if (validator.validate(parameters)) {
			try {
				List<String> foundList = applience.select(CustomTag.VACUUM_CLEANER_TAG, parameters);
				List<VacuumCleaner> listOfBeans = convertToBeanList(foundList);
				return listOfBeans;
			} catch (DaoException e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			throw new ServiceException("error in validation");
		}
	}

	private List<VacuumCleaner> convertToBeanList(List<String> foundList) {
		List<VacuumCleaner> listOfBeans = new ArrayList<VacuumCleaner>();
		for (String foundString : foundList) {
			String[] parsedString = foundString.substring(foundString.indexOf(":")).trim().split(",");
			ArrayList<String> listOfParams = new ArrayList<String>();
			for (String parameterToParse : parsedString) {
				listOfParams.add(parameterToParse.substring(parameterToParse.indexOf("=") + 1));
			}
			VacuumCleaner vacuumCleaner = new VacuumCleaner(Integer.parseInt(listOfParams.get(0)), listOfParams.get(1),
					listOfParams.get(2), listOfParams.get(3), Integer.parseInt(listOfParams.get(4)),
					Integer.parseInt(listOfParams.get(5)));
			listOfBeans.add(vacuumCleaner);
		}
		return listOfBeans;
	}

}
