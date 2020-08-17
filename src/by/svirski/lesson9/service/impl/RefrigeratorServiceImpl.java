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
import by.svirski.lesson9.service.util.builder.CustomBuilder;
import by.svirski.lesson9.service.util.builder.factory.CustomBuilderFactory;
import by.svirski.lesson9.service.util.validator.CustomValidator;
import by.svirski.lesson9.service.util.validator.impl.ValidatorForParameters;

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
			CustomBuilderFactory fabric = CustomBuilderFactory.getInstance();
			CustomBuilder<Refrigerator> builder = fabric.getRefrigaratorBuilder();
			try {
				List<String> foundList = applience.select(CustomTag.REFRIGERATOR_TAG, parameters);
				List<Refrigerator> listOfBeans = new ArrayList<Refrigerator>();
				for (String line : foundList) {
					listOfBeans.add(builder.build(line));
				}
				return listOfBeans;
			} catch (DaoException e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			throw new ServiceException("error in validation");
		}
	}

}
