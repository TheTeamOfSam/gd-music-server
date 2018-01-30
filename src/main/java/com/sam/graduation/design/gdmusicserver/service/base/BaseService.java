package com.sam.graduation.design.gdmusicserver.service.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * service基类
 * @author louxinhua
 *
 */

public class BaseService {
	
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * logger
	 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
