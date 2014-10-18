package com.gb.sboum.service.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.gb.sboum.business.FirstBusiness;
import com.gb.sboum.service.dto.UserDto;
import com.gb.sboum.service.mapper.UserMapper;

@Configurable
@Path("/first")
public class FirstService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstService.class);

	@Autowired
	private FirstBusiness firstBusiness;

	@Autowired
	private UserMapper userMapper;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHi() {
		UserDto userDto = userMapper.toUserDto(firstBusiness.getUser("1"));
		LOGGER.info(userDto.toString());
		return firstBusiness.sayPlainTextHi();
	}
	// @GET
	// @Produces(MediaType.TEXT_XML)
	// public String sayXMLHi() {
	// return "<?xml version=\"1.0\"?>" + "<hello>Hi folks !!!" + "</hello>";
	// }
	//
	// @GET
	// @Produces(MediaType.TEXT_HTML)
	// public String sayHtmlHi() {
	// return "<html> " + "<title>" + "Hi folks !!!" + "</title>" + "<body><h1>" + "Hi folks !!!" + "</body></h1>"
	// + "</html> ";
	// }
	//
	// @GET
	// @Produces(MediaType.APPLICATION_JSON)
	// public UserDto sayJsonHi() {
	// UserDto userDto = new UserDto();
	// userDto.setId("first");
	// userDto.setFirstName("Guillaume");
	// userDto.setLastName("sBoom");
	// userDto.setNickName("GuiGui");
	// userDto.setDateOfBirth(LocalDate.now());
	// return userDto;
	// }
}
