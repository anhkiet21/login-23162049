import model.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false); // false để không tự tạo session mới

        if (session != null && session.getAttribute("account") != null) {
            user u = (user) session.getAttribute("account");
            req.setAttribute("username", u.getUsername());

            
            req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
        } else {
            
            resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
        }
    }
}
