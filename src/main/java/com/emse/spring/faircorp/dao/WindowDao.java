package com.emse.spring.faircorp.dao;


import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean
public interface WindowDao extends JpaRepository<Window, Long> , WindowDaoCustom{

}
