/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 18, 2016 4:19:24 PM
 *******************************************************************************/

package com.primeton.devops.velocity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.junit.Assert;

import com.primeton.devops.velocity.ForeachTestCase.User;

/**
 * IncludeTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class IncludeTestCase extends AbstractTestCase {
	
	public static class Service {
		
		private String id;
		private String url;
		private String user;
		private String pass;
		/**
		 * 
		 */
		public Service() {
			super();
			// Auto-generated constructor stub
		}
		/**
		 * @param id
		 * @param url
		 * @param user
		 * @param pass
		 */
		public Service(String id, String url, String user, String pass) {
			super();
			this.id = id;
			this.url = url;
			this.user = user;
			this.pass = pass;
		}
		/**
		 * @return Returns the id.
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id The id to set.
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return Returns the url.
		 */
		public String getUrl() {
			return url;
		}
		/**
		 * @param url The url to set.
		 */
		public void setUrl(String url) {
			this.url = url;
		}
		/**
		 * @return Returns the user.
		 */
		public String getUser() {
			return user;
		}
		/**
		 * @param user The user to set.
		 */
		public void setUser(String user) {
			this.user = user;
		}
		/**
		 * @return Returns the pass.
		 */
		public String getPass() {
			return pass;
		}
		/**
		 * @param pass The pass to set.
		 */
		public void setPass(String pass) {
			this.pass = pass;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Service [id=" + id + ", url=" + url + ", user=" + user
					+ ", pass=" + pass + "]";
		}
		
	}
	
	private Properties getVelocitySettings() {
		Properties settings = new Properties();
		// settings.setProperty("file.resource.loader.path", "/Users/zhongwen/github/velocity/src/test/resources");
		// or
		settings.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); //$NON-NLS-1$ //$NON-NLS-2$
		// settings.setProperty("file.resource.loader.path", ""); //$NON-NLS-1$ //$NON-NLS-2$
		// org.apache.velocity.runtime.resource.loader.FileResourceLoader [default]
		// org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
		
		return settings;
	}

	/* (non-Javadoc)
	 * @see com.primeton.devops.velocity.AbstractTestCase#test()
	 */
	@Override
	public void test() throws Exception {
		// Auto-generated method stub
		Map<String, Object> context = new HashMap<>();
		List<User> users = new ArrayList<>();
		List<Service> services = new ArrayList<>();
		List<String> mails = new ArrayList<>();
		
		context.put("users", users);
		context.put("services", services);
		context.put("mails", mails);
		
		for (int i = 0; i < 10; i++) {
			users.add(new User(10000 + i, UUID.randomUUID().toString().toUpperCase(), String.valueOf(10000 + i) + "@primeton.com"));
			mails.add("system-" + i + "@primeton.com");
			services.add(new Service(String.valueOf(20000 + i), "http://" + (20000 + i) + "/cloud.com", "root", "123456"));
		}
		
		String template = getTemplateAsString("classpath:/templates/include.template.vm"); //$NON-NLS-1$
		System.out.println("\n####### Template Content #######\n");
		System.out.println(template);
		
		// String content = VelocityUtil.merge("/templates/include.template.vm", "utf-8", context, getVelocitySettings());
		String content = VelocityUtil.parse(template, context, "include.template", getVelocitySettings()); //$NON-NLS-1$
		System.err.println("\n####### Generate Content #######\n");
		System.err.println(content);
		
		Assert.assertTrue(content.contains("@primeton.com"));
	}

}
