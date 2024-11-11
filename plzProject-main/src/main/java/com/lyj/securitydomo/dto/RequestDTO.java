package com.lyj.securitydomo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
    private Long postId;
    private String title;
    private String content;
    private String username;
    private String contentText;

    public RequestDTO(String content, String username, String contentText) {
        this.content = content;
        this.username = username;
        this.contentText = contentText;
    }

}


