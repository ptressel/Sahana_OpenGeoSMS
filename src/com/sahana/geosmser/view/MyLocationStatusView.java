/*******************************************************************************
 * Copyright 2011 Cai Fang, Ye
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.sahana.geosmser.view;

import java.util.Observable;
import java.util.Observer;

import com.sahana.geosmser.WhereToMeet;
import com.sahana.geosmser.gps.MyLocation;
import com.sahana.geosmser.gps.MyLocation.ProvideType;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyLocationStatusView extends LinearLayout{
    
    private TextView mLocationStatusView;
    private MyLocation mMyLocationGPS;
    private MyLocation mMyLocationAGPS;
    private Context baseContext;
    
    public MyLocationStatusView(Context context) {
        super(context);
        baseContext = context;
        init(context);
    }
    public MyLocationStatusView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mMyLocationGPS.enable(ProvideType.E_GPS);
        mMyLocationAGPS.enable(ProvideType.E_AGPS);
        
    }
    
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mMyLocationGPS.disable();
    }
    
    public void init(Context context) {
        this.setOrientation(VERTICAL);
        mLocationStatusView = new TextView(context);
        mLocationStatusView.setPadding(10, 0, 0, 0);
        //TODO Put String on file
        mLocationStatusView.setText("Get Current Location");
        addView(mLocationStatusView);
        
        mMyLocationGPS = new MyLocation(context, GPSLocationObserver);
        mMyLocationAGPS = new MyLocation(context, AGPSLocationObserver);
        
        
    }
    
    public Handler mHanPositionLocating = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
       
    private Observer GPSLocationObserver = new Observer() {
        @Override
        public void update(Observable observable, Object data) {
        }
    };
    
    private Observer AGPSLocationObserver = new Observer() {
        @Override
        public void update(Observable observable, Object data) {
        }
    };
    
    
    
}
