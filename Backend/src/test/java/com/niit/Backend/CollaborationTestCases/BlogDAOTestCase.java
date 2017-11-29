package com.niit.Backend.CollaborationTestCases;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.BlogDAO;

import com.niit.Backend.Domain.Blog;

public class BlogDAOTestCase
{
	Logger log = LoggerFactory.getLogger(Blog.class);
	
	@Autowired
	BlogDAO blogDAO;
	
	@Autowired
	Blog blog;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public BlogDAOTestCase()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blog = (Blog) context.getBean("blog");
		
	}
	
	
	public void blogAdd()
	{
		log.info("Add blog Test started");
		
		blog.setDescription("this is blog testing");
		blog.setUsername("samyuktha");
		blog.setBlog_title("abc");
		blog.setDate_time("DATE_TIME");
		blogDAO.addBlog(blog);
		log.info("Add blog Test end");
	}
	
}