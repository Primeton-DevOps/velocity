/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 16, 2016 8:20:28 PM
 *******************************************************************************/

package com.primeton.devops.velocity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;

/**
 * HelloTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class HelloTestCase extends AbstractTestCase {

	/* (non-Javadoc)
	 * @see com.primeton.devops.velocity.AbstractTestCase#test()
	 */
	@Override
	public void test() throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("title", "Hello World"); //$NON-NLS-1$ //$NON-NLS-2$
		context.put("body", UUID.randomUUID().toString().toUpperCase()); //$NON-NLS-1$
		String template = getTemplateAsString("classpath:/templates/hello.template"); //$NON-NLS-1$
		System.out.println("\n####### Template Content #######\n");
		System.out.println(template);
		
		String content = VelocityUtil.parse(template, context, "hello.template"); //$NON-NLS-1$
		System.err.println("\n####### Generate Content #######\n");
		System.err.println(content);
		
		Assert.assertTrue(content.contains("Hello World"));
	}
	

}
