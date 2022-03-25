/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modulo4;

/**
 *
 * @author CesarAlfonsoRamírezS
 */
public class Title_types {
    
    private String title_no;
    private String title;

    public Title_types(String title_no, String title) {
        this.title_no = title_no;
        this.title = title;
    }
    
        public Title_types(String title_no) {
        this.title_no = title_no;
    }

    public String getTitle_no() {
        return title_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle_no(String title_no) {
        this.title_no = title_no;
    }

    public void setTitle(String title) {
        this.title = title;
    }
       
    
}
