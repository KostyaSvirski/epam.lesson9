package by.svirski.lesson9.service;

import java.util.List;

import by.svirski.lesson9.service.exception.ServiceException;

public interface CustomService<T> {
	List<T> find(String request) throws ServiceException;
}
