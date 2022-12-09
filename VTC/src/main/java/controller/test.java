package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.testDao;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//instancier le dao
		testDao newtestDao=new testDao();
		//je créé une condition qui controle si le servlet réçoit la data
		if(request.getParameter("myData")!=null) {
		modèles.test newTest=new modèles.test();//instancie le modele test (modèles.test pour préciser que je veux bien le modèle et pas autre chose)
		newTest.setTest(request.getParameter("myData")); //j'ajoute la data reçu au modèle  (regarde dans le fichier js la donnée s'appelle "myData")
		newtestDao.add(newTest);//la je fais un create
		}
		
		//ICI le set attribute et le read du tableau
		request.setAttribute("testtab", newtestDao.read());
		
		request.getRequestDispatcher("test/test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
