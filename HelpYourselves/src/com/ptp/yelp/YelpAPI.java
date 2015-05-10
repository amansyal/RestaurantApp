package com.ptp.yelp;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * Code sample for accessing the Yelp API V2.
 * 
 * This program demonstrates the capability of the Yelp API version 2.0 by using the Search API to
 * query for businesses by a search term and location, and the Business API to query additional
 * information about the top result from the search query.
 * 
 * <p>
 * See <a href="http://www.yelp.com/developers/documentation">Yelp Documentation</a> for more info.
 * 
 */
public class YelpAPI {

  private static final String API_HOST = "api.yelp.com";
  private static final String DEFAULT_TERM = "reviews";
  private static final String DEFAULT_LOCATION = "Greens Restaurant";
  private static final int SEARCH_LIMIT = 1;
 // private static int  SEARCH_LIMIT;
  // private static final int SEARCH_LIMIT = 3;

  private static final String SEARCH_PATH = "/v2/search";
  private static final String BUSINESS_PATH = "/v2/business";
  private static final String REVIEW_PATH = "/v2/reviews";
//  private static final String BUSINESS_PATH = "/v2/business/4eR6hYFJcBHoAqhuOS07ww";

  /*
   * Update OAuth credentials below from the Yelp Developers API site:
   * http://www.yelp.com/developers/getting_started/api_access
   */
  
  private static final String CONSUMER_KEY = "p4zcsaPkJx1OknA4h0X3ow";
	private static final String CONSUMER_SECRET = "_bhuwnyUBq1CaeYrtByAvE9BTRc";
	private static final String TOKEN = "Q1LVQ7u_vurBmXAV2_0h6G3g4vah7Qcp";
	private static final String TOKEN_SECRET = "kUd-ntZm-AzVTPR36Ruxo__9E9s";
	
  OAuthService service;
  Token accessToken;

  /**
   * Setup the Yelp API OAuth credentials.
   * 
   * @param consumerKey Consumer key
   * @param consumerSecret Consumer secret
   * @param token Token
   * @param tokenSecret Token secret
   */
  public YelpAPI(String consumerKey, String consumerSecret, String token, String tokenSecret) {
   
	  this.service =
        new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(consumerKey)
            .apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }

  /**
   * Creates and sends a request to the Search API by term and location.
   * <p>
   * See <a href="http://www.yelp.com/developers/documentation/v2/search_api">Yelp Search API V2</a>
   * for more info.
   * 
   * @param term <tt>String</tt> of the search term to be queried
   * @param location <tt>String</tt> of the location
   * @return <tt>String</tt> JSON Response
   */
  public String searchForBusinessesByLocation(String term, String location) {
    OAuthRequest request = createOAuthRequest(SEARCH_PATH);
    request.addQuerystringParameter("term", term);
    request.addQuerystringParameter("location", location);
    request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
    return sendRequestAndGetResponse(request);
  }
  
  public String searchForReviewByBusiness(String term, String bus_name) {
	  OAuthRequest request = createOAuthRequest(SEARCH_PATH);
	  request.addQuerystringParameter("term", term);
	  request.addQuerystringParameter("name", bus_name);
	  request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
	  return sendRequestAndGetResponse(request);
  }

  /**
   * Creates and sends a request to the Business API by business ID.
   * <p>
   * See <a href="http://www.yelp.com/developers/documentation/v2/business">Yelp Business API V2</a>
   * for more info.
   * 
   * @param businessID <tt>String</tt> business ID of the requested business
   * @return <tt>String</tt> JSON Response
   */
 /* public String searchByBusinessId(String businessID) {
    OAuthRequest request = createOAuthRequest(BUSINESS_PATH + "/" + businessID);
    return sendRequestAndGetResponse(request);
  } */
  
  public String searchByReviewId(String ReviewID) {
	    OAuthRequest request = createOAuthRequest(REVIEW_PATH + "/" + ReviewID);
	    return sendRequestAndGetResponse(request);
	  }

  /**
   * Creates and returns an {@link OAuthRequest} based on the API endpoint specified.
   * 
   * @param path API endpoint to be queried
   * @return <tt>OAuthRequest</tt>
   */
  private OAuthRequest createOAuthRequest(String path) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "http://" + API_HOST + path);
    System.out.println("Request in OathRequest "+request);
    return request;
  }

  /**
   * Sends an {@link OAuthRequest} and returns the {@link Response} body.
   * 
   * @param request {@link OAuthRequest} corresponding to the API request
   * @return <tt>String</tt> body of API response
   */
  private String sendRequestAndGetResponse(OAuthRequest request) {
    System.out.println("Querying " + request.getCompleteUrl() + " ...");
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }

  /**
   * Queries the Search API based on the command line arguments and takes the first result to query
   * the Business API.
   * 
   * @param yelpApi <tt>YelpAPI</tt> service instance
   * @param yelpApiCli <tt>YelpAPICLI</tt> command line arguments
   */
 /* public void queryAPI(YelpAPI yelpApi, YelpAPICLI yelpApiCli) {
    String searchResponseJSON =
        yelpApi.searchForBusinessesByLocation(yelpApiCli.term, yelpApiCli.location);

    JSONParser parser = new JSONParser();
    JSONObject response = null;
    try {
      response = (JSONObject) parser.parse(searchResponseJSON);
    } catch (ParseException pe) {
      System.out.println("Error: could not parse JSON response:");
      System.out.println(searchResponseJSON);
      System.exit(1);
    }

    JSONArray businesses = (JSONArray) response.get("businesses");
    JSONObject firstBusiness = (JSONObject) businesses.get(0);
    String firstBusinessID = firstBusiness.get("id").toString();
    System.out.println(String.format(
        "%s businesses found, querying business info for the top result \"%s\" ...",
        businesses.size(), firstBusinessID));

    // Select the first business and display business details
    String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
    System.out.println(String.format("Result for business \"%s\" found:", firstBusinessID));
    System.out.println(businessResponseJSON);
    
  }*/
  
  public static void queryAPI(YelpAPI yelpApi, YelpAPICLI yelpApiCli) {
	  
	//  List <String> r = yelpApi.searchForReviewByBusiness(yelpApiCli.term, yelpApiCli.location);
	    String searchResponseJSON =
	        yelpApi.searchForReviewByBusiness(yelpApiCli.term, yelpApiCli.location);

	    JSONParser parser = new JSONParser();
	    JSONObject response = null;
	    try {
	      response = (JSONObject) parser.parse(searchResponseJSON);
	    } catch (ParseException pe) {
	      System.out.println("Error: could not parse JSON response:");
	      System.out.println(searchResponseJSON);
	      System.exit(1);
	    }

	    JSONArray reviews = (JSONArray) response.get("reviews");
	    JSONObject firstReview = (JSONObject) reviews.get(0);
	    String firstReviewID = firstReview.get("id").toString();
	    System.out.println(String.format(
	        "%s reviews found, querying business info for the top result \"%s\" ...",
	        reviews.size(), firstReviewID));

	    // Select the first review and display details
	    String reviewResponseJSON = yelpApi.searchByReviewId(firstReviewID.toString());
	    System.out.println(String.format("Result for business \"%s\" found:", firstReviewID));
	    System.out.println(reviewResponseJSON);
	    
	  } 
  
  	

  /**
   * Command-line interface for the sample Yelp API runner.
   */
 
   protected static class YelpAPICLI {
   @Parameter(names = {"-q", "--term"}, description = "Search Query Term")
    public String term = DEFAULT_TERM;

    @Parameter(names = {"-l", "--location"}, description = "Location to be Queried")
    public String location = DEFAULT_LOCATION;
  }

  /**
   * Main entry for sample Yelp API requests.
   * <p>
   * After entering your OAuth credentials, execute <tt><b>run.sh</b></tt> to run this example.
   */
 
  
  public static void main(String[] args) {
    YelpAPICLI yelpApiCli = new YelpAPICLI();
    new JCommander(yelpApiCli, args);
System.out.println("in main of yelp api");
    YelpAPI yelpApi = new YelpAPI(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
    queryAPI(yelpApi, yelpApiCli);
  }
}