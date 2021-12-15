package com.ricardosandez.cordova.plugin;
// The native MediaDrm API and utils UUID
import android.media.MediaDrm;
import java.util.UUID;
import java.util.Arrays;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaDrmId extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {
      UUID wideVineUuid = new UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L);

      try {
        MediaDrm wvDrm = new MediaDrm(wideVineUuid);
        byte[] wideVineId = wvDrm.getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID);

        // Send result to callbackContext
        PluginResult.Status status = PluginResult.Status.OK;
        PluginResult pluginResult = new PluginResult(status, Arrays.toString(wideVineId));
        callbackContext.sendPluginResult(pluginResult);
      } catch (Exception e) {
        // Inspect exception
        System.out.println(e);
      }
      // Close resources with close() or release() depending on platform API
      // Use ARM on Android P platform or higher, where MediaDrm has the close() method

      return true;
  }
}