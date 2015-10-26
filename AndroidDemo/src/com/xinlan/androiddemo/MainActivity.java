package com.xinlan.androiddemo;

import com.xinlan.androiddemo.ui.widget.CustomDialog;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initEvent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	public void initEvent(){
		//自定义弹出窗
		Button dialogbtn = (Button) findViewById(R.id.custom_dialog_btn);
		dialogbtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		Log.i("Other","CustomDialog");
		if(id==R.id.custom_dialog_btn){
			showCustomDialog();
		}
		
		
	}
	
	
	
	//自定义弹出窗
	public void showCustomDialog(){
		
		CustomDialog.Builder builder;
		CustomDialog customDialog;
		builder = new CustomDialog.Builder(MainActivity.this);
		builder.setMessage("确定要注销吗？");
		builder.setPositiveButton("取消",
				new android.content.DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
						//删除缓存
						
						//注销到登陆页面
//						intent.setClass(getActivity(), LoginExActivity.class);
//						startActivity(intent);
//						finish();
						return;
					}
				});
		builder.setNegativeButton("确定",
				new android.content.DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
						return;
					}
				});
		customDialog = builder.create();
		customDialog.setCancelable(false);
		customDialog.show();
		
		
	}
}
