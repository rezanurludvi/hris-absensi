package com.hris.absen.service;

import com.hris.absen.dao.BaseDAO;
import com.hris.absen.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public abstract class BaseService<T extends BaseEntity<T>> {


    protected abstract BaseDAO<T> getDAO();

//Transactional berfungsi untuk memberikan sifat transactional pada masing" methode
//readOnly = true berfungsi untuk dibaca atau hanya dapat membaca saja

//    findOne -> berfungsi untuk mencari 1 data berdasarkan parammeter
    @Transactional(readOnly = true)
    public T findOne(T param){
        return getDAO().findOne(param);
    }

//    collection<T> find -> berfungsi untuk menampilkan data dalam jumlah banyak
//    dimana parameternya adalah objek yang akan digunakan
    @Transactional(readOnly = true)
    public Collection<T> find(T param, int offset, int limit){
        return getDAO().find(param, offset, limit);
    }

//    menampilkan jumlah data dari yang sudah ditentukan kemudian memanggil function count dari DAO
    @Transactional(readOnly = true)
    public Long count(T param){
        return getDAO().count(param);
    }

//    save menggunakan object generet dan dilanjutkan memanggil fungsi save pada DAO
    @Transactional
    public T save(T entity){
        return getDAO().save(entity);
    }

    @Transactional
    public T update(T entity){
        if (entity.getId() != null){
            return getDAO().update(entity);
        }

        return null;
    }

    @Transactional
    public boolean delete(Long id){
        return getDAO().delete(getDAO().findReference(id)) != null;
    }
}
