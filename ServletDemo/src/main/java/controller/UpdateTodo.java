package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;
import util.DBUtil;

/**
 * Servlet implementation class UpdateTodo
 */
@WebServlet("/UpdateTodo")
public class UpdateTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTodo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = request.getParameter("method");
		
		if(method != null) {
			updateTodo(request, response);
		}else {
		
		String todoId = request.getParameter("todoId");
		
		Todo todo = DBUtil.getTodo(Integer.parseInt(todoId));
		
		request.setAttribute("todo", todo);
	
		System.out.println("inside update todo GET method");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateTodo.jsp");
		
		dispatcher.forward(request, response);
		
		}
	}

	private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		 String id = request.getParameter("todoId"); 
		 
		 String editedTodoTitle = request.getParameter("title");
		  
		 DBUtil.updateTodo(id, editedTodoTitle);
		 
		 response.sendRedirect(request.getContextPath() + "/ListServlet");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
