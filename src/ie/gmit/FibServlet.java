package ie.gmit;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;

public class FibServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private String remoteHost = null;
	private FibonacciService fs = new FibonacciService();

	public void init() throws ServletException {
		fs.rmiRegis();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String rType = request.getParameter("request-type");

		// 若请求类型是add，则获取max长度
		// get the max if the request-type is "Add"
		if (rType.equals("Add")) {

			int max = Integer.valueOf(request.getParameter("max"));
			HttpSession session = request.getSession();
			session.setAttribute("max", max);

			// generate jobnumber and add it to inQ
			int jobnumber = fs.add(max);
			// 页面跳转到response.jsp并显示jobnumber
			response.sendRedirect("Response.jsp?jobnumber=" + jobnumber);
			fs.finish();
		}
		// 若请求类型是Poll，则从outQ返回结果
		else if (rType.equals("Poll")) {

			int jobnumber = Integer.valueOf(request.getParameter("jobNo"));

			System.out.println("poll, jobnumber:" + jobnumber);

			// check outQ for result then pass to Result.jsp
			String result = fs.getResult(jobnumber);
			if (result != null) {

				ServletContext application = this.getServletContext();
				RequestDispatcher rd = application
						.getRequestDispatcher("/Result.jsp");
				request.setAttribute("result", result);
				rd.forward(request, response);

				String max = request.getSession().getAttribute("max")
						.toString();
				// save request max length and result into file
				fs.save(max, result);
			} else {
				System.out.println("result=" + result);
				response.sendRedirect("Response.jsp?jobnumber=" + jobnumber);
			}
		}
		out.flush();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}