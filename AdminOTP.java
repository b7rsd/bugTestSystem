import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.Line;

public class AdminOTP {
    

public AdminOTP(){
    ChanegOTP();
    OTPTimer();
}

    public void OTPTimer(){
       
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
              
                    ChanegOTP();
            }  
        };
        timer.scheduleAtFixedRate(task, 0, 60000);
    }

    public void ChanegOTP(){
        Random random = new Random();
        try (FileWriter writer = new FileWriter("OTP.txt",false)) {
            int temp = random.nextInt(100000,999999);
            writer.write(String.valueOf(temp));

        } catch (IOException e) {}
    }

public String getOTP(){
    
    String otp = null;
    try (BufferedReader reader = new BufferedReader(new FileReader("OTP.txt"))) {
        
        otp = reader.readLine();
        
    } catch (Exception e) {}


return otp;

}




}
