package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Integer>
{
}
