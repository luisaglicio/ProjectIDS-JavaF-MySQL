package model.dao;

import db.DB;
import model.dao.impl.AlunoDaoJDBC;
import model.dao.impl.NotasFaltasDaoJDBC;

public class DaoFactory {

	public static NotasFaltasDao createNotasFaltasDao() {
		return new NotasFaltasDaoJDBC(DB.getConnection());
	}
	
	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
}