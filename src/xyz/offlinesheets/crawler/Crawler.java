package xyz.offlinesheets.crawler;

import java.util.ArrayList;
import java.util.List;

public class Crawler {
	
	
	
	//HARDCODED PARAMETERS
	String uPage = "http://parts.io";
	String searchSuffix = "/search/term-";				// + SEARCH TERM
	List<String> crawlKeywords = new ArrayList<String>();
	String dataRootID = "j-part-"; 						// + ITEM ID
	String packageNameClass = "field-package-style";
	String manufacturerPartNumberClass = "field-manufacturer-part-number";
	String datasheetUrlClass = "pdf-available";			//<a href="DATASHEET">
	String descriptionClass = "field-description";
	String moreDescriptionClass = "morecontent";
	
	
}
