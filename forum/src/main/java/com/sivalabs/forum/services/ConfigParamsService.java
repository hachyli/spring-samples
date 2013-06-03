package com.sivalabs.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.ConfigParameter;
import com.sivalabs.forum.repositories.ConfigParamRepository;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Service
@Transactional
public class ConfigParamsService
{
	@Autowired
	ConfigParamRepository configParamRepository;
	
	public ConfigParameter findConfigParameter(Long id)
	{
		return configParamRepository.findOne(id);
	}
	
	public List<ConfigParameter> findAll()
	{
		return configParamRepository.findAll();
	}
	
	public void create(ConfigParameter parameter)
	{
		configParamRepository.save(parameter);
	}
}
