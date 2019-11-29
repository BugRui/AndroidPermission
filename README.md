# AndroidPermission
android 敏感权限申请

### 集成
#### Step 1. Add the JitPack repository to your build file
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

```
####  Step 2. Add the dependency
```
implementation 'com.github.BugRui:AndroidPermission:1.0.0'
```

kotlin使用
```
fab.setOnClickListener {
            permissionCheck(cameraTask, object : OnPermissionsTaskListener() {
                override fun onPermissionsTask() {
                    toast("权限申请通过")
                }

                override fun onDenied() {
                    toast("权限被拒绝")
                }

                override fun onNeverAskAgain() {
                    toast("权限被拒绝,并勾选不再提示")
                }
            })
        }
```
java使用
```
 PermissionsExtKt.permissionCheck(this,
                new String[]{"android.permission.CAMERA"},
                new OnPermissionsTaskListener() {
                    @Override
                    public void onPermissionsTask() {
                        toast("权限申请通过");
                    }

                    @Override
                    public void onDenied() {
                        toast("权限被拒绝");
                    }

                    @Override
                    public void onNeverAskAgain() {
                        toast("权限被拒绝,并勾选不再提示");
                    }
                });
```
