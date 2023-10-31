package br.fiap.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.FuncionarioDAO;
import br.fiap.entidade.Cargo;
import br.fiap.entidade.Funcionario;

/**
 * Servlet implementation class CadastroFuncionarioServlet
 */
@WebServlet("/cadastroFuncionario")
public class CadastroFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		Cargo cargo = null;
		int id;
		
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setSalario(Double.parseDouble(request.getParameter("salario")));
		id = Integer.parseInt(request.getParameter("cargo"));
		
		// recuperar o objeto enum a partir de um ID
		for(Cargo c : Cargo.values()) {
			if(c.getId() == id) {
				cargo = c;
			}
		}
		
		funcionario.setCargo(cargo);
		dao.inserir(funcionario);
		
		// redirecionar para a página de cadastro de funcionário
		response.sendRedirect("form/formCadastroFuncionario.jsp");
		
	}

}
