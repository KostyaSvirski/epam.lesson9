package by.svirski.lesson9.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson9.bean.impl.Laptop;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.dao.factory.DaoFactory;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.tag.CustomTag;

public class LaptopServiceImpl implements CustomService<Laptop> {

	public LaptopServiceImpl() {
	}

	@Override
	public List<Laptop> find(String request) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		CustomDao applience = factory.getApplienceDao();
		String[] parameters = request.trim().split(",");
		try {
			List<String> foundList = applience.select(CustomTag.LAPTOP_TAG, parameters);
			List<Laptop> listOfBeans = convertToBeanList(foundList);
			return listOfBeans;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	private List<Laptop> convertToBeanList(List<String> foundList) {
		List<Laptop> listOfBeans = new ArrayList<Laptop>();
		for (String foundString : foundList) {
			String[] parsedString = foundString.substring(foundString.indexOf(":")).trim().split(",");
			ArrayList<String> listOfParams = new ArrayList<String>();
			for (String parameterToParse : parsedString) {
				listOfParams.add(parameterToParse.substring(parameterToParse.indexOf("=") + 1));
			}
			Laptop laptop = new Laptop(Integer.parseInt(listOfParams.get(0)), listOfParams.get(1),
					Integer.parseInt(listOfParams.get(2)), Integer.parseInt(listOfParams.get(3)),
					Double.parseDouble(listOfParams.get(4)), Integer.parseInt(listOfParams.get(5)));
			listOfBeans.add(laptop);
		}
		return listOfBeans;
	}

}
