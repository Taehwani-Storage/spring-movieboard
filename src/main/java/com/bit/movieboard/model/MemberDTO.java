package com.bit.movieboard.model;

import lombok.Data;

@Data
public class MemberDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String tier;
    private String phone;
}
