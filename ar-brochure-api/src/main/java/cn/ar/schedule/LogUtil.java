package cn.ar.schedule;

import cn.ar.obs.ObsInstance;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author YangXw
 * @date 2021/12/18 10:15
 */

@Component
@ConfigurationProperties(prefix = "log")
@Data
public class LogUtil {

    private String localLogPath;

    private String cloudLogPath;


    /**
     * 获取昨日日期
     * @return
     */
    private String getYesterday(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        String yesterday = sdf.format(calendar.getTime());
        return yesterday;
    }

    /**
     * 上传Debug日志
     */
    private void uploadDebugLog(){
        int i = 0;
        while (i >= 0){
            String logStr = getYesterday() + "." + i + ".log";
            File file = new File(localLogPath+"/debug/log-debug-" + logStr);
            if (file.isFile()){
                ObsInstance.putObject(cloudLogPath+"/debug/"+logStr,file);
                System.out.println(logStr + " 上传到OBS");
                i++;
            }else {
                System.out.println("已经没有昨日的文件可已上传！");
                i = -1;
            }
        }
    }

    private void uploadInfoLog(){
        int i = 0;
        while (i >= 0){
            String logStr =  getYesterday() + "." + i + ".log";
            File file = new File(localLogPath+"/info/log-info-" + logStr);
            if (file.isFile()){
                ObsInstance.putObject(cloudLogPath+"/info/"+logStr,file);
                System.out.println(logStr + " 上传到OBS");
                i++;
            }else {
                System.out.println("已经没有昨日的文件可已上传！");
                i = -1;
            }
        }
    }

    public void uploadLog(){
        uploadDebugLog();
        uploadInfoLog();
    }

}
