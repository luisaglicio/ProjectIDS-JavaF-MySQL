package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.mysql.jdbc.Statement;

import db.DB;
import db.DbException;
import model.dao.NotasFaltasDao;
import model.entities.Aluno;
import model.entities.NotasFaltas;


public class NotasFaltasDaoJDBC implements NotasFaltasDao {

	private Connection conn;
	
	public NotasFaltasDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(NotasFaltas obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO notas "
					+"(Matricula_Id, "
					+ "Nota_sala_aula_B1, "		
					+ "Nota_tarefas_B1, "
					+ "Nota_trabalho_B1, "
					+ "Nota_prova_B1, "
					+ "Nota_sala_aula_B2, "
					+ "Nota_tarefas_B2, "
					+ "Nota_trabalho_B2, "
					+ "Nota_prova_B2, "
					+ "Nota_sala_aula_B3, "
					+ "Nota_tarefas_B3, "
					+ "Nota_trabalho_B3, "
					+ "Nota_prova_B3, "
					+ "Nota_sala_aula_B4, "
					+ "Nota_tarefas_B4, "
					+ "Nota_trabalho_B4, "
					+ "Nota_prova_B4, "
					+ "Faltas_B1, "
					+ "Faltas_B2, "
					+ "Faltas_B3, "
					+ "Faltas_B4, "
					+ "Total_faltas, "
					+ "Situacao_aluno) "
					+"VALUES "
					+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getAluno().getId());
			st.setDouble(2, obj.getNotaSalaAulaB1());
			st.setDouble(3, obj.getNotaTarefasB1());
			st.setDouble(4, obj.getNotaTrabalhoB1());
			st.setDouble(5, obj.getNotaProvaB1());
			
			st.setDouble(6, obj.getNotaSalaAulaB2());
			st.setDouble(7, obj.getNotaTarefasB2());
			st.setDouble(8, obj.getNotaTrabalhoB2());
			st.setDouble(9, obj.getNotaProvaB2());
			
			st.setDouble(10, obj.getNotaSalaAulaB3());
			st.setDouble(11, obj.getNotaTarefasB3());
			st.setDouble(12, obj.getNotaTrabalhoB3());
			st.setDouble(13, obj.getNotaProvaB3());
			
			st.setDouble(14, obj.getNotaSalaAulaB4());
			st.setDouble(15, obj.getNotaTarefasB4());
			st.setDouble(16, obj.getNotaTrabalhoB4());
			st.setDouble(17, obj.getNotaProvaB4());
			
			st.setInt(18, obj.getFaltasB1());
			st.setInt(19, obj.getFaltasB2());
			st.setInt(20, obj.getFaltasB3());
			st.setInt(21, obj.getFaltasB4());
			st.setInt(22, obj.totalFaltas());
			
			st.setString(23, obj.situacaoAluno());
				
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(NotasFaltas obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE notas "
					+ "SET "
					+ "Faltas_B1 = ?, Nota_sala_aula_B1 = ?, Nota_tarefas_B1 = ?, Nota_trabalho_B1 = ?, Nota_prova_B1 = ? "
					+ "Faltas_B2 = ?, Nota_sala_aula_B2 = ?, Nota_tarefas_B2 = ?, Nota_trabalho_B2 = ?, Nota_prova_B2 = ? "
					+ "Faltas_B3 = ?, Nota_sala_aula_B3 = ?, Nota_tarefas_B3 = ?, Nota_trabalho_B3 = ?, Nota_prova_B3 = ? "
					+ "Faltas_B4 = ?, Nota_sala_aula_B4 = ?, Nota_tarefas_B4 = ?, Nota_trabalho_B4 = ?, Nota_prova_B4 = ? "
					+ "WHERE Matricula_Id = ?");
			
			st.setInt(1, obj.getAluno().getId());
			st.setDouble(2, obj.getNotaSalaAulaB1());
			st.setDouble(3, obj.getNotaTarefasB1());
			st.setDouble(4, obj.getNotaTrabalhoB1());
			st.setDouble(5, obj.getNotaProvaB1());
			
			st.setDouble(6, obj.getNotaSalaAulaB2());
			st.setDouble(7, obj.getNotaTarefasB2());
			st.setDouble(8, obj.getNotaTrabalhoB2());
			st.setDouble(9, obj.getNotaProvaB2());
			
			st.setDouble(10, obj.getNotaSalaAulaB3());
			st.setDouble(11, obj.getNotaTarefasB3());
			st.setDouble(12, obj.getNotaTrabalhoB3());
			st.setDouble(13, obj.getNotaProvaB3());
			
			st.setDouble(14, obj.getNotaSalaAulaB4());
			st.setDouble(15, obj.getNotaTarefasB4());
			st.setDouble(16, obj.getNotaTrabalhoB4());
			st.setDouble(17, obj.getNotaProvaB4());
			
			st.setInt(18, obj.getFaltasB1());
			st.setInt(19, obj.getFaltasB2());
			st.setInt(20, obj.getFaltasB3());
			st.setInt(21, obj.getFaltasB4());
			st.setInt(22, obj.totalFaltas());
			
			st.setString(23, obj.situacaoAluno());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM notas WHERE Matricula_Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public NotasFaltas findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT notas.*,aluno.Nome_aluno as NotaAluno "
					+ "FROM notas INNER JOIN aluno "
					+ "ON notas.Matricula_Id = aluno.Matricula_aluno "
					+ "ORDER BY aluno.Matricula_aluno ");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Aluno dep = instantiateAluno(rs);
				NotasFaltas obj = instantiateNotasFaltas(rs, dep);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private NotasFaltas instantiateNotasFaltas(ResultSet rs, Aluno dep) throws SQLException {
		NotasFaltas obj = new NotasFaltas();
		obj.setId(rs.getInt("Matricula_Id"));
		//obj.setId(rs.getInt("Id"));
		obj.setNotaSalaAulaB1(rs.getDouble("Nota_sala_aula_B1"));
		obj.setNotaSalaAulaB2(rs.getDouble("Nota_sala_aula_B2"));
		obj.setNotaSalaAulaB3(rs.getDouble("Nota_sala_aula_B3"));
		obj.setNotaSalaAulaB4(rs.getDouble("Nota_sala_aula_B4"));
		
		obj.setNotaTarefasB1(rs.getDouble("Nota_tarefas_B1"));
		obj.setNotaTarefasB2(rs.getDouble("Nota_tarefas_B2"));
		obj.setNotaTarefasB3(rs.getDouble("Nota_tarefas_B3"));
		obj.setNotaTarefasB4(rs.getDouble("Nota_tarefas_B4"));
		
		obj.setNotaTrabalhoB1(rs.getDouble("Nota_trabalho_B1"));
		obj.setNotaTrabalhoB2(rs.getDouble("Nota_trabalho_B2"));
		obj.setNotaTrabalhoB3(rs.getDouble("Nota_trabalho_B3"));
		obj.setNotaTrabalhoB4(rs.getDouble("Nota_trabalho_B4"));
		
		obj.setNotaProvaB1(rs.getDouble("Nota_prova_B1"));
		obj.setNotaProvaB2(rs.getDouble("Nota_prova_B2"));
		obj.setNotaProvaB3(rs.getDouble("Nota_prova_B3"));
		obj.setNotaProvaB4(rs.getDouble("Nota_prova_B4"));
		
		obj.setFaltasB1(rs.getInt("Faltas_b1"));
		obj.setFaltasB2(rs.getInt("Faltas_b2"));
		obj.setFaltasB3(rs.getInt("Faltas_b3"));
		obj.setFaltasB4(rs.getInt("Faltas_b4"));
		
		
		obj.setTotalFaltas(obj.totalFaltas());
		obj.setSituacaoAluno(obj.situacaoAluno());;
		obj.setAluno(dep);
		
		return obj;
	}

	private Aluno instantiateAluno(ResultSet rs) throws SQLException {
		Aluno dep = new Aluno();
		dep.setId(rs.getInt("Matricula_Id"));
		dep.setName(rs.getString("NotaAluno"));
		return dep;
	}

	@Override
	public List<NotasFaltas> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT notas.*,aluno.Nome_aluno as NotaAluno "
					+ "FROM notas "
					+ "INNER JOIN aluno "
					+ "ON notas.Matricula_Id = aluno.Matricula_aluno "
					+ "ORDER BY aluno.Matricula_aluno ");
			
			rs = st.executeQuery();
			
			List<NotasFaltas> list = new ArrayList<>();
			Map<Integer, Aluno> map = new HashMap<>();
			
			while (rs.next()) {
				
				Aluno dep = map.get(rs.getInt("Matricula_Id"));
				
				if (dep == null) {
					dep = instantiateAluno(rs);
					map.put(rs.getInt("Matricula_Id"), dep);
				}
				
				NotasFaltas obj = instantiateNotasFaltas(rs, dep);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<NotasFaltas> findByAluno(Aluno aluno) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT notas.*, aluno.Nome_aluno "
					+ "FROM notas "
					+ "INNER JOIN aluno "
					+ "ON notas.Matricula_Id = aluno.Matricula_aluno "
					+ "ORDER BY aluno.Matricula_aluno ");
			
			st.setInt(1, aluno.getId());
			
			rs = st.executeQuery();
			
			List<NotasFaltas> list = new ArrayList<>();
			Map<Integer, Aluno> map = new HashMap<>();
			
			while (rs.next()) {
				
				Aluno dep = map.get(rs.getInt("Matricula_Id"));
				
				if (dep == null) {
					dep = instantiateAluno(rs);
					map.put(rs.getInt("Matricula_Id"), dep);
				}
				
				NotasFaltas obj = instantiateNotasFaltas(rs, dep);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}