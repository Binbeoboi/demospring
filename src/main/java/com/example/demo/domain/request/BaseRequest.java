package com.example.demo.domain.request;

import lombok.Data;

@Data
public class BaseRequest<T> {
    private T data;
}
