package com.membattle;

import android.util.Log;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Created by Севастьян on 15.10.2017.
 */
class EchoWebSocketListener extends WebSocketListener {
    private static final int NORMAL_CLOSURE_STATUS = 1000;

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        Log.i("code", "open");
        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        Log.i("code", text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Log.i("code","bytes: " + bytes+"");
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);

    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {

    }
}