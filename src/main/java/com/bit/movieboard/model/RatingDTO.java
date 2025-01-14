package com.bit.movieboard.model;

import lombok.Data;

@Data
public class RatingDTO {
    private int movieId;
    private int imageId;
    private String imageUrl;
    private String title;
    private String description;
}
