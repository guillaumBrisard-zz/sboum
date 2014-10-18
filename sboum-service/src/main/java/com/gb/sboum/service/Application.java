package com.gb.sboum.service;

import javax.json.stream.JsonGenerator;

import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

	public Application() {
		packages("com.gb.sboom.service.endpoint", "com.gb.sboom.service.provider");
		property(JsonGenerator.PRETTY_PRINTING, true);
	}
}
