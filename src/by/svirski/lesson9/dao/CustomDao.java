package by.svirski.lesson9.dao;

import java.util.List;

import by.svirski.lesson9.dao.exception.DaoException;
import by.svirski.lesson9.service.tag.CustomTag;

public interface CustomDao {
	List<String> select(CustomTag tag, String[] parameters) throws DaoException;
}
