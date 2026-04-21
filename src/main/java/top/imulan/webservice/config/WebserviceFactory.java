package top.imulan.webservice.config;

import top.imulan.webservice.weather.WeatherWebServiceStub;

/**
 *
 * @author 花木凋零成兰
 * @since 2026/4/21 20:58
 */
public interface WebserviceFactory {

    /**
     * 创建天气 Webservice 客户端对象
     * @return stub
     */
    WeatherWebServiceStub createWeatherStub();

}
