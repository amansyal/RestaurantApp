package com.ptp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptp.servlets.YelpAPI;


/**
 * Servlet implementation class YelpDataLoaderService
 */
@WebServlet("/YelpDataLoaderService")
public class YelpDataLoaderService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  private static final String CONSUMER_KEY = "p4zcsaPkJx1OknA4h0X3ow";
	  private static final String CONSUMER_SECRET = "_bhuwnyUBq1CaeYrtByAvE9BTRc";
	  private static final String TOKEN = "Q1LVQ7u_vurBmXAV2_0h6G3g4vah7Qcp";
	  private static final String TOKEN_SECRET = "kUd-ntZm-AzVTPR36Ruxo__9E9s";
	  
    /**
     * Default constructor. 
     */
    public YelpDataLoaderService() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		YelpAPI.YelpAPICLI yelpApiCli = new YelpAPI.YelpAPICLI();
		
//		 JCommander obj =  new JCommander(yelpApiCli);
		System.out.println("in main of yelp api");
		    YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
		    yelpApi.queryAPI(yelpApi, yelpApiCli);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
