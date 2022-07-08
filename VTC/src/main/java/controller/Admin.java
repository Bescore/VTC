package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssociationDao;
import dao.ConDao;
import dao.VehiculeDao;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		ConDao dao = new ConDao();
		request.setAttribute("valeur_conducteur", dao.read().size());
		///////////////////////////////////////////////////////////////
		VehiculeDao vehicule_dao = new VehiculeDao();
		request.setAttribute("valeur_vehicule", vehicule_dao.read().size());
		//////////////////////////////////////////////////////////////
		AssociationDao asso_dao = new AssociationDao();
		request.setAttribute("valeur_asso", asso_dao.read().size());
		///////////////////////////////////////////////////////////////
		request.setAttribute("no_cond", vehicule_dao.read_vehicule_no_cond().size());
		//////////////////////////////////////////////////////////////
		request.setAttribute("no_vehi", dao.read_conducteur_no_vehi().size());

		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
