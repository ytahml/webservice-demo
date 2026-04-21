package top.imulan.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.imulan.webservice.config.WebserviceFactory;
import top.imulan.webservice.weather.WeatherWebServiceStub;

import java.rmi.RemoteException;

/**
 *
 * @author 花木凋零成兰
 * @since 2026/4/16 22:20
 */
@Service
public class WeatherService {

    // stub 对象存在安全问题
    @Autowired
    private WeatherWebServiceStub weatherWebServiceStub;

    // 改用每次调用时，创建获取一个 stub 对象实例
    @Autowired
    private WebserviceFactory webserviceFactory;

    public String[] getWeatherByCityName(String city) throws RemoteException {
        // 1、获取客户端对象实例
        WeatherWebServiceStub weatherStub = webserviceFactory.createWeatherStub();
        // 2. 创建请求对象
        WeatherWebServiceStub.GetWeatherbyCityName getWeather = new WeatherWebServiceStub.GetWeatherbyCityName();
        getWeather.setTheCityName("New York");
        // 3. 调用服务并获取响应
        WeatherWebServiceStub.GetWeatherbyCityNameResponse response = weatherStub.getWeatherbyCityName(getWeather);
        // 返回结果，并转化为 Java 类型
        return response.getGetWeatherbyCityNameResult().getString();
    }
}
