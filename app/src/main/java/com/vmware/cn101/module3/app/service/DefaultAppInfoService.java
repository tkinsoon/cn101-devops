package com.vmware.cn101.module3.app.service;

import com.vmware.cn101.module3.app.model.AppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.net.InetAddress;

@Component
public class DefaultAppInfoService implements AppInfoService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultAppInfoService.class);
    private Environment environment;

    public DefaultAppInfoService(Environment environment) {
        this.environment = environment;
    }

    public AppInfo getAppInfo() throws Exception {
        logger.info("query for app environment info");
        AppInfo appInfo = new AppInfo();

        String port = environment.getProperty("server.port");
        if (port != null) {
            appInfo.setPort(Integer.parseInt(port));
        }
        // Local address
        appInfo.setLocalHostAddress(InetAddress.getLocalHost().getHostAddress());
        appInfo.setLocalHostName(InetAddress.getLocalHost().getHostName());
        // Remote address
        appInfo.setRemoteHostAddress(InetAddress.getLoopbackAddress().getHostAddress());
        appInfo.setRemoteHostName(InetAddress.getLoopbackAddress().getHostName());

        return appInfo;
    }
}
