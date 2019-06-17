package utils;

import java.io.IOException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpSession;

import model.User;

public class AuthUtil  {

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthUtil() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Сохранить информацию пользователя в Session.
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        // На JSP можно получить доступ через ${loginedUser} // javax.el.PropertyNotFoundException: Property [userName] not found on type [model.User]
        session.setAttribute("loginedUser", loginedUser);
    }
 
    // Получить информацию пользователя, сохраненную в Session.
    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }
     


}
