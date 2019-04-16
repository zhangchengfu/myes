package com.laozhang.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws Exception {
        Settings settings = Settings.builder()
                .put("cluster.name","laozhang")
                .build();
        TransportClient client;
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByAddress(new String("192.168.1.10").getBytes()), 9300));
        return client;
    }
}
