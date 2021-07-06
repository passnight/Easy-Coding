package model;

import common.Post;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PostModel {
    private static List<Post> postList =new LinkedList<>();
    private static List<Post> attentionPostList;

    public static void initialize(){
        Post[] Posts=IoModel.PostIo.readAll();
        for(int i=0;i<Posts.length;i++)
            add(Posts[i]);
    }
    public static void initializeAttention() throws IOException {
         attentionPostList=new LinkedList<>();
         Post[] posts=IoModel.UserIo.getAttentionPosts();
         if(posts!=null)
         {
             for (int i = 0; i < posts.length; i++)
                 addAttentionToList(posts[i]);
         }
 }

    /**allPost*/
    public static Post[] getAllPost(){
        return postList.toArray(new Post[]{new Post()});
    }
    public static Post findPost(String searchSummary){
        for(int i=0;i<postList.size();i++){
            if(searchSummary.equals(postList.get(i).getSummary()))
            { return postList.get(i);}
        }
        return null;
    }
    public static void add(Post post){
        postList.add(post);
    }
    public static boolean isNormalExist(){
        if(null== postList)
            return false;
        else
            return true;
    }
    public static boolean isNormalEmpty(){
        return postList.isEmpty();
    }

    /**AttentionPost*/
    public static boolean isAttentionListExist(){
        if(null==attentionPostList)
            return false;
        else
            return true;
    }
    public static boolean isAttentionListEmpty(){
        return attentionPostList.isEmpty();
    }
    public static boolean isAttentionExist(Post post){
        for(int i=0;i<attentionPostList.size();i++)
            if(post.getAuthor().equals(attentionPostList.get(i).getAuthor())&& post.getSummary().equals(attentionPostList.get(i).getSummary()))
                return true;
        return false;

    }
    public static Post[] getAllAttentionPost(){
        return attentionPostList.toArray(new Post[]{new Post()});
    }
    public static void addAttention(Post post)  {
            addAttentionToList(post);
            IoModel.UserIo.addAttentionPost(post);
    }
    public static void addAttentionToList(Post post){
        attentionPostList.add(post);
    }

}