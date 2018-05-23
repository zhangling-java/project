package com.zhangling.spring.boot.model.rt;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginRequestModel {
    @NotNull
    @Size(min=2, max=32)
    private String account;
    @NotNull
    private String password;
}
