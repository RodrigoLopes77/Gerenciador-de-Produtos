package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;




@WebServlet("/atualizaProduto.do")
public class AtualizaProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProdutoService produtoService = new ProdutoService(); 
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoService produtoService = new ProdutoService(); 
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Produto produto = produtoService.consultarProduto(codigo);
				
				
				response.setContentType("text/html");
				
				
				PrintWriter saida = response.getWriter();
				
				saida.println("<form action='atualizaProduto.do' method='post'>");
				saida.println("<table>");
				saida.println("C�digo: " + produto.getCodigo());
				saida.println("<tr><td></td><td><input type=\"hidden\" name='codigo' value='"
								+ produto.getCodigo() + "'/></td></tr>");
				saida.println("<tr><td>Nome:</td><td>");
				saida.println("<input type='text' name='nome' value='" 
								+ produto.getNome() + "'/></td></tr>");
				saida.println("<tr><td>Descricao:</td><td>");
				saida.println("<input type='text' name='descricao' value='" 
								+ produto.getDescricao() + "'/></td></tr>");
				saida.println("<tr><td>Valor:</td><td>");
				saida.println("<input type='text' name='valor' value='"
								+ produto.getValor() + "'/></td></tr> ");
				saida.println("<tr><td>Estoque:</td><td>");
				saida.println("<input type='text' name='estoque' value='"
								+ produto.getEstoque() + "'/></td></tr>");
				saida.println("<tr><td colspan='2'><input type=\"submit\" value=\"Atualizar Produto\"/></td></tr>");
				saida.println("</table>");
				saida.println("</form>");
				
			
	}
	 
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out= response.getWriter();
		
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));		
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
		produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
		
		produtoService.atualizarProduto(produto);
		

		 if(produto != null){  
	            
			 response.sendRedirect("listaProdutos.do");
	            
	        }else{  
	            out.println(" n�o foi possivel atualizar");  
	        }  
		
		 out.close();  
		
	}
	

}
