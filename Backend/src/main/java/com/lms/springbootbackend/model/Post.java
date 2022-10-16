package com.lms.springbootbackend.model;

import java.sql.Date;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @SequenceGenerator(name = "postId_seq", sequenceName = "postId_seq", allocationSize = 1, initialValue = 700000)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "postId_seq")
    private long postId;

    @Column(name = "post_text")
    private String  postText;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "timestamp")
    private Date createdAt;

    @Column(name = "post_file_path")
    private String postFileName;
    @Column(name = "post_file_type")
    private String postFileType;

    // Many to one relationship with instructor
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructorId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private Instructor instructor;

    public Post(){

    }

    public Post(long postId, String postText, String postTitle, Date createdAt, String postFileName,
                String postFileType, Instructor instructor) {
        super();
        this.postId = postId;
        this.postText = postText;
        this.postTitle = postTitle;
        this.createdAt = createdAt;
        this.postFileName = postFileName;
        this.postFileType = postFileType;
        this.instructor = instructor;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPostFileName() {
        return postFileName;
    }

    public void setPostFileName(String postFileName) {
        this.postFileName = postFileName;
    }

    public String getPostFileType() {
        return postFileType;
    }

    public void setPostFileType(String postFileType) {
        this.postFileType = postFileType;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Post [postId=" + postId + ", postText=" + postText + ", postTitle=" + postTitle + ", createdAt="
                + createdAt + ", postFileName=" + postFileName + ", postFileType=" + postFileType + ", instructor="
                + instructor + "]";
    }
}
