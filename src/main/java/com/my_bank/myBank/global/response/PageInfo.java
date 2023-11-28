package com.my_bank.myBank.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PageInfo {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}