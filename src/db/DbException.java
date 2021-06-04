package db;

// criado para gerar mensagens personalizadas quando houver alguma exception
public class DbException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DbException(String msg) {
		super(msg);
	}
}