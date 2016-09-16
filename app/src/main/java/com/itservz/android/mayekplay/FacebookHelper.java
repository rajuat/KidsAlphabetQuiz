package com.itservz.android.mayekplay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by raju.athokpam on 15-09-2016.
 */
public class FacebookHelper {


    public static void shares(final Context context, View currentView) {
        CallbackManager callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, getCallback());
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        Profile currentProfile = Profile.getCurrentProfile();
        if (currentAccessToken == null) {
            final List<String> PUBLISH_PERMISSIONS = Arrays.asList("publish_actions");
            LoginManager.getInstance().logInWithPublishPermissions((Activity) context, PUBLISH_PERMISSIONS);
        }
        Log.d("checksLogin token", "" + AccessToken.getCurrentAccessToken());
        Log.d("checksLogin profile", "" + Profile.getCurrentProfile());

        currentView.setDrawingCacheEnabled(true);
        Bitmap image = currentView.getDrawingCache();
        currentView.setDrawingCacheEnabled(false);
        SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();
        SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
        /*facebookShareButton = (ShareButton) findViewById(R.id.share_facebook);
        facebookShareButton.setShareContent(content);*/

        ShareApi.share(content, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {
                Log.d("ShareApi onSuccess", "" + result);
                Toast.makeText(context, "Share success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Log.d("ShareApi.share onCancel", "");
                Toast.makeText(context, "Share cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("ShareApi.share error", error.toString());
                Toast.makeText(context, "Share error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @NonNull
    private static FacebookCallback<LoginResult> getCallback() {
        return new FacebookCallback<LoginResult>() {


            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("FBCallback onSuccess", "" + loginResult);
            }


            @Override
            public void onCancel() {
                Log.d("FBCallback onCancel", "");
            }


            @Override
            public void onError(FacebookException error) {
                Log.d("FBCallback onError", error.toString());
            }
        };
    }
}
