package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum USERINFO {

    CANDIDATE_ERDAL1("erdal@yopmail.com","123123","candidate"),
    CANDIDATE_ERDAL2("erdal@yopmail.com","1230123","candidate"),

        ;

    private final String email, password, state;



}
