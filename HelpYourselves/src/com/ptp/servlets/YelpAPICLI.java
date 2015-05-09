package com.ptp.servlets;

import com.beust.jcommander.Parameter;


public  class YelpAPICLI {
	private static final String DEFAULT_TERM = "dinner";
	private static final String DEFAULT_LOCATION = "San Francisco, CA";

    @Parameter(names = {"-q", "--term"}, description = "Search Query Term")
    public String term = DEFAULT_TERM;

    @Parameter(names = {"-l", "--location"}, description = "Location to be Queried")
    public String location = DEFAULT_LOCATION;
  }