package com.laioffer.onlineOrder;

import com.laioffer.onlineOrder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Sue!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");


        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        // Hello
//        String customer = request.getParameter("customer");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Hello " + customer + "</h1>");
//        out.println("</body></html>");

        response.setContentType("application/json");

//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("email","sun@laioffer.com");
//        jsonResponse.put("first_name", "rick");
//        jsonResponse.put("last_name", "sun");
//        jsonResponse.put("age", 50);
//        response.getWriter().print(jsonResponse);

        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Read customer information from request body
//        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
//        String email = jsonRequest.getString("email");
//        String firstname = jsonRequest.getString("first_name");
//        String lastname = jsonRequest.getString("last_name");
//        int age = jsonRequest.getInt("age");

        ObjectMapper mapper = new ObjectMapper();
        Customer customerA = mapper.readValue(request.getReader(), Customer.class);


        //Print customer information to IDE console
//        System.out.println("Email is: " + email);
//        System.out.println("First name is: " + firstname);
//        System.out.println("Last name is: " + lastname);
//        System.out.println("Age is: " + age);

        System.out.println("Email is: " + customerA.getEmail());
        System.out.println("First name is: " + customerA.getFirstName());
        System.out.println("Last name is: " + customerA.getLastName());
        System.out.println("Password is: " + customerA.getPassword());


        // Return status = ok as response body to the client
        response.setContentType("application/json");

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}