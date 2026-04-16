package top.imulan.webservice.config;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.imulan.webservice.weather.WeatherWebServiceStub;

/**
 *
 * @author 花木凋零成兰
 * @since 2026/4/16 22:15
 */
@Configuration
public class WebServiceConfig {
    @Bean
    public WeatherWebServiceStub weatherWebServiceStub() {
        try {
            // 1. 创建客户端对象，调用地址一般是去掉 ?wsdl 之后的地址，也可以在网页 xml 底部找到对应方法调用地址
            WeatherWebServiceStub stub = new WeatherWebServiceStub("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");
            // 2. 配置相关属性
            Options options = stub._getServiceClient().getOptions();
            // 3. 设置超时时间（单位：毫秒）区分连接超时和 Socket 超时，比 setTimeOutInMilliSeconds 更精确
            // 连接超时 30 秒
            options.setProperty(HTTPConstants.CONNECTION_TIMEOUT, 30000);
            // Socket 超时 60 秒
            options.setProperty(HTTPConstants.SO_TIMEOUT, 60000);
            // 4. 复用 HTTP 连接，节省资源开销，提高性能
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true");
            return stub;
        } catch (AxisFault e) {
            throw new RuntimeException("初始化天气 Webservice 客户端失败：" + e.getMessage(), e);
        }
    }
}
