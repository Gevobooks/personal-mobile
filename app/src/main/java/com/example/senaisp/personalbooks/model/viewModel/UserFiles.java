package com.example.senaisp.personalbooks.model.viewModel;

import java.io.Serializable;
import java.util.Date;

public class UserFiles implements Serializable{

    String CategoryName;
    String CreatorUserName;
    Date UploadDate;
    int ID;
    String Name;

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCreatorUserName() {
        return CreatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        CreatorUserName = creatorUserName;
    }

    public Date getUploadDate() {
        return UploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        UploadDate = uploadDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
