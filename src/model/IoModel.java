package model;

import common.Answer;
import common.Blog;
import common.Post;
import common.User;

import java.io.*;

public class IoModel {
    //各种路径
    private static final String dicName="DB";
    private static final String dicUserName=dicName+"/User";
    private static final String dicBlogName=dicName+"/Blog";
    private static final String dicHotName=dicName+"/Hot";
    private static final String dicPostName=dicName+"/Post";

    //初始化（检测本地是否已有相关文件夹，没有则创建）
     public static void initialize(){
        File dic = new File(dicName);
        if (!dic.exists())
            dic.mkdir();
        dic=new File(dicBlogName);
         if (!dic.exists())
             dic.mkdir();
         dic=new File(dicUserName);
         if (!dic.exists())
             dic.mkdir();
         dic=new File(dicHotName);
         if (!dic.exists())
             dic.mkdir();
         dic=new File(dicPostName);
         if (!dic.exists())
             dic.mkdir();
         dic=new File(dicHotName+"/Blog");
         if (!dic.exists())
             dic.mkdir();
         dic=new File(dicHotName+"/Post");
         if (!dic.exists())
             dic.mkdir();
    }
    //博客相关IO
    public static class BlogIo extends IoModel {
        public static void save (Blog blog){
            initialize();

            String dicName = dicBlogName+"/"+blog.getAuthor() + "##" + blog.getTitle();
            File dic=new File(dicName);
            if(!dic.exists()){
                dic.mkdir();
            }

            FileWriter out = null;
            try {
                String fileName = dicName+"/content";
                File file = new File(fileName);
                if (!file.exists())
                    file.createNewFile();
                out = new FileWriter(fileName);
                out.write(blog.getContent());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != out)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //获取本地记录目录
        public static Blog[] readAll() {
            initialize();

            File dic = new File(dicBlogName);
            if (!dic.exists())
                return null;
            String[] items = dic.list();

            Blog[] blog = new Blog[items.length];

            for (int i = 0; i < items.length; i++) {
                blog[i]=get(items[i]);
            }
            return blog;
        }

        public static Blog[] readHot(){
            initialize();
            Blog blog[];

            String dicName=dicHotName+"/Blog";
            File dic = new File(dicName);
            File[] items = dic.listFiles();

            assert items != null;
            blog = new Blog[items.length];
            String[] str = new String[items.length];

            for (int i = 0; i < items.length; i++) {
                str[i] = items[i].getName();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(dicBlogName + '/'+str[i]));

                    blog[i] = new Blog();
                    String str1 = reader.readLine();
                    blog[i].setAuthor(str1);
                    str1 = reader.readLine();
                    blog[i].setTitle(str1);

                    String contain = "";

                    for (; (str1 = reader.readLine()) != null; )
                        contain += str1 + '\n';

                    blog[i].setContent(contain);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != reader)
                            reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            return blog;
        }

        //获取Blog目录下指定文件
        public static Blog get(String fileName){

            String[] str=fileName.split("##");
            BufferedReader reader = null;
            Blog blog=new Blog();
            blog.setAuthor(str[0]);
            blog.setTitle(str[1]);
            try {
                reader = new BufferedReader(new FileReader(dicBlogName + '/'+fileName+"/content"));

                String str1;
                String contain = "";

                for (; (str1 = reader.readLine()) != null; )
                    contain += str1 + '\n';

                blog.setContent(contain);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != reader)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return blog;
        }
    }
    //帖子相关IO
    public static class PostIo extends IoModel {
        public static void save (Post post){
            initialize();

            String dicName = dicPostName+"/"+post.getAuthor() + "##" + post.getSummary();
            File dic=new File(dicName);
            if(!dic.exists()){
                dic.mkdir();
            }

            FileWriter out = null;
            try {
                String fileName =dicName+"/content";
                File file = new File(fileName);
                if (!file.exists())
                    file.createNewFile();
                out = new FileWriter(fileName);
                out.write(post.getContent());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != out)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //获取本地记录目录
        public static Post[] readAll() {
            initialize();


            File dic = new File(dicPostName);
            if (!dic.exists())
                return null;
            String[] items = dic.list();
            Post[] post = new Post[items.length];

            for (int i = 0; i < items.length; i++) {
                post[i]=get(items[i]);

            }
            return post;
        }

        public static Post[] readHot(){
            initialize();
            Post posts[];

            String dicName=dicHotName+"/Post";
            File dic = new File(dicName);
            File[] items = dic.listFiles();

            assert items != null;
            posts = new Post[items.length];
            String[] str = new String[items.length];

            for (int i = 0; i < items.length; i++) {
                str[i] = items[i].getName();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(dicPostName + '/'+str[i]));

                    posts[i] = new Post();
                    String str1 = reader.readLine();
                    posts[i].setAuthor(str1);
                    str1 = reader.readLine();
                //    posts[i].setTitle(str1);

                    String contain = "";

                    for (; (str1 = reader.readLine()) != null; )
                        contain += str1 + '\n';

                    posts[i].setContent(contain);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != reader)
                            reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            return posts;
        }

        //获取Blog目录下指定Post的内容
        public static Post get(String fileName){

            String[] str=fileName.split("##");
            BufferedReader reader = null;
            Post post=new Post();
            post.setAuthor(str[0]);
            post.setSummary(str[1]);
            try {
                reader = new BufferedReader(new FileReader(dicPostName + '/'+fileName+"/content"));

                String str1;
                String contain = "";

                for (; (str1 = reader.readLine()) != null; )
                    contain += str1 + '\n';
                post.setContent(contain);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != reader)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return post;
        }
    }
    //评论/回答相关IO (type==1为评论，type==2为回答）
    public static class AnswerIo extends IoModel{
         //存储内容
         public static void saveContent(Answer answer,int type){
             String targetDic;
             if(type==1) {
                  targetDic = dicBlogName;
             }
             else{
                 targetDic=dicPostName;
             }
             targetDic+="/"+answer.getAuthor()+"##"+answer.getArticleName()+"/answer";//找到文章
             String targetFile=targetDic+"/"+answer.getReviewAuthor();//文章对应回答文件
             //创建回答文件夹
             File dic=new File(targetDic);
             if(!dic.exists()){
                 dic.mkdir();
             }
             //获取当前用户关于此问题所有回答
             String[] list = dic.list(new FilenameFilter() {
                 @Override
                 public boolean accept(File dir, String name) {
                     if (name.contains(answer.getReviewAuthor())) return true;
                     return false;
                 }
             });

             if(null==list){
                 targetFile+="##1";
             }
             else{
                 targetFile+=("##"+(list.length+1));
             }
             //创建回答文件
             dic=new File(targetFile);
             try {
                 dic.createNewFile();
             } catch (IOException ioException) {
                 ioException.printStackTrace();
             }
             //写入文件
             FileWriter out=null;
             try {
                 out=new FileWriter(targetFile);
                 out.write(answer.getContent());
                 out.flush();
             } catch (IOException ioException) {
                 ioException.printStackTrace();
             }finally {
                 if (null!=out){
                     try {
                         out.close();
                     }catch (IOException e) {
                         e.fillInStackTrace();
                     }
                 }
             }

         }
         //记录个人回答
         public static void savePersonRecord(Answer answer,int type){
             String fileName;
             if(type==1)
                  fileName= dicUserName + "/" + answer.getReviewAuthor() + "/answerForBlog";
             else
                  fileName = dicUserName + "/" + answer.getReviewAuthor() + "/answerForPost";

             File dir=new File(fileName);
             FileWriter out=null;
             BufferedReader reader=null;
             String all="";
             //若还没有记录
             boolean isExist=false;
             if(!dir.exists()){
                 try {
                     dir.createNewFile();
                     out=new FileWriter(fileName);
                     out.write(answer.getAuthor()+"##"+answer.getArticleName());
                 } catch (IOException ioException) {
                     ioException.printStackTrace();
                 }finally {
                     if(null!=out){
                         try {
                             out.close();
                         } catch (IOException ioException) {
                             ioException.printStackTrace();
                         }
                     }
                 }
             }
             else{
                 try {
                     reader=new BufferedReader(new FileReader(fileName));
                     String com;
                     while((com = reader.readLine())!=null) {
                         if(com.equals(answer.getAuthor()+"##"+answer.getArticleName()))isExist=true;
                            all += com;
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }finally {
                     if(null!=reader){
                         try {
                             reader.close();
                         } catch (IOException ioException) {
                             ioException.printStackTrace();
                         }
                     }
                 }
                 if(!isExist){
                     if(!all.equals(""))
                        all+="\n"+answer.getAuthor()+"##"+answer.getArticleName();
                     else
                         all+=answer.getAuthor()+"##"+answer.getArticleName();
                 }
                 try{
                     out=new FileWriter(fileName);
                     out.write(all);
                     out.flush();
                 } catch (IOException ioException) {
                     ioException.printStackTrace();
                 }finally {
                     if(null!=out){
                         try {
                             out.close();
                         } catch (IOException ioException) {
                             ioException.printStackTrace();
                         }
                     }
                 }

             }

         }
        //读取文章回答/评论
        public static Answer[] getAnswers(String articleName,int type){
             String targetDic;
            if(type==1) {
                targetDic = dicBlogName;
            }
            else{
                targetDic=dicPostName;
            }
            targetDic+="/"+articleName+"/answer";//找到文章

            File dic=new File(targetDic);
            if(!dic.exists()){
                dic.mkdir();
                return null;
            }
            String[] files = dic.list();
            assert files != null;
            Answer[] answers=new Answer[files.length];
            BufferedReader reader=null;
            String[] str=articleName.split("##");

            for(int i=0;i<answers.length;i++){
                String[] com=files[i].split("##");
                answers[i]=new Answer();
                answers[i].setAuthor(str[0]);
                answers[i].setArticleName(str[1]);
                answers[i].setReviewAuthor(com[0]);
                String content="";
                try {
                    reader=new BufferedReader(new FileReader(targetDic+"/"+files[i]));
                    while((com[1]=reader.readLine())!=null)
                        content+=com[1];
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(reader!=null){
                        try {
                            reader.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
                answers[i].setContent(content);
            }

            return answers;

        }

    }
    //用户相关IO
    public static class UserIo extends IoModel{
        private static String personalDic;
        private static String personalName;
        private static String personalAttentionDic;

        //注册
        static void register(User user){
            initialize();
            personalDic= dicUserName +"/"+user.getName();
            personalName=user.getName();
            File dic=new File(personalDic);
            if(!dic.exists())
                dic.mkdir();

            savePersonal(user);
        }

        //登录
        static boolean login(User user){
            initialize();
            personalDic= dicUserName +"/"+user.getName();
            personalName=user.getName();

            boolean result=false;
            if(isExist(user)){
                String comDic= dicUserName +"/"+user.getName();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(comDic + "/personalInformation"));
                    reader.readLine();
                    if(reader.readLine().equals(user.getPtsd())) {
                        result = true;
                        user.setSummary(reader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (null != reader)
                            reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }

        //存储个人信息
        static void savePersonal (User user){
            FileWriter out = null;
            try {
                String allName=personalDic+"/personalInformation";
                File file = new File(allName);
                if (!file.exists())
                    file.createNewFile();
                out = new FileWriter(allName);
                out.write(user.getName() + '\n');
                out.write(user.getPtsd() + '\n');
                out.write(user.getSummary() + '\n');
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != out)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //获取关注博客数组
        public static Blog[] getAttentionBlogs() throws IOException {
            initialize();

            BufferedReader reader = null;
            String[] str = readAttentionBlogList();
            if(null==str)return null;
            int length = str.length;
            Blog[] blogs=new Blog[length];
            int i=0,j=0;
            File dic=new File(dicBlogName);
            String[] items = dic.list();

            for(;i<length;i++) {
                for(j=0;j<items.length;j++) {
                    if (str[i].equals(items[j])) {
                        blogs[i]=BlogIo.get(str[i]);
                        break;
                    }
                }
            }
            return blogs;

        }

        //获取关注博客列表
        public static String[] readAttentionBlogList(){
            initialize();
            personalAttentionDic=personalDic+"/Attention";
            String dicName=personalAttentionDic+"/Blog";
            File dic = new File(personalAttentionDic);
            if(!dic.exists()){
                dic.mkdir();
            }
            dic=new File(dicName);
            if(!dic.exists()){
                try {
                    dic.createNewFile();
                    FileWriter out=new FileWriter(dicName);
                    out.write("0\n");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                }
            }
            BufferedReader reader = null;
            String[] str = new String[0];
            int length = 0;

            try {
                reader = new BufferedReader(new FileReader(dicName));

                length= Integer.parseInt(reader.readLine());
                if(0!=length)
                    str=new String[length];

                for(int i=0;i<length;i++)
                    str[i]=reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != reader)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return str;
        }

        //添加关注的博客
        public static void addAttentionBlog(Blog blog)  {
            initialize();
            personalAttentionDic=personalDic+"/Attention";
            String dicName=personalAttentionDic+"/Blog";
            File dic = new File(personalAttentionDic);
            if(!dic.exists()){
                dic.mkdir();
            }
            dic=new File(dicName);
            if(!dic.exists()){
                FileWriter out=null;
                try {
                    dic.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out=new FileWriter(dicName);
                    out.write("0/n");
                    out.flush();
                }catch (Exception e){
                    e.fillInStackTrace();
                }finally {
                    if (null!=out){
                        try {
                            out.close();
                        }catch (IOException ioException){
                            ioException.fillInStackTrace();
                        }
                    }
                }
            }
            BufferedReader reader = null;
            String[] str = new String[0];
            int length = 0;

            try {
                reader = new BufferedReader(new FileReader(dicName));
                String com=reader.readLine();
                if(null!=com)
                    length= Integer.parseInt(com);
                str=new String[length];

                for(int i=0;i<length;i++)
                    str[i]=reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != reader)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            FileWriter out = null;
            try {
                String allName=blog.getAuthor() + "##" + blog.getTitle();
                out = new FileWriter(dicName);
                out.write(Integer.toString(length+1)+'\n');
                for(int i=0;i<length;i++)
                    if(str[i]!="")
                        out.write(str[i]+"\n");
                out.write(allName+'\n');
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != out)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //获取关注帖子数组
        public static Post[] getAttentionPosts() throws IOException {
            initialize();

            String[] str = readAttentionPostList();
            if(null==str)return null;
            int length = str.length;
            Post[] posts=new Post[length];
            int i=0,j=0;
            File dic=new File(dicPostName);
            String[] items = dic.list();
            for(;i<length;i++) {
                for(j=0;j<items.length;j++) {
                    if (str[i].equals(items[j])) {
                        posts[i]=PostIo.get(str[i]);
                        break;
                    }
                }
            }

            return posts;

        }

        //获取关注帖子列表
        public static String[] readAttentionPostList(){
            initialize();
            personalAttentionDic=personalDic+"/Attention";
            String dicName=personalAttentionDic+"/Post";
            File dic = new File(personalAttentionDic);
            if(!dic.exists()){
                dic.mkdir();
            }
            dic=new File(dicName);
            if(!dic.exists()){
                try {
                    dic.createNewFile();
                    FileWriter out=new FileWriter(dicName);
                    out.write("0\n");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                }
            }
            BufferedReader reader = null;
            String[] str = new String[0];
            int length = 0;

            try {
                reader = new BufferedReader(new FileReader(dicName));

                length= Integer.parseInt(reader.readLine());
                if(0!=length)
                    str=new String[length];

                for(int i=0;i<length;i++)
                    str[i]=reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != reader)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return str;
        }

        //添加关注的帖子
        public static void addAttentionPost(Post post)  {
            initialize();
            personalAttentionDic=personalDic+"/Attention";
            String dicName=personalAttentionDic+"/Post";
            File dic = new File(personalAttentionDic);
            if(!dic.exists()){
                dic.mkdir();
            }
            dic=new File(dicName);
            if(!dic.exists()){
                FileWriter out=null;
                try {
                    dic.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out=new FileWriter(dicName);
                    out.write("0/n");
                    out.flush();
                }catch (Exception e){
                    e.fillInStackTrace();
                }finally {
                    if (null!=out){
                        try {
                            out.close();
                        }catch (IOException ioException){
                            ioException.fillInStackTrace();
                        }
                    }
                }
            }
            BufferedReader reader = null;
            String[] str = new String[0];
            int length = 0;

            try {
                reader = new BufferedReader(new FileReader(dicName));
                String com=reader.readLine();
                if(null!=com)
                    length= Integer.parseInt(com);
                str=new String[length];

                for(int i=0;i<length;i++)
                    str[i]=reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != reader)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            FileWriter out = null;
            try {
                String allName=post.getAuthor() + "##" + post.getSummary();
                out = new FileWriter(dicName);
                out.write(Integer.toString(length+1)+'\n');
                for(int i=0;i<length;i++)
                    if(str[i]!="")
                        out.write(str[i]+"\n");
                out.write(allName+'\n');
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != out)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //获取回答的问题
        public static Answer[] getPersonAnswer(int type){
            String fileName;
            Answer[] answers=new Answer[0];
            if(type==1)
                fileName=personalDic+"/answerForBlog";
            else
                fileName=personalDic+"/answerForPost";

            File file=new File(fileName);
            if(!file.exists()){
                try {
                    file.createNewFile();
                    return null;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            String com="";
            BufferedReader reader=null;
            try {
                reader=new BufferedReader(new FileReader(fileName));
                String str1;
                while((str1=reader.readLine())!=null)
                    com+=str1+"\n";
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(reader!=null){
                    try {
                        reader.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            String[] str=com.split("\n");
            //找到博客/论坛所在目录
            String targetDic;
            if(type==1) {
                targetDic = dicBlogName;
            }
            else{
                targetDic=dicPostName;
            }
            for(int i=0;i<str.length;i++){

                targetDic+="/"+str[i]+"/answer";//找到文章回答/评论所在目录
                File dic=new File(targetDic);
                //获取所有 回答/评论 文件名
                String[] files = dic.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        if(name.contains(personalName))return true;//只获取本用户名相关
                        return false;
                    }
                });
                assert files != null;
                //临时存储。
                Answer[] answersCom=new Answer[files.length];
                reader=null;
                String[] strCom=str[i].split("##");
                //开始获取
                for(int j=0;j<answersCom.length;j++){
                    answersCom[j]=new Answer();
                    answersCom[j].setAuthor(strCom[0]);
                    answersCom[j].setArticleName(strCom[1]);
                    answersCom[j].setReviewAuthor(personalName);
                    String content="",tem;
                    try {
                        reader=new BufferedReader(new FileReader(targetDic+"/"+files[j]));
                        while((tem=reader.readLine())!=null)
                            content+=tem;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if(reader!=null){
                            try {
                                reader.close();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                    answersCom[i].setContent(content);


                }
                Answer[] com2=new Answer[answersCom.length+answers.length];
                System.arraycopy(answers, 0,com2 , 0, answers.length);
                System.arraycopy(answersCom, 0, com2, answers.length, answersCom.length);
                answers=com2;

            }
            return answers;
        }


        static boolean isExist(User user){
            File dic=new File(dicUserName);
            if(!dic.exists())
                return false;

            File[] items = dic.listFiles();
            assert items != null;

            for (File item : items)
                if (item.getName().equals(user.getName()))
                    return true;
            return false;
        }
    }
}
