Start up on boot plugin
====================

##Instalation

```bash
#from master
cordova plugin add https://github.com/tsubik/cordova-plugin-start-on-boot.git
```

##Configuration

In plugins/com.tsubik.cordova.plugin.start-on-boot/src/android/StartAppAtBootReceiver.java replace YOURPACKAGENAME.EnterYourMainActivityName with your package and main activity name from AndroidManifest.xml and run

```bash
cordova platform remove android
cordova platform add android
```

Or mannually update StartAppAtBootReceiver.java in /platforms/android/src/com/tsubik/cordova/plugin/start-on-boot

## Removing the Plugin from your project

```
cordova plugin rm com.tsubik.cordova.plugin.start-on-boot
```