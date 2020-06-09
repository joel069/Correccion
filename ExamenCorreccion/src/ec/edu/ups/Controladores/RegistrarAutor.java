package ec.edu.ups.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.Dao.AutorDAO;
import ec.edu.ups.Dao.DAOFactory;
import ec.edu.ups.Modelo.Autor;

/**
 * Servlet implementation class RegistrarAutor
 */
@WebServlet("/RegistrarAutor")
public class RegistrarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutorDAO autorDAO;   
	private Autor autor;
   
    
    public RegistrarAutor() {
    	
    	autorDAO = DAOFactory.getFactory().getAutorDAO();
    	autor = new Autor();
        
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		try {
			
			autor.setNombre(request.getParameter("nombre"));
			autor.setNacionalidad(request.getParameter("nacionalidad"));
			
			autorDAO.create(autor);

			url = "/RegistrarLibro.html";
			
		}catch (Exception e) {
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
