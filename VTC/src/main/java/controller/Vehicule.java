package controller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConDao;
import dao.VehiculeDao;
import modèles.Conducteurs;
import modèles.Vehicules;

/**
 * Servlet implementation class véhicule
 */
@WebServlet("/vehicule")
public class Vehicule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vehicule() {
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

		VehiculeDao vehicule_dao = new VehiculeDao();

		request.setAttribute("listOfVehicule", vehicule_dao.read());
		///////////////////////////////////////////////////////////////

		// System.out.println(dao.read());

		// chopper l'id dans l'url
		String id_url = request.getParameter("id");
		if (id_url != null) {
			// on transform id en int
			int id = Integer.valueOf(id_url);

			// FINDBY
			Vehicules vehi = new Vehicules(id);

			if (vehicule_dao.findby(vehi) != null) {
				// mettre les données dans des variables
				String marque = vehicule_dao.findby(vehi).getMarque();
				String modele = vehicule_dao.findby(vehi).getModele();
				String couleur = vehicule_dao.findby(vehi).getCouleur();
				String immatriculation = vehicule_dao.findby(vehi).getImmatriculation();
				int id_vehi = vehicule_dao.findby(vehi).getId_vehicule();
				////////////////////////////////////////////
				// on creer les alias pour l'affichage
				request.setAttribute("marque", marque);
				request.setAttribute("modele", modele);
				request.setAttribute("couleur", couleur);
				request.setAttribute("immatriculation", immatriculation);
				request.setAttribute("id_vehi", id_vehi);
			}

		}
		request.getRequestDispatcher("vehicule/vehicule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String marque = request.getParameter("marque");
		String modele = request.getParameter("modele");
		String couleur = request.getParameter("couleur");
		String immatriculation = request.getParameter("immatriculation");
		String submit_value = request.getParameter("submit");

		/*
		 * if (!marque.equals("")||!modele.equals("")||!couleur.equals("")||!
		 * immatriculation.equals("")) { Vehicules vehicule=new
		 * Vehicules(marque,modele,couleur,immatriculation) ;
		 * 
		 * VehiculeDao dao= new VehiculeDao(); dao.add(vehicule);
		 * 
		 * try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } doGet(request, response);
		 * }else { doGet(request, response); }
		 */

		// instancier dao
		VehiculeDao dao = new VehiculeDao();

		if (submit_value.equals("add")) {
			// TODO Auto-generated method stub
			// nom ou prenom est différent d'un champs vide on le met en base de donnée
			Vehicules vehi = new Vehicules(marque, modele, couleur, immatriculation);
			dao.add(vehi);
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
			Vehicules vehi = new Vehicules(id, marque, modele, couleur, immatriculation);
			// declencher update
			dao.update(vehi);
			response.sendRedirect(request.getContextPath() + "/vehicule");
			// doGet(request, response);
		} else if (submit_value.indexOf("delete-") != -1) {
			// recupere l'id en string
			String value = submit_value.replace("delete-", "");
			// transforme l'id en int
			int id = Integer.valueOf(value);
			// creer un conducteur
			Vehicules vehi = new Vehicules(id, marque, modele, couleur, immatriculation);
			// declencher le delete
			dao.delete(vehi);
			doGet(request, response);
		}

	}

}
