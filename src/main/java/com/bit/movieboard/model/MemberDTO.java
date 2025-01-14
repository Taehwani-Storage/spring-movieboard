package com.bit.movieboard.model;

import lombok.Data;

@Data
public class MemberDTO {
    private int id;
    private String name;
    private String nickname;
    private String email;
    private String phone;
}
