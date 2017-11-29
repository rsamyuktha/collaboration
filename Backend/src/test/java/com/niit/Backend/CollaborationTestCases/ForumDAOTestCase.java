package com.niit.Backend.CollaborationTestCases;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Domain.Forum;

public class ForumDAOTestCase 
{
	Logger log = LoggerFactory.getLogger(ForumDAOTestCase.class);
	
	@Autowired
	ForumDAOTestCase forumDAO;
	
	@Autowired
	Forum forum;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public ForumTest()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");
		forum = (Forum) context.getBean("forum");
		
	}
	public void addforum()
	{
		log.info("Add forum Test started");
		  
		   forum.setDescription("testcase");
		   forum.setUsername("samyuktha");
		   forum.setBlog_title("aaaaaa");
		   forum.setDate_time("DATE_TIME");
		   
		   ForumDAO.addForum(forum);
		   log.info("Add Blog Test end");
	}
	public void deleteBlog()
	{
		log.info("Delete Success initiated.");
		forum = forumDAO.getBlog("testBlog");
		forumDAO.deleteForum(forum);
		log.info("Delete Success");
	}
  

public static void main(String[] args) 
	{
	   BlogDAOTestCase tblog = new BlogDAOTestCase ();
//		tblog.ForumAdd();
	

//		tblog.deleteBlog();
	
		
		System.out.println("Success");
	}
}
