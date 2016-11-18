/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 18, 2016 5:19:28 PM
 *******************************************************************************/

package com.primeton.devops.velocity;

import java.io.InputStream;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;

/**
 * ClassPathFileResourceLoader.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class ClassPathFileResourceLoader extends FileResourceLoader {
	
	protected static final String PATH_PREFIX = "classpath:"; //$NON-NLS-1$

	
	/* (non-Javadoc)
	 * @see org.apache.velocity.runtime.resource.loader.FileResourceLoader#getResourceStream(java.lang.String)
	 */
	@Override
	public InputStream getResourceStream(String templateName)
			throws ResourceNotFoundException {
		if (null == templateName) {
			return super.getResourceStream(templateName);
		}
		if (templateName.toLowerCase().startsWith(PATH_PREFIX)) {
			String resourceName = templateName.substring(PATH_PREFIX.length());
			return ClassPathFileResourceLoader.class.getResourceAsStream(resourceName);
		}
		return super.getResourceStream(templateName);
	}
	
}
