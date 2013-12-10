package de.szut.emp.dataLayer.dataAccessObjects;

import java.util.List;

import de.szut.emp.businessObjects.IEmailContact;

public interface IEmailContactDao {

	public void create(IEmailContact emailContact);

	public void delete(IEmailContact emailContact);

	public IEmailContact first();

	public IEmailContact last();

	public IEmailContact next(IEmailContact currentEmailContact);

	public IEmailContact previous(IEmailContact currentEmailContact);

	public void save(IEmailContact emailContact);

	public List<IEmailContact> select();

	public IEmailContact select(int id);

}
