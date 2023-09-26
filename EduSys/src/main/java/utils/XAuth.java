/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.edusys.entity.NhanVien;

/**
 *
 * @author buidu
 */
public class XAuth {
    public  static NhanVien user =null;
    public void clear(){
        user = null;
    }
    public static boolean isLogin(){
        return user != null;
    }
    public static boolean isManager(){
        return isLogin() && user.getVaiTro();
    }
    
}
