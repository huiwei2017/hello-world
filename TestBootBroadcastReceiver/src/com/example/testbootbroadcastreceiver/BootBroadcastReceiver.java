package com.example.testbootbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootBroadcastReceiver extends BroadcastReceiver {

	static final String action_boot="android.intent.action.BOOT_COMPLETED";
	static final String media_mounted="android.intent.action.MEDIA_MOUNTED";
	static final String media_unmounted="android.intent.action.MEDIA_UNMOUNTED";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		Log.d("BroadcastReceiver", intent.getAction());
		if ((intent.getAction().equals(action_boot))){ 
            Intent ootStartIntent=new Intent(context,MainActivity.class); 
            ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
            context.startActivity(ootStartIntent); 
        }
		
		//接收广播：安装更新后，自动启动自己。        
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED) || intent.getAction().equals(Intent.ACTION_PACKAGE_REPLACED))  
        {  
            Intent ootStartIntent = new Intent(context, MainActivity.class);  
            ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
            context.startActivity(ootStartIntent);  
        }  
		
	}

}
