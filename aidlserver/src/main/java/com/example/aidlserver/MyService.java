package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    private List<Book> mBooks = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyService", "============onCreate()==============");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyService", "============onBind()==============");
        return new MyBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService", "============onDestroy()==============");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MyService", "============onUnbind()==============");
        return super.onUnbind(intent);
    }

    class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public String getName() throws RemoteException {
            Log.e("MyService", "============getName()==============");
            return "MyService";
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            if (book != null)
                mBooks.add(book);
        }

        @Override
        public List<Book> getBooks() throws RemoteException {
            return mBooks;
        }
    }
}
