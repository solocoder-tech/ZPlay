package com.example.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    protected Book(Parcel in) {
        name = in.readString();
        author = in.readString();
    }

    /**
     * 负责反序列化
     */
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        /**
         * 从序列化对象中，获取原始的对象
         * @param in
         * @return
         */
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        /**
         * 创建制定长度的原始对象数组
         * @param size
         * @return
         */
        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    /**
     * 描述
     * 返回的是内容的描述信息
     * 只针对一些特殊的需要描述信息的对象,需要返回1,其他情况返回0就可以
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 序列化
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(author);
    }
}
