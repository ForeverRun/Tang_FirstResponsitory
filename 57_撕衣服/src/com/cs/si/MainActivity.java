package com.cs.si;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView iv;
	Bitmap bpcop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Bitmap bpsrc = BitmapFactory.decodeResource(getResources(),R.drawable.awaiyi);
		 bpcop = Bitmap.createBitmap(bpsrc.getWidth(), bpsrc.getHeight(), bpsrc.getConfig());
		
		Paint paint = new Paint();
		Canvas cv = new Canvas(bpcop);
		
		cv.drawBitmap(bpsrc, new Matrix(), paint);
		 iv = (ImageView) findViewById(R.id.iv);
		
		iv.setImageBitmap(bpcop);
		
		iv.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
					int x = (int) event.getX();
					int y = (int) event.getY();
					//把用户划过的坐标设为透明色
					//改变指定的像素颜色
					
						for(int i = -5;i < 5;i++){
							for(int j = -5;j < 5;j++){
								if(Math.sqrt(i*i+j*j)<5){
									if(x + i< bpcop.getWidth() && y + j< bpcop.getHeight() && x + i > 0 && y + j > 0){
										bpcop.setPixel(x+i, y+j, Color.TRANSPARENT);
										iv.setImageBitmap(bpcop);	
								}
							}
						}
						
					}
					break;
				}
				return true;
			}
			
		});
	}
}
