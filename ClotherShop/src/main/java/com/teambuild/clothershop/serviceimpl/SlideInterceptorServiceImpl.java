package com.teambuild.clothershop.serviceimpl;

import com.teambuild.clothershop.daoimpl.SlideInterceptorDaoImpl;
import com.teambuild.clothershop.model.Slide;
import com.teambuild.clothershop.service.SlideInterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideInterceptorServiceImpl implements SlideInterceptorService {

    @Autowired
    SlideInterceptorDaoImpl menuInterceptorDaoImpl;

    @Override
    public List<Slide> loadMenu() {
        return menuInterceptorDaoImpl.loadMenu();
    }
}
