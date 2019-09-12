package com.maituananh.serviceimpl;

import com.maituananh.daoimpl.InterceptorDaoImpl;
import com.maituananh.service.InterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterceptorServiceImpl implements InterceptorService {

    @Autowired
    InterceptorDaoImpl interceptorDaoImpl;

    @Override
    public List loadMenu() {
        return interceptorDaoImpl.loadMenu();
    }
}
