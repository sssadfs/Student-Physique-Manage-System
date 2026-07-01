package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestForwarder {
    public static void forwardMessage(HttpServletRequest request, HttpServletResponse response, boolean success, String message, String returnUrl)
            throws ServletException, IOException {
        request.setAttribute("success", success);
        request.setAttribute("message", message);
        request.setAttribute("returnUrl", returnUrl);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/operationResult.jsp");
        dispatcher.forward(request, response);
    }
}
