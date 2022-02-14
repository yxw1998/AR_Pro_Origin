package cn.ar.http.path;

/**
 * @author YangXw
 * @date 2021/11/19 0019 9:55
 * @description
 */
public class HttpUrl {
        public static final String AR_MANAGEMENT = "dev";
//    public static final String AR_MANAGEMENT = "prod";


    public static String getArManagementUrl(String uri,String userSessCode,String comSessCode){
        return AR_MANAGEMENT + uri + "?userSessCode=" + userSessCode + "&comSessCode=" + comSessCode;
    }

    public static String getArManagementUrlLogOut(String uri,String code,String token){
        return AR_MANAGEMENT + uri + "?code=" + code + "&token=" + token;
    }
}
