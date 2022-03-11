package cn.ar.util.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @author YangXw
 * @date 2021/12/18 12:53
 */
@Configuration
@EnableScheduling
@Slf4j
public class ScheduleTask {

    private LogUtil logUtil;

    @Autowired
    public void setLogUtil(LogUtil logUtil) {
        this.logUtil = logUtil;
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void printTask(){
        log.info("上传日志---> {} ");
        logUtil.uploadLog();
    }
}
