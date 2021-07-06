package controller;

import common.Common;
import common.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.IoModel;
import model.PostModel;

public class WritePostController extends BaseController{
    static Post post;

    @FXML
    TextField summary;

    @FXML
    TextArea content;

    @FXML//保存草稿
    void save(ActionEvent event){
        post =new Post(Common.user.getName(),summary.getText(),content.getText());
    }

    @FXML//提交
    void submit(ActionEvent event){
        if(!summary.getText().equals("")&&!content.getText().equals(""))
        {
            Post post1 = new Post(Common.user.getName(), summary.getText(), content.getText());
            PostModel.add(post1);
            if (null != post) post = null;
            IoModel.PostIo.save(post1);
        }
    }

    @FXML
    void initialize(){
        if(null!= post){
            summary.setText(post.getSummary());
            content.setText(post.getContent());
        }
    }
}
