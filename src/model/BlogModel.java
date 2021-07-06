package model;

import common.Blog;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//博客相关操作
public class BlogModel {
    private static List<Blog> blogList =new LinkedList<>();
    private static List<Blog> attentionBlogList;

    public static void initialize(){
        Blog[] blogs=IoModel.BlogIo.readAll();
        for(int i=0;i<blogs.length;i++)
            add(blogs[i]);
    }
    public static void initializeAttention() throws IOException {
        attentionBlogList=new LinkedList<>();
        Blog[] blogs= UserModel.getAttentionBlogs();
        if(blogs!=null)
        {
            for (int i = 0; i < blogs.length; i++)
                addAttentionToList(blogs[i]);
        }
    }

    //allBlog
    public static Blog[] getAllBlog(){
        return blogList.toArray(new Blog[]{new Blog()});
    }
    public static boolean isPostExist(String searchTitle){
        for(Blog blog : blogList.toArray(new Blog[]{new Blog()})){
            if(blog.getTitle().equals(searchTitle))return true;
        }
        return false;
    }
    public static void add(Blog blog){
        blogList.add(blog);
    }
    public static boolean isNormalExist(){
        if(null==blogList)
            return false;
        else
            return true;
    }
    public static boolean isNormalEmpty(){
        return blogList.isEmpty();
    }


    //AttentionBlog
    public static boolean isAttentionListExist(){
        if(null==attentionBlogList)
            return false;
        else
            return true;
    }
    public static boolean isAttentionListEmpty(){
        return attentionBlogList.isEmpty();
    }
    public static boolean isAttentionExist(Blog blog){
        for(int i=0;i<attentionBlogList.size();i++)
            if(blog.getAuthor().equals(attentionBlogList.get(i).getAuthor())&& blog.getTitle().equals(attentionBlogList.get(i).getTitle()))
                return true;
        return false;

    }
    public static Blog[] getAllAttentionBlog(){
        return attentionBlogList.toArray(new Blog[]{new Blog()});
    }
    public static void addAttention(Blog blog)  {
            addAttentionToList(blog);
            UserModel.addAttentionBlog(blog);
    }
    public static void addAttentionToList(Blog blog){
        attentionBlogList.add(blog);
    }

}