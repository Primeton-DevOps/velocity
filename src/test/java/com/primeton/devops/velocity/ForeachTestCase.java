/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 16, 2016 10:55:26 PM
 *******************************************************************************/

package com.primeton.devops.velocity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;

/**
 * ForeachTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class ForeachTestCase extends AbstractTestCase {
	
	public static class User {
		
		private int id;
		private String name;
		private String mail;
		
		/**
		 * @param id
		 * @param name
		 * @param mail
		 */
		public User(int id, String name, String mail) {
			super();
			this.id = id;
			this.name = name;
			this.mail = mail;
		}
		/**
		 * 
		 */
		public User() {
			super();
			// Auto-generated constructor stub
		}
		/**
		 * @return Returns the id.
		 */
		public int getId() {
			return id;
		}
		/**
		 * @param id The id to set.
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @return Returns the name.
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name The name to set.
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return Returns the mail.
		 */
		public String getMail() {
			return mail;
		}
		/**
		 * @param mail The mail to set.
		 */
		public void setMail(String mail) {
			this.mail = mail;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.primeton.devops.velocity.AbstractTestCase#test()
	 */
	@Override
	public void test() throws Exception {
		// Auto-generated method stub
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			users.add(new User(100000 + i, UUID.randomUUID().toString().toUpperCase(), String.valueOf(100000 + i) + "@primeton.com"));
		}
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("users", users); //$NON-NLS-1$ //$NON-NLS-2$
		String template = getTemplateAsString("classpath:/templates/foreach.template.html"); //$NON-NLS-1$
		System.out.println("\n####### Template Content #######\n");
		System.out.println(template);
		
		String content = VelocityUtil.parse(template, context, "hello.template"); //$NON-NLS-1$
		System.err.println("\n####### Generate Content #######\n");
		System.err.println(content);
		
		Assert.assertTrue(content.contains("@primeton.com"));
	}

}
