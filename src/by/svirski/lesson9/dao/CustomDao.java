package by.svirski.lesson9.dao;

import java.util.List;

import by.svirski.lesson9.bean.Appliances;
import by.svirski.lesson9.bean.AppliancesTagType;
import by.svirski.lesson9.dao.exception.DaoException;

public interface CustomDao {
	List<? extends Appliances> select(AppliancesTagType tag, String[] parameters) throws DaoException;
}
