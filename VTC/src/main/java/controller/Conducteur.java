package controller;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConDao;
import modèles.Conducteurs;

/**
 * Servlet implementation class conducteur
 */
@WebServlet("/conducteur")
public class Conducteur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Conducteur() {
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
		request.setAttribute("list", dao.read());
		// System.out.println(dao.read());

		// chopper l'id dans l'url
		String id_url = request.getParameter("id");
		if (id_url != null) {
			// on transform id en int
			int id = Integer.valueOf(id_url);

			// FINDBY
			Conducteurs cond = new Conducteurs(id);

			if (dao.findby(cond) != null) {
				// mettre les données dans des variables
				String name = dao.findby(cond).getNom();
				String prename = dao.findby(cond).getPrenom();
				int id_cond = dao.findby(cond).getId();
				////////////////////////////////////////////
				// on creer les alias pour l'affichage
				request.setAttribute("nom", name);
				request.setAttribute("prenom", prename);
				request.setAttribute("id", id_cond);
			}

		}
		request.getRequestDispatcher("conducteur/conducteur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String submit_value = request.getParameter("submit");

		// instancier dao
		ConDao dao = new ConDao();

		if (submit_value.equals("add")) {
			// TODO Auto-generated method stub
			// nom ou prenom est différent d'un champs vide on le met en base de donnée
			Conducteurs cond = new Conducteurs(nom, prenom);
			dao.add(cond);
			doGet(request, response);
			// ajoute un delay de 2secondes
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			doGet(request, response);

		} else if (submit_value.indexOf("update-") != -1) {
			// recupere l'id en string
			String value = submit_value.replace("update-", "");
			// transforme l'id en int
			int id = Integer.valueOf(value);

			request.setAttribute("valeur", value);
			// creer un conducteur
			Conducteurs cond = new Conducteurs(id, nom, prenom);
			// declencher update
			dao.update(cond);
			response.sendRedirect(request.getContextPath() + "/conducteur");
			// doGet(request, response);
		} else if (submit_value.indexOf("delete-") != -1) {
			// recupere l'id en string
			String value = submit_value.replace("delete-", "");
			// transforme l'id en int
			int id = Integer.valueOf(value);
			// creer un conducteur
			Conducteurs cond = new Conducteurs(id, nom, prenom);
			// declencher le delete
			dao.delete(cond);
			doGet(request, response);
		}

	}

}
