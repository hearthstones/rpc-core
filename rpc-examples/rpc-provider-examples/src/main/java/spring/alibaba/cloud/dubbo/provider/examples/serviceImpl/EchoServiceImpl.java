package spring.alibaba.cloud.dubbo.provider.examples.serviceImpl;

import com.rpc.api.examples.service.EchoService;

public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        return "dubbo echo: " + message;
    }

}
