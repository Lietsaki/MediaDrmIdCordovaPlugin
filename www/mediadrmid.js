// Empty constructor
function MediaDrmId() {}

// The function that passes work along to native shells
MediaDrmId.prototype.get = function() {
  return new Promise((resolve, reject) => {
    cordova.exec((id) => {
      resolve(id)
    }, (e) => {
      console.log('Error getting id!')
      console.log(JSON.stringify(e))
      reject(JSON.stringify(e))
    }, 'MediaDrmId', 'get', []);
  });
}

// Installation constructor that binds MediaDrmId to window
MediaDrmId.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.MediaDrmId = new MediaDrmId();
  return window.plugins.MediaDrmId;
};
cordova.addConstructor(MediaDrmId.install);