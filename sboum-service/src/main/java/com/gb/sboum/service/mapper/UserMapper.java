package com.gb.sboum.service.mapper;

import com.gb.sboom.model.User;
import com.gb.sboum.service.dto.UserDto;

import fr.xebia.extras.selma.IgnoreFields;
import fr.xebia.extras.selma.Mapper;

@Mapper
public interface UserMapper {

	@IgnoreFields({ "dateOfBirth" })
	UserDto toUserDto(User in);

	@IgnoreFields({ "dateOfBirth" })
	UserDto toUserDto3(User in);

}
