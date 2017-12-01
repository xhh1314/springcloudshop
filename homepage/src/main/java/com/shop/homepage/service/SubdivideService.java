package com.shop.homepage.service;

import java.util.List;

import com.shop.homepage.bean.Subdivide;
import com.shop.homepage.manager.exception.MyException;

public interface SubdivideService {
	
	public boolean insert( Subdivide subdivide) throws MyException, Exception;
	public List< Subdivide> findAll();
	public  Subdivide findById(String uuid);
	public boolean update( Subdivide  subdivide);
	public boolean delete( Subdivide  subdivide);

}
