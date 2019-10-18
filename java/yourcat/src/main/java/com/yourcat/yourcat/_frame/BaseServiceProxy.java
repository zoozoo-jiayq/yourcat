package com.yourcat.yourcat._frame;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class BaseServiceProxy<T extends BaseModel> implements PagingAndSortingRepository<T, String> {

	public abstract BaseDao<T> getBaseDao();

	@Override
	public <S extends T> S save(S entity) {
		// TODO Auto-generated method stub
		if(entity.getId()==null) {
			entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			entity.setInsertTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		return getBaseDao().save(entity);
	}

	@Override
	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		for(S s:entities) {
			s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			s.setInsertTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		return getBaseDao().saveAll(entities);
	}

	@Override
	public Optional<T> findById(String id) {
		// TODO Auto-generated method stub
		return getBaseDao().findById(id);
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return getBaseDao().existsById(id);
	}

	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub
		return getBaseDao().findAll();
	}

	@Override
	public Iterable<T> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return getBaseDao().count();
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		getBaseDao().deleteById(id);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getBaseDao().delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		// TODO Auto-generated method stub
		getBaseDao().deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		getBaseDao().deleteAll();
	}

	@Override
	public Iterable<T> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return getBaseDao().findAll(sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return getBaseDao().findAll(pageable);
	}

}
