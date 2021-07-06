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
applyPermission(Manifest.permission.CAMERA) { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    toast("所有权限申请通过")
                } else {
                    toast("存在权限申请被拒绝 通过的权限:$grantedList 不通过的权限:$deniedList")
                }
            }
```
java
```
AndroidPermission.apply(this,new OnPermissionRequestCallback(){
            @Override
            public void onResult(boolean allGranted, @NotNull List<String> grantedList, @NotNull List<String> deniedList) {
                if (allGranted) {
                    Toast.makeText(JavaTestActivity.this, "所有权限申请通过", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(JavaTestActivity.this, "存在权限申请被拒绝 通过的权限:" + grantedList + " 不通过的权限:" + deniedList, Toast.LENGTH_SHORT).show();
                }
            }
        },Manifest.permission.CAMERA);
```
