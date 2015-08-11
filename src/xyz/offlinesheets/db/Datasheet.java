package xyz.offlinesheets.db;

import java.io.File;
import java.util.List;

public class Datasheet {
	String name;
	List<String> tags;
	File pdf;
	String sourceURL;
	
	public Datasheet(String name, List<String> tags, File pdf, String sourceURL) {
		super();
		this.name = name;
		this.tags = tags;
		this.pdf = pdf;
		this.sourceURL = sourceURL;
	}
}
