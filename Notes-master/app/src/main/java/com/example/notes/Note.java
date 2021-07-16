package com.example.notes;

import java.io.Serializable;

public class Note implements Serializable {


    public Note(){

    }

    public String getSelectedNoteColor() {
        return SelectedNoteColor;
    }

    public void setSelectedNoteColor(String selectedNoteColor) {
        SelectedNoteColor = selectedNoteColor;
    }

    private String SelectedNoteColor;
    private String Subtitle;

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    private String ImagePath;

    public String getWebLink() {
        return WebLink;
    }

    public void setWebLink(String webLink) {
        WebLink = webLink;
    }

    private String WebLink;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    private String DateTime;
    public Note(String Title, String Subtitle, String DateTime) {
        this.Subtitle = Subtitle;
        this.DateTime = DateTime;
        this.Title = Title;
    }

    private String Text;
    private String Title;

    public  String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public  String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }

    public  String gettext() {
        return Text;
    }

    public void settext(String text) {
        Text = text;
    }






}
