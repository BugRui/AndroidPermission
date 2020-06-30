# AndroidPermission  [![version](https://jitpack.io/v/BugRui/AndroidPermission.svg)](https://jitpack.io/#BugRui/AndroidPermission/1.0.1)
android 敏感权限申请框架,基于PermissionsDispatcher4.7.0去除麻烦的Make Project生成相对应代码，使用DialogFragment代替页面申请权限简化使用方式,支持kotlin，java，避免了java和kotlin混合项目中无法兼容问题

Android sensitive access application framework, based on PermissionsDispatcher4.7.0 remove trouble Make Project to generate corresponding code, using DialogFragment instead of page to apply for permission to simplify the use way, support the kotlin, Java, avoids the Java and kotlin mixed incompatible problems in the Project

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
implementation 'com.github.BugRui:AndroidPermission:1.0.1'
```

kotlin
```
private val cameraTask = arrayOf("android.permission.CAMERA")

permissionCheck(cameraTask, object : OnPermissionsTaskListener() {
                override fun onPermissionsTask() {
                    toast("权限申请通过  Permission application approved")
                }

                override fun onDenied() {
                    toast("权限被拒绝  Permission denied")
                }

                override fun onNeverAskAgain() {
                    toast("权限被拒绝,并勾选不再提示  Permission denied and checked no longer prompted")
                }
            })
```
java
```
 PermissionsExtKt.permissionCheck(this,
                new String[]{"android.permission.CAMERA"},
                new OnPermissionsTaskListener() {
                    @Override
                    public void onPermissionsTask() {
                        toast("权限申请通过  Permission application approved");
                    }

                    @Override
                    public void onDenied() {
                        toast("权限被拒绝  Permission denied");
                    }

                    @Override
                    public void onNeverAskAgain() {
                        toast("权限被拒绝,并勾选不再提示  Permission denied and checked no longer prompted");
                    }
                });
```
