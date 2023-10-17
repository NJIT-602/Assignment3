package main.com.java.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Set the background color using a style attribute
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("body { background-color: #73C2FB; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        try {
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String gender = request.getParameter("gender");

            // Check if first name and last name are valid strings
            if (isString(firstName) && isString(lastName) && gender != null) {
                // Valid names, proceed with processing
                out.println("<h1>Welcome to my Shop</h1>");
                if (gender.equals("Male")) {
                    out.println("<p>Thank you Mr. " + firstName + " " + lastName + ".</p>");
                } else if (gender.equals("Female")) {
                    out.println("<p>Thank you Ms. " + firstName + " " + lastName + ".</p>");
                } else {
                    out.println("<p>Thank you " + firstName + " " + lastName + ".</p>");
                }
            } else if (gender == null) {
                out.println("<h1>Error: Please select a gender.</h1>");
            } else {
                out.println("<h1>Error: Please enter valid first name and last name.</h1>");
            }
        } catch (Exception e) {
            // Handle the exception, e.g., log it or display an error message
            out.println("<h1>Error: An unexpected error occurred.</h1>");
            e.printStackTrace();
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    private boolean isString(String text) {
        return text != null && !text.trim().isEmpty() && text.matches("^[a-zA-Z]+$");
    }
}
