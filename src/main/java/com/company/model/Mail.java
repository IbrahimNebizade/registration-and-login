package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail implements Serializable {
    @Builder.Default
    private String from = "ibrahimnebizade074@gmail.com";
    @Builder.Default
    private String alias = "Good Reads";

    private String to;
    private String subject;
    private String body;

}
