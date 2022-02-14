package cn.ar.util.baidu;


import cn.ar.dto.ImageDto;
import cn.ar.util.HttpUtil;

/**
 * 相似图检索—更新
 * @author Baidu
 */
public class SimilarUpdate {

    public static String similarUpdate(ImageDto imageDto) {
        String brief = imageDto.getBrief();
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/realtime_search/similar/update";
        try {

            String param = "brief=" + imageDto.getBrief() + "&cont_sign=" + imageDto.getContSign() + "&tags=" + imageDto.getTags();
            String accessToken = BaiduAk.getAuth();

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}