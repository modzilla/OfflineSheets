package xyz.offlinesheets.log;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Log {
	private static Logger log = Logger.getGlobal();

	public static void init() {
		log.addHandler(new Handler() {

			@Override
			public void publish(LogRecord record) {
				if (record.getLevel() != Level.SEVERE)
					System.out.printf("[%s]>: %s\n", record.getSourceMethodName(), record.getMessage());
				else
					System.err.printf("[%s]>: %s\n", record.getSourceMethodName(), record.getMessage());
			}

			@Override
			public void flush() {
			}

			@Override
			public void close() throws SecurityException {
			}
		});
		finest("Setup Logger");
	}

	public static void finest(String message) {
		log.finest(message);
	}

	public static void finer(String message) {
		log.finer(message);
	}

	public static void fine(String message) {
		log.fine(message);
	}

	public static void severe(String message) {
		log.severe(message);
	}

	public static void warning(String message) {
		log.warning(message);
	}

	public static void info(String message) {
		log.info(message);
	}

	// TODO: #99 FIX argument names
	public static void logp(Level finest, String string, String string2, String string3) {
		log.logp(finest, string, string2, string3);

	}

	public static void setLevel(LogLevel x) {
		switch (x) {
		case DEBUG: {
			log.setLevel(Level.ALL);
			break;
		}
		case NONE: {
			log.setLevel(Level.OFF);
			break;
		}
		case WARNING: {
			log.setLevel(Level.WARNING);
			break;
		}
		case SEVERE: {
			log.setLevel(Level.SEVERE);
			break;
		}
		case FINE: {
			log.setLevel(Level.FINE);
			break;
		}
		case FINER: {
			log.setLevel(Level.FINER);
			break;
		}
		case FINEST: {
			log.setLevel(Level.FINEST);
			break;
		}

		}
	}

}
