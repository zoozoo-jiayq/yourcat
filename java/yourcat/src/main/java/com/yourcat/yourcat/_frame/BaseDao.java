package com.yourcat.yourcat._frame;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseDao<T> extends PagingAndSortingRepository<T, String> {

}
