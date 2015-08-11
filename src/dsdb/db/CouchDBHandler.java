package dsdb.db;

import org.lightcouch.CouchDbClient;

public class CouchDBHandler {
	private CouchDbClient dbc;
	public CouchDBHandler(){
		
	}
	public void init(){
		dbc = new CouchDbClient("./cfg/couchdb.properties");
	}

	public void kill(){
		if(dbc != null)
			dbc.shutdown();
		
		dbc = null;
	}
}
