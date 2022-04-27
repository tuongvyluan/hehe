/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.recaptcha;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Luan Tuong Vy
 */
public class VerifyUtils {

    public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    public static boolean verify(String gRecaptchaResponse) throws IOException {
        boolean check = false;
        if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
            check = false;
        } else {
            HttpsURLConnection conn = null;
            OutputStream outStream = null;
            JsonReader jsonReader = null;
            try {
                URL verifyUrl = new URL(SITE_VERIFY_URL);

                // Mở một kết nối (Connection) tới URL trên.
                conn = (HttpsURLConnection) verifyUrl.openConnection();

                // Thêm các thông tin Header vào Request chuẩn bị gửi tới server.
                conn.setRequestMethod("POST");
                System.setProperty("http.agent", "");
                conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

                // Dữ liệu sẽ gửi tới Server.
                String postParams = "secret=" + RecaptchaConstants.SECRET_KEY
                        + "&response=" + gRecaptchaResponse;

                // Send Request
                conn.setDoOutput(true);

                // Lấy Output Stream (Luồng đầu ra) của kết nối tới Server.
                // Ghi dữ liệu vào Output Stream, có nghĩa là gửi thông tin đến Server.
                outStream = conn.getOutputStream();
                outStream.write(postParams.getBytes());
                
                outStream.flush();
                outStream.close();

                // Lấy Input Stream (Luồng đầu vào) của Connection
                // để đọc dữ liệu gửi đến từ Server.
                InputStream is = conn.getInputStream();
                jsonReader = Json.createReader(is);
                JsonObject jsonObject = jsonReader.readObject();

                // ==> {"success": true}
                System.out.println("Response: " + jsonObject);
                check = jsonObject.getBoolean("success");
                jsonReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (jsonReader != null) {
                    jsonReader.close();
                }
                if (outStream != null) {
                    outStream.close();
                }
            }
        }
        return check;
    }
}
