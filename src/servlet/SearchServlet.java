package servlet;

import domain.Restaurant;
import service.YelpAPI;
import util.SearchResponseHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by henry on 10/20/16.
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    /*
     * Update OAuth credentials below from the Yelp Developers API site:
     * http://www.yelp.com/developers/getting_started/api_access
     */
    private static final String CONSUMER_KEY = "cfBqRtz6wH81legZVZtWOQ";
    private static final String CONSUMER_SECRET = "f75UEI8u1q4L7OmTeCF5jLuVRk8";
    private static final String TOKEN = "vCUJuPf9KvicIhgX9uVMoepYI_H9SpL_";
    private static final String TOKEN_SECRET = "is8BFa91IbvDDVwYslR0GHl6DuI";

    public SearchServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        String searchResponseJSON = yelpApi.searchForBusinessesByLocation("dinner", "San Francisco, CA");

        List<Restaurant> restaurantList = SearchResponseHelper.getRestaurants(searchResponseJSON);
        request.setAttribute("restaurantList", restaurantList);

        // Forward to /WEB-INF/view/searchView.jsp
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/searchView.jsp");
        dispatcher.forward(request, response);
    }
}
