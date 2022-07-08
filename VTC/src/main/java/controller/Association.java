package controller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssociationDao;
import dao.ConDao;
import dao.VehiculeDao;
import modèles.Associations;
import modèles.Conducteurs;
import modèles.Vehicules;

/**
 * Servlet implementation class association
 */
@WebServlet("/association")
public class Association extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Association() {
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

		// afficher le tableau des associations

		AssociationDao asso_dao = new AssociationDao();
		request.setAttribute("list_asso", asso_dao.read());
		// list conducteurs
		ConDao dao = new ConDao();
		request.setAttribute("list_cond", dao.read());

		// list vehicules
		VehiculeDao vehicule_dao = new VehiculeDao();
		request.setAttribute("list_Vehicule", vehicule_dao.read());
		request.getRequestDispatcher("/association/association.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("conducteur"));
		System.out.println(request.getParameter("vehicule"));

		// transformer les valeurs recuperé en int et creer un vehicule et un conducteur
		/*********************************************/
		int id_vehi = Integer.valueOf(request.getParameter("vehicule"));
		Vehicules vehi = new Vehicules(id_vehi);
		/*********************************************/
		int id_cond = Integer.valueOf(request.getParameter("conducteur"));
		Conducteurs cond = new Conducteurs(id_cond);
		/*********************************************/

		// creer une nouvelle association
		Associations newAsso = new Associations(cond, vehi);
		// déclencher la méthode add d'associationDao
		AssociationDao assoDao = new AssociationDao();

		assoDao.add(newAsso);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
