package models;


public class ForumTypeInfo{
public ForumType forumType;
public int threads;
public int posts;
public Post lastPost;

public ForumTypeInfo(ForumType a,int b,int c,Post l) {
	this.forumType=a;
	this.threads=b;
	this.posts=c;
	this.lastPost=l;
}

}

