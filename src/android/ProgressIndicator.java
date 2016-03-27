package org.apache.cordova.progressindicator;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.ProgressDialog;

import android.util.Log;

public class ProgressIndicator extends CordovaPlugin {

    private ProgressDialog progressIndicator = null;
    private static final String LOG_TAG = "ProgressIndicator";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("show") || action.equals("showSimple")) {
            show();
            callbackContext.success();
            return true;
        } else if (action.equals("showSimpleWithLabel") || action.equals("showText")) {
            String text = args.getString(1);
            show(text);
            callbackContext.success();
            return true;
        } else if (action.equals("showSimpleWithLabelDetail")) {
            String title = args.getString(1);
            String text = args.getString(2);
            show(title, text, true);
            callbackContext.success();
            return true;
        } else if(action.equals("showDeterminateBarWithLabel")) { 
	    String msg = args.getString(1);
	    String title = args.getString(2);
	    showDeterminateBar(title, msg);
	    callbackContext.success();
	} else if (action.equals("hide")) {
            hide();
            callbackContext.success();
            return true;
        } else if(action.equals("setProgress")){
	    int progress = args.getInt(0);
	    setProgress(progress);
	    callbackContext.success();
	} 
	else {
            callbackContext.error("Not supported call. On Android we only support show, showSimple, showSimpleWithLabel and showSimpleWithLabelDetail");
		}

        return false;
    }

    /**
     * Returns a new instance of a ProgressDialog with the correct
     * Theme for the current API version.
     *
     */
    private ProgressDialog instantiateProgressDialog(){
	int apiVersion = android.os.Build.VERSION.SDK_INT;
	int theme = ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT;

	if(apiVersion >= android.os.Build.VERSION_CODES.HONEYCOMB)
	    return new ProgressDialog(cordova.getActivity(), theme);
	else
	    return new ProgressDialog(cordova.getActivity());
    }

    /**
     * This show the Progress Dialog setting a maximum value (100) for
     * future progress updates.
     *
     */
    public void showDeterminateBar(String title, String msg){
	progressIndicator = instantiateProgressDialog();
	progressIndicator.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	progressIndicator.setMax(100);
	progressIndicator.setIndeterminate(false);

	if(title != null) progressIndicator.setTitle(title);
	if(msg != null) progressIndicator.setMessage(msg);

	progressIndicator.show();
    }

    /**
     * This show the ProgressDialog
     *
     */
    public void show() {
        progressIndicator = instantiateProgressDialog();
	progressIndicator.show();
    }

    /**
     * This show the ProgressDialog
     *
     * @param text - Message to display in the Progress Dialog
     */
    public void show(String text) {
        progressIndicator = instantiateProgressDialog();
	progressIndicator.setMessage(text);
	progressIndicator.show();
    }

    /**
     * This show the ProgressDialog
     *
     * @param title - Message to display as title for the Progress Dialog.
     * @param detail - Message to display in the Progress Dialog.
     * @param withTitle - Whether to display the title message.
     */
    public void show(String title, String detail, Boolean withTitle) {
        progressIndicator = instantiateProgressDialog();

	if(withTitle)
		progressIndicator.setTitle(title);

	progressIndicator.setMessage(detail);
	progressIndicator.show();
    }

    /**
     * This hide the ProgressDialog
     */
    public void hide() {
        if (progressIndicator != null) {
            progressIndicator.dismiss();
            progressIndicator = null;
        }
    }

    /**
     * Update the current progress of the Progress Bar.
     *
     * @param progress - Set the current progress
     *
     */
    public void setProgress(int progress){
	if(progressIndicator != null){
	    Log.d(LOG_TAG, "New Progress: " + progress);
	    progressIndicator.setProgress(progress);
	}
    }
}
