package by.svirski.lesson9.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson9.bean.impl.TabletPC;
import by.svirski.lesson9.dao.CustomDao;
import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.dao.factory.DaoFactory;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.tag.CustomTag;

public class TabletPCServiceImpl implements CustomService<TabletPC> {

	public TabletPCServiceImpl() {
	}

	@Override
	public List<TabletPC> find(String request) throws ServiceException {
		DaoFactory factory = DaoFactory.getInstance();
		CustomDao applience = factory.getApplienceDao();
		String[] parameters = request.trim().split(",");
		try {
			List<String> foundList = applience.select(CustomTag.TABLET_PC_TAG, parameters);
			List<TabletPC> listOfBeans = convertToBeanList(foundList);
			return listOfBeans;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	private List<TabletPC> convertToBeanList(List<String> foundList) {
		List<TabletPC> listOfBeans = new ArrayList<TabletPC>();
		for (String foundString : foundList) {
			String[] parsedString = foundString.substring(foundString.indexOf(":")).trim().split(",");
			ArrayList<String> listOfParams = new ArrayList<String>();
			for (String parameterToParse : parsedString) {
				listOfParams.add(parameterToParse.substring(parameterToParse.indexOf("=") + 1));
			}
			TabletPC tabletPC = new TabletPC(Integer.parseInt(listOfParams.get(0)),
					Integer.parseInt(listOfParams.get(1)), Integer.parseInt(listOfParams.get(2)),
					Integer.parseInt(listOfParams.get(3)), listOfParams.get(4));
			listOfBeans.add(tabletPC);
		}
		return listOfBeans;
	}
}
