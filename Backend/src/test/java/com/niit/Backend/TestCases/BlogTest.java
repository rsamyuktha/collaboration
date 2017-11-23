package com.niit.Backend.TestCases;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.dao.Blogdao;
import com.niit.Backend.model.Blog;


public class BlogTest 
{

	static Blogdao blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		
		blogDAO=(Blogdao)context.getBean("blogDAO");
	}
	
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogId(1001);
		blog.setBlogName("Core Java");
		blog.setBlogContent("It is based on Simple Java Concept");
		blog.setUsername("sunil");
		blog.setStatus("A");
		blog.setLikes(3);
		blog.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	}
	

}


