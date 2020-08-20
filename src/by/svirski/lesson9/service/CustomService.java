package by.svirski.lesson9.service;

import java.util.List;

import by.svirski.lesson9.bean.Appliances;
import by.svirski.lesson9.bean.AppliancesTagType;
import by.svirski.lesson9.service.exception.ServiceException;

public interface CustomService {
	List<? extends Appliances> find(AppliancesTagType tag, String request) throws ServiceException;
}
