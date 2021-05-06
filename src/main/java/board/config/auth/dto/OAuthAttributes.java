package board.config.auth.dto;

import board.domain.user.Role;
import board.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributesKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributesKey, String name,
                           String email, String picture){
        this.attributes=attributes;
        this.nameAttributesKey=nameAttributesKey;
        this.name = name;
        this.email=email;
        this.picture=picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributesName,
                                     Map<String, Object> attributes){
        return ofGoogle(userNameAttributesName, attributes);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributesName, Map<String , Object> attributes){
        return OAuthAttributes.builder().name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributesKey(userNameAttributesName)
                .build();
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
