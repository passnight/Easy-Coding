package model;

import common.Blog;
import common.Post;
import common.User;

import java.io.IOException;

//用户操作相关
public class UserModel {
    public static boolean login(User user){
        return IoModel.UserIo.login(user);
    }

    public static boolean isExist(User user){
        return IoModel.UserIo.isExist(user);
    }

    public static void register(User user){
        IoModel.UserIo.register(user);
    }

    public static void savePersonal (User user){IoModel.UserIo.savePersonal(user);}

    public static void initialize() throws IOException {
        BlogModel.initializeAttention();
        PostModel.initializeAttention();
    }
    //获取关注博客
    public static Blog[] getAttentionBlogs() throws IOException {
        return IoModel.UserIo.getAttentionBlogs();
    }
    //添加关注博客
    public static void addAttentionBlog(Blog blog){
        IoModel.UserIo.addAttentionBlog(blog);
    }

    public static Post[] getAttentionPosts() throws IOException {
          return IoModel.UserIo.getAttentionPosts();
      }

    public static void addAttentionPost(Post post){
          IoModel.UserIo.addAttentionPost(post);
      }
}
