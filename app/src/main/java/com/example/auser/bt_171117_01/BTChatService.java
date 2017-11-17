package com.example.auser.bt_171117_01;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.UUID;

/**
 * Created by auser on 2017/11/17.
 */

public class BTChatService {

    private final BluetoothAdapter btAdapter;
    private static final int STATE_NORMAL = 0;
    private static final int STATE_WaitingConnecting = 1;
    private static final int STATE_CONNECTING = 2;
    public static final int STATE_CONNECTED = 3;
    private static final int STATE_STOP = 4;

    private static final UUID UUID_String = UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");
//    private static final UUID UUID_String = UUID_fromString("00001101-0000-1000-8000-00805f9b34fb");    //BT SPP

    private final Handler btHandler;

    private int btState;
    private static final String TAG = "BT_Chat";

    public BTChatService(Context context, Handler handler){

        btAdapter = BluetoothAdapter.getDefaultAdapter();
        btState = STATE_NORMAL;
        btHandler = handler;
    }

    public int getState(){
        return btState;
    }

    public void serverStart(){
        Log.d(TAG, "Enter server mode.");
    }

    public void connect(BluetoothDevice device){
        Log.d(TAG, "connect to : " + device);
    }

    public synchronized void stop(){
        Log.d(TAG, "Stop all threads.");
    }

    public void BTWrite(byte[] out){
        if(btState != STATE_CONNECTED)  return;
//        btConnectedThread.write(out);
    }
}
