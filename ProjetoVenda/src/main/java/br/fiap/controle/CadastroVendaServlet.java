package br.fiap.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.FuncionarioDAO;
import br.fiap.dao.VendaDAO;
import br.fiap.entidade.Funcionario;
import br.fiap.entidade.Venda;

/**
 * Servlet implementation class CadastroVendaServlet
 */
@WebServlet("/cadastroVenda")
public class CadastroVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO dao = new FuncionarioDAO();
		VendaDAO daoVenda = new VendaDAO();
		Venda venda = new Venda();
		
		List<Funcionario> lista = dao.listar();		
		int id_funcionario = Integer.parseInt(request.getParameter("funcionario"));
		for(Funcionario f : lista) {
			if(id_funcionario == f.getId()) {
				venda.setFuncionario(f);
			}
		}
		
		double valor = Double.parseDouble(request.getParameter("venda"));
		venda.setValor(valor);
		daoVenda.inserir(venda);
		
		response.sendRedirect("form/formCadastroVenda.jsp");
		
	}

}
