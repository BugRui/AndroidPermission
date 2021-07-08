package com.bugrui.permission.callback;

import java.util.List;


public interface ForwardToSettingsCallback {

    /**
     * 关于转发到设置
     */
    void onForwardToSettings(List<String> deniedList);
}
