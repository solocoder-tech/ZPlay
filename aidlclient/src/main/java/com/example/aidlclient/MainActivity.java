package com.example.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.aidlserver.Book;
import com.example.aidlserver.IMyAidlInterface;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("onServiceConnected", "onServiceConnected");
            //获取AIDL对象
            IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                String name1 = iMyAidlInterface.getName();
                Log.e("result",name1);
                iMyAidlInterface.addBook(new Book("语文","zhangsan"));
                iMyAidlInterface.addBook(new Book("数学","zhangsan"));
                List<Book> books = iMyAidlInterface.getBooks();
                if (books != null){
                    for (Book book : books) {
                        Log.e("client",book.toString());
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setClassName("com.example.aidlserver","com.example.aidlserver.MyService");
        bindService(intent, conn,BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
