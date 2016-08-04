package revista;

import java.util.ArrayList;
import java.util.List;

import com.bsangola.modelos.Permissao;
import com.bsangola.modelos.Usuario;
import com.bsangola.servico.NegocioException;
import com.bsangola.servico.Permissoes;
import com.bsangola.servico.Usuarios;

public class TesteUnitario {

	public static void testePermissao() throws NegocioException {

		Permissao permissao1 = new Permissao();
		Permissao permissao2 = new Permissao();
		Permissao permissao3 = new Permissao();
		Permissao permissao4 = new Permissao();
		//Permissao permissao5 = new Permissao();

		permissao1.setPermissao("Criar");
		permissao2.setPermissao("Visualizar");
		permissao3.setPermissao("Editar");
		permissao4.setPermissao("Apagar");
		//permissao5.setPermissao("Administador");

		Permissoes permissoes = new Permissoes();

		// permissoes.criar(permissao5);
		permissoes.criar(permissao1);
		permissoes.criar(permissao2);
		permissoes.criar(permissao3);
		permissoes.criar(permissao4);

		System.out.println("Criado com sucesso! ");

		// System.out.println(((Permissao)permissoes.buscarPorCodigo(new
		// Long(2))).getPermissao());

		// permissoes.eliminar(permissao , 1L);

		//for (Object string : permissoes.buscarTodos()) {
		//	System.out.println(((Permissao) string).getPermissao());
		//}

	}

	
	public static void testeUsuario() throws NegocioException{
		List<Permissao> lista = new ArrayList<Permissao>();
		for (Object permissao : new Permissoes().buscarTodos()) {
			lista.add((Permissao) permissao);
		}
		Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setPermissoes(lista);
		new Usuarios().criar(usuario);
		System.out.println("Criado com sucesso! ");
	}
	public static void main(String[] args) throws NegocioException {
		
		//testePermissao();
		
		//testeUsuario();
		
		
		//Inicio do que vais colocar no teu c�dgio, Avelino
		//DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:MM");
		//String label = (format.format(Calendar.getInstance().getTime()));
		
		
		//System.out.println(label);
		//Fim. Avelino

	}

}
