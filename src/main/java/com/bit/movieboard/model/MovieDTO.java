package com.bit.movieboard.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class MovieDTO {
    private Long mno;
    private String title;
    private List<RatingDTO> imageDTOList = new ArrayList<>();
    // 영화의 평균 평점
    private double avg;
    // 리뷰 수 jpa count()
    private int reviewCnt;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
