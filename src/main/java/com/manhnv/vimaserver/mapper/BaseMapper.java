package com.manhnv.vimaserver.mapper;

public interface BaseMapper<M, V> {
    V toResponse(M m);
}
