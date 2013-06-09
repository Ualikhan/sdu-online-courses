package models;


public class ThreadInfo{
public Post thread;
public int replies;
public Post lastPost;

public ThreadInfo(Post a,int b,Post l) {
	this.thread=a;
	this.replies=b;
	this.lastPost=l;
}

}

