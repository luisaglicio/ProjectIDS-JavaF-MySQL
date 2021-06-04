package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.NotasFaltasDao;
import model.entities.NotasFaltas;

public class NotasFaltasService {

	private NotasFaltasDao dao = DaoFactory.createNotasFaltasDao();
	
	public List<NotasFaltas> findAll() {
		return dao.findAll();
	}
	
	public void saveOrUpdate(NotasFaltas obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(NotasFaltas obj) {
		dao.deleteById(obj.getId());
	}
}