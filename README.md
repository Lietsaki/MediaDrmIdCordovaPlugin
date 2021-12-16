# MediaDrm Id Cordova Plugin

This plugin allows you to obtain the [PROPERTY_DEVICE_UNIQUE_ID](https://developer.android.com/reference/android/media/MediaDrm#PROPERTY_DEVICE_UNIQUE_ID) of the MediaDrm API in Android devices, which is a signed byte array returned as a string. This can be used to uniquely identify devices in Android +10 (and past versions too), where access to other non-resettable identifiers like the IMEI has been restricted.

The MediaDrm ID persists even after a factory reset. 


# Installation

Install the plugin with npm. If you're using Capacitor, make sure to do it in the directory where capacitor is installed, for example, `src-capacitor` in Quasar Framework.

```
npm i cordova-plugin-mediadrmid
```

Then, if you're using Capacitor, sync the plugin after installing it with the following command:

```
npx cap sync
```

# Usage

The plugin adds a `plugins` property to the `window` object if it didn't exist before, and inside it adds a `MediaDrmId` property with a single method: `get()`.

**Get()**: Returns a promise that resolves with a string containing the device's MediaDrm ID.

Call it using `.then` or `await`, for example:
```
// Using it with .then
document.addEventListener('deviceready', onDeviceReady, false);

function  onDeviceReady() {

	window.plugins.MediaDrmId.get().then(id => {
		console.log('YOUR DEVICE UNIQUE ID:')
		console.log(id)
		// "[-80, 62, 61, 117, -81, 88, 112, -43, 19, 17, 62, 111, 38, 93, -36, 121, -22, 3, 83, -89, -3, 105, -103, -43, -43, -39, -108, 49, 19, 117, -67, -118]"
	}).catch(e => {
		console.log(e)
	})
	
}
```

```
// Using it with await in Vue's onMounted hook
onMounted(async () => {
	const  id  =  await window.plugins.MediaDrmId.get()
	console.log('YOUR DEVICE UNIQUE ID:')
	console.log(id)
	// "[-80, 62, 61, 117, -81, 88, 112, -43, 19, 17, 62, 111, 38, 93, -36, 121, -22, 3, 83, -89, -3, 105, -103, -43, -43, -39, -108, 49, 19, 117, -67, -118]"
})
```
