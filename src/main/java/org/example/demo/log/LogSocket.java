package org.example.demo.log;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.InputStream;

@Slf4j
@ServerEndpoint("/log")
public class LogSocket {

    private Process process;

    private InputStream inputStream;

    @OnOpen
    public void onOpen(Session session) {
        try {
            process = Runtime.getRuntime().exec("tail -100f /home/cloud/out.log");
            inputStream = process.getInputStream();

            TailLogThread thread = new TailLogThread(inputStream, session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * WebSocket请求关闭
     */
    @OnClose
    public void onClose() {
        try {
            if (inputStream != null)
                inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (process != null)
            process.destroy();
    }

    @OnError
    public void onError(Throwable thr) {
        thr.printStackTrace();
    }
}
