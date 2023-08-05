package com.company.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page<T>{
    private T data;
    private int currentPage;
    private int totalPage;
    private boolean hasMore;
}
