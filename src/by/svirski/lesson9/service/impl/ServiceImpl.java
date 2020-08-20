package by.svirski.lesson9.service.impl;

import java.util.List;

import by.svirski.lesson9.bean.Appliances;
import by.svirski.lesson9.bean.AppliancesTagType;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.dao.factory.DaoFactory;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.util.validator.CustomValidator;
import by.svirski.lesson9.service.util.validator.impl.ValidatorForParameters;

public class ServiceImpl implements CustomService {

	private static final String DELIMETER = ",";

	public ServiceImpl() {
	}

	@Override
	public List<? extends Appliances> find(AppliancesTagType tag, String request) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		CustomDao applience = factory.getApplienceDao();
		String[] parameters = request.trim().split(DELIMETER);
		CustomValidator validator = new ValidatorForParameters();
		if (validator.validate(parameters)) {
			try {
				List<? extends Appliances> foundList = applience.select(tag, parameters);
				return foundList;
			} catch (DaoException e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			throw new ServiceException("error in validation parameters");
		}
	}

}
