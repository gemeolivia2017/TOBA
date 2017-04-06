
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String url = "/Login.html";
        
        //get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "Sign In";
        }
        
        
        //perform action and set URL to appropriate
        if (action.equals("sign off")) {
            url = "/Login.html"; 
            
            }
        else if (action.equals("add")) {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            
            User user = new User (username, password);
            
            request.setAttribute("user", user);
            url = "/Success.html";
            
            }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
