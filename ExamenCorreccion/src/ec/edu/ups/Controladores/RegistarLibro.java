package ec.edu.ups.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.Dao.AutorDAO;
import ec.edu.ups.Dao.CapituloDAO;
import ec.edu.ups.Dao.DAOFactory;
import ec.edu.ups.Dao.LibroDAO;
import ec.edu.ups.Modelo.Autor;
import ec.edu.ups.Modelo.Capitulo;
import ec.edu.ups.Modelo.Libro;

/**
 * Servlet implementation class RegistarLibro
 */
@WebServlet("/RegistarLibro")
public class RegistarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public RegistarLibro() {
    	// TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//Autor
			Integer codigo = (Integer.valueOf(request.getParameter("codigo")));
			
			//Libro
			String nombre = request.getParameter("nombre");
			Integer isbn = (Integer.valueOf(request.getParameter("isbn")));
			Integer numpag = (Integer.valueOf(request.getParameter("numpag")));
			
			//Capitulo
			Integer numero = (Integer.valueOf(request.getParameter("num")));
			String titulo = request.getParameter("titulo");
			
			
			System.out.println( codigo + " " + nombre + " " + isbn + " " + numpag + " " + numero + " " +  titulo );
			
			
			AutorDAO autorDAO = DAOFactory.getFactory().getAutorDAO();
			Autor autor  = autorDAO.findId(codigo);
			if (autor == null) {
				
				System.out.println("Codigo no resgistrado.....!!!!!!!!!!");
				
			}else {
				
				
				Libro libro = new Libro(nombre, isbn, numpag);
				Capitulo capitulo = new Capitulo(numero,titulo, libro);
				capitulo.setLibro(libro);
				libro.addCapitulo(capitulo);
				
				LibroDAO libroDAO = DAOFactory.getFactory().getLibroDAO();
				libroDAO.create(libro);
				
			
				
				
				response.sendRedirect("/MatuteCurillo-Jonnathan-Examen/jsp/listar.jsp");
			}
			
			

			
		
			
			
			
			url = "/ListarLibro.jsp";
		}catch (Exception e) {
			
			e.printStackTrace();
			url = "/JSPs/error1.jsp;";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
