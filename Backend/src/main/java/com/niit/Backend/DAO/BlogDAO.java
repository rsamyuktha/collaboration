package com.niit.Backend.DAO;

import java.util.List;
import com.niit.Backend.Domain.Blog;

public interface BlogDAO {

	public boolean addBlog(Blog blog);
	
	
	public boolean updateBlog(Blog blog);	
	
	public boolean deleteBlog(Blog blog);
	
	public Blog getBlog(String title);
	
	public List<Blog> getBlogByUser(String username);
	
	
	public List<Blog> getAllBlogs();
		
}
