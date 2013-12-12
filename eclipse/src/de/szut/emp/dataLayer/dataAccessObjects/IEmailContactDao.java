package de.szut.emp.dataLayer.dataAccessObjects;

import java.util.List;

import de.szut.emp.businessObjects.IEmailContact;
import de.szut.emp.exceptions.NoEmailContactFoundException;
import de.szut.emp.exceptions.NoNextEmailContactFoundException;
import de.szut.emp.exceptions.NoPreviousEmailFoundException;

public interface IEmailContactDao {

	public void create(IEmailContact emailContact);

	public void delete(IEmailContact emailContact);

	public IEmailContact first() throws NoEmailContactFoundException;

	public IEmailContact last() throws NoEmailContactFoundException;

	public IEmailContact next(IEmailContact currentEmailContact) throws NoNextEmailContactFoundException;

	public IEmailContact previous(IEmailContact currentEmailContact) throws NoPreviousEmailFoundException;

	public void save(IEmailContact emailContact);

	public List<IEmailContact> select();

	public IEmailContact select(int id) throws NoEmailContactFoundException;

}
