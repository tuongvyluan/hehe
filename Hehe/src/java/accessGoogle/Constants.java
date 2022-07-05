/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accessGoogle;

/**
 *
 * @author Admin
 */
public class Constants {
  public static String GOOGLE_CLIENT_ID = "894467286073-gu13he3q90ma2on3nfjigafidbtvpgur.apps.googleusercontent.com";
  public static String GOOGLE_CLIENT_SECRET = "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";
  public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/Hehe/login-google";
  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
  public static String GOOGLE_LINK_GET_USER_INFO_ID_TOKEN = "https://oauth2.googleapis.com/tokeninfo?id_token=";
  public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
