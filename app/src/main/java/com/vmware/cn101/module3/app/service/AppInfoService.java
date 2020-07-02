package com.vmware.cn101.module3.app.service;

import com.vmware.cn101.module3.app.model.AppInfo;

public interface AppInfoService extends Service {

    public AppInfo getAppInfo() throws Exception;
}
