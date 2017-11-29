package com.niit.Backend.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Backend.DAO.BlogDAO;
import com.niit.Backend.DAO.UserDAO;
import com.niit.Backend.Domain.Blog;
import com.niit.Backend.Domain.User;

@SuppressWarnings("deprecation")
@Repository("blogDAO")
@EnableTransactionManagement


public class BlogDAOImpl implements BlogDAO 
{
private static final Logger log = LoggerFactory.getLogger(BlogDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) 
	{
		try 
		{
			this.sessionFactory = sessionFactory;
			log.info("Connection Established Successfully");
		} 
		catch (Exception ex) 
		{
			log.error("Failed to establish connection");
			ex.printStackTrace();
		}
	}

	public boolean addBlog(Blog blog) {
		log.info("Add blog Method Started");
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			log.info("Add blog Method Success");
			return true;
		}
		catch(Exception ex)
		{
			log.error("Add blog has an Error");
			ex.printStackTrace();
			return false;
		}
}

	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBlog(Blog blog) {
		log.info("Delete Blog method Started");
		try
		{
			log.info("Delete blog Success");
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Delete Blog Unsuccessful");
			ex.printStackTrace();
			return false;
		}
}

	public Blog getBlog(String title) 
	{
		log.debug("Starting of Method Get blog "+title);
		try
		{
			Blog blog =  sessionFactory.getCurrentSession().get(Blog.class, title);
			blog.setErrorCode("200");
			blog.setErrorMsg("blog Found");
			return blog;
		}
		catch(Exception ex)
		{
			 Blog blog = new Blog();
			ex.printStackTrace();
			blog.setErrorCode("404");
			blog.setErrorMsg("blog Not Found");
			return null;
		}
	}

	public List<Blog> getBlogByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> getAllBlogs() {
		log.info("Starting of List Method");
		String hql_string = "FROM Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql_string);
		log.info("List Retrieved");
		return query.list();
	}
	}

