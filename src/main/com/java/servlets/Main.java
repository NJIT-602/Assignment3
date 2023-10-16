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
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 10 * 1024 * 1024, // 10 MB
        maxRequestSize = 20 * 1024 * 1024 // 20 MB
)
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String gender = request.getParameter("gender");
            System.out.println("first name: " + firstName);
            System.out.println("last name: " + lastName);
            System.out.println("gender: " + gender);

            if (firstName == null || lastName == null) {
                out.println("<h1>Error: Please enter both first name and last name.</h1>");
            } else if (gender == null) {
                out.println("<h1>Error: Please select a gender.</h1>");
            } else {
                out.println("<h1>Welcome to my Shop</h1>");
                if (gender.equals("Male")) {
                    out.println("<p>Thank you Mr. " + firstName + " " + lastName + ".</p>");
                } else if (gender.equals("Female")) {
                    out.println("<p>Thank you Ms. " + firstName + " " + lastName + ".</p>");
                } else {
                    out.println("<p>Thank you " + firstName + " " + lastName + ".</p>");
                }
            }
        } catch (Exception e) {
            // Handle the exception, e.g., log it or display an error message
            out.println("<h1>Error: An unexpected error occurred.</h1>");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String gender = request.getParameter("gender");
            System.out.println("first name: " + firstName);
            System.out.println("last name: " + lastName);
            System.out.println("gender: " + gender);

            if (firstName == null || lastName == null) {
                out.println("<h1>Error: Please enter both first name and last name.</h1>");
            } else if (gender == null) {
                out.println("<h1>Error: Please select a gender.</h1>");
            } else {
                out.println("<h1>Welcome to my Shop</h1>");
                if (gender.equals("Male")) {
                    out.println("<p>Thank you Mr. " + firstName + " " + lastName + ".</p>");
                } else if (gender.equals("Female")) {
                    out.println("<p>Thank you Ms. " + firstName + " " + lastName + ".</p>");
                } else {
                    out.println("<p>Thank you " + firstName + " " + lastName + ".</p>");
                }
            }
        } catch (Exception e) {
            // Handle the exception, e.g., log it or display an error message
            out.println("<h1>Error: An unexpected error occurred.</h1>");
            e.printStackTrace();
        }
    }
}
