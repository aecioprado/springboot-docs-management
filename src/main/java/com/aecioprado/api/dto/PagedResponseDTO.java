package com.aecioprado.api.dto;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Data
public class PagedResponseDTO<T> implements Serializable {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private String sort;

    // Getters and setters
    public PagedResponseDTO(Page<T> page) {
        this.content = page.getContent();
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.last = page.isLast();
        this.sort = page.getSort().toString();
    }
}
