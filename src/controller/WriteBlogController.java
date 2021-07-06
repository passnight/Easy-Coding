package controller;

import common.Blog;
import common.Common;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.BlogModel;
import model.IoModel;


public class WriteBlogController extends BaseController{

    static Blog blog;

    @FXML
    TextField title;

    @FXML
    TextArea contain;

    @FXML//保存草稿
    void save(ActionEvent event){
        blog =new Blog(Common.user.getName(),title.getText(),contain.getText());
    }

    @FXML//提交
    void submit(ActionEvent event){
        if(!title.getText().equals("")&&!contain.getText().equals(""))
        {
            Blog blog1 = new Blog(Common.user.getName(), title.getText(), contain.getText());
            BlogModel.add(blog1);
            if (null != blog) blog = null;
            IoModel.BlogIo.save(blog1);
        }
    }

    @FXML
    void initialize(){
        if(null!= blog){
            title.setText(blog.getTitle());
            contain.setText(blog.getContent());
        }
    }
}
