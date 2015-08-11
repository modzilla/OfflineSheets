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

	public String getName() {
		return name;
	}

	public List<String> getTags() {
		return tags;
	}

	public File getPdf() {
		return pdf;
	}

	public String getSourceURL() {
		return sourceURL;
	}
}
