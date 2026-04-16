package top.imulan.webservice.client;

import top.imulan.webservice.weather.WeatherWebServiceStub;

/**
 *
 * @author 花木凋零成兰
 * @since 2026/4/16 22:06
 */
public class WeatherClient {
    public static void main(String[] args) {
        try {
            // 1. 创建客户端对象，调用地址一般是去掉 ?wsdl 之后的地址，也可以在网页 xml 底部找到对应方法调用地址
            WeatherWebServiceStub stub = new WeatherWebServiceStub("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");
            // 2. 创建请求对象
            WeatherWebServiceStub.GetWeatherbyCityName getWeather = new WeatherWebServiceStub.GetWeatherbyCityName();
            getWeather.setTheCityName("New York");
            // 3. 调用服务并获取响应
            WeatherWebServiceStub.GetWeatherbyCityNameResponse response = stub.getWeatherbyCityName(getWeather);
            // 返回结果，并转化为 Java 类型
            String[] result = response.getGetWeatherbyCityNameResult().getString();
            // 4. 输出结果
            for (String str : result) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
