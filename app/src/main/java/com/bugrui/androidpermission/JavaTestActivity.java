package com.bugrui.androidpermission;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bugrui.permission.AndroidPermission;
import com.bugrui.permission.callback.PermissionResultCallback;

import java.util.List;

/**
 * @Author: BugRui
 * @Description: java类作用描述
 * @CreateDate: 2021/7/6 4:55 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/7/6 4:55 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class JavaTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidPermission.apply(this, null, new PermissionResultCallback() {
            @Override
            public void onResult(Boolean allGranted, List<String> grantedList, List<String> deniedList) {
                if (allGranted) {
                    Toast.makeText(JavaTestActivity.this, "所有权限申请通过", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(JavaTestActivity.this, "存在权限申请被拒绝 通过的权限:" + grantedList + " 不通过的权限:" + deniedList, Toast.LENGTH_SHORT).show();
                }
            }
        },Manifest.permission.CAMERA);
    }
}
