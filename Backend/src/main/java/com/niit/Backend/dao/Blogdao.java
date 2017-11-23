package com.niit.Backend.dao;

import java.util.List;

import com.niit.Backend.model.Blog;


public interface Blogdao
{
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
}
