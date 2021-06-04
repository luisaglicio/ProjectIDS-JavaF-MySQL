package model.dao;

import java.util.List;

import model.entities.Aluno;
import model.entities.NotasFaltas;

public interface NotasFaltasDao {

	void insert(NotasFaltas obj);
	void update(NotasFaltas obj);
	void deleteById(Integer id);
	NotasFaltas findById(Integer id);
	List<NotasFaltas> findAll();
	List<NotasFaltas> findByAluno(Aluno aluno);
}