package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalNotification();

        foldNotification();
    }

    private void foldNotification() {
        String channelID = "channel_1";
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelID);
        builder.setContentTitle("折叠式Notification");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        //实现跳转
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setFullScreenIntent(pendingIntent,true);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.view_fold);
//        builder.setCustomBigContentView(remoteViews);

        Notification notification = builder.build();
//        notification.contentView = remoteViews;
        notification.bigContentView = remoteViews;

        //android8.0新增 通知渠道
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelID, "123", NotificationManager.IMPORTANCE_LOW);
            nm.createNotificationChannel(channel);
        }

        nm.notify(2, notification);
    }

    private void normalNotification() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String channelId = "channel_1";
        /**
         * 老版本中使用Notification,新版本中使用Notification.Builder.
         * 为了兼容现在使用NotificationCompat.Builder
         */
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentTitle("普通Notification");
        builder.setContentText("主人，来消息了！");
        builder.setAutoCancel(true);
        //实现跳转
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        //android8.0新增 通知渠道
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "123", NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(channel);
        }
        manager.notify(1, builder.build());
    }
}
