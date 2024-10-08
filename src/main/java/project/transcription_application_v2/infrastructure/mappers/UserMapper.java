package project.transcription_application_v2.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import project.transcription_application_v2.domain.user.entity.User;
import project.transcription_application_v2.infrastructure.security.dto.CreateUserRequest;
import project.transcription_application_v2.infrastructure.security.utils.PasswordEncoderComponent;

@Mapper(
    componentModel = "spring",
    implementationName = "UserMapperImpl"
)
public abstract class UserMapper {

  @Autowired
  private PasswordEncoderComponent passwordEncoderComponent;

  @Mapping(source = "password", target = "password", qualifiedByName = "encodePassword")
  public abstract User toEntity(CreateUserRequest createUserRequest);

  @Named("encodePassword")
  protected String encodePassword(String password) {
    return passwordEncoderComponent.encode(password);
  }
}
