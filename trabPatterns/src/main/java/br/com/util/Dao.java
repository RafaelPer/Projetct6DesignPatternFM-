package br.com.util;

import java.util.List;

public interface Dao {
	
	public void insert(Object o, TipoConexao tc);
	public void update(Object o, TipoConexao tc);
	public void delete(Integer i, TipoConexao tc);
	public Object select(Integer i, TipoConexao tc);
	public List select(TipoConexao tc);
}
