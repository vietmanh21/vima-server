package com.falcon.serveradmin.mapper;

public interface BaseMapper<M, V> {
    V toResponse(M m);
}
