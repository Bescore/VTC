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
		//je cr�� une condition qui controle si le servlet r��oit la data
		if(request.getParameter("myData")!=null) {
		mod�les.test newTest=new mod�les.test();//instancie le modele test (mod�les.test pour pr�ciser que je veux bien le mod�le et pas autre chose)
		newTest.setTest(request.getParameter("myData")); //j'ajoute la data re�u au mod�le  (regarde dans le fichier js la donn�e s'appelle "myData")
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
