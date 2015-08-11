package xyz.offlinesheets.db;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.lightcouch.CouchDbClient;

public class CouchDBHandler {
	private static CouchDBHandler instance = null;
	
	CouchDbClient cdbc;
	
	public static CouchDBHandler getInstance() {
		if (instance == null)
			instance = new CouchDBHandler();
		return instance;
	}
	
	
	
	private CouchDBHandler() {
		start();
	}
	
	private void start() {
		cdbc = new CouchDbClient("./couchdb.properties");
	}
	
	public void close() {
		if (cdbc != null)
			cdbc.shutdown();
		cdbc = null;
	}
	
	public static void main(String[] args) {
		CouchDBHandler cdbh = CouchDBHandler.getInstance();
		List<String> tags = new LinkedList<>();
		tags.add("trans");
		tags.add("hiese");
		cdbh.cdbc.post(new Datasheet("BC848", tags, new File("asdf"), ""));
		
	}
}
