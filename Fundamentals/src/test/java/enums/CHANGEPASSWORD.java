package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CHANGEPASSWORD {

    CHANGEPASSWORD1("123123","1230123","1230123"),
    CHANGEPASSWORD2("1230123","123123","123123")

    ;

    private final String oldPassword, newPassword, second;


}
