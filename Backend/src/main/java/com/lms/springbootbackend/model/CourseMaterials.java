package com.lms.springbootbackend.model;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "course_materials")
public class CourseMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long materialId;

    @Column(name = "material_title", nullable = true)
    private String materialTitle;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_location")
    private String fileLocation;

    @Column(name = "create_time")
    private Date createTime;

    // establish many to one relation with course
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    private Course course;

    public CourseMaterials(){
        super();
    }

    public CourseMaterials(long materialId, String materialTitle, String fileType, String fileLocation, Date createTime,
                           Course course) {
        super();
        this.materialId = materialId;
        this.materialTitle = materialTitle;
        this.fileType = fileType;
        this.fileLocation = fileLocation;
        this.createTime = createTime;
        this.course = course;
    }

    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseMaterials [materialId=" + materialId + ", materialTitle=" + materialTitle + ", fileType="
                + fileType + ", fileLocation=" + fileLocation + ", createTime=" + createTime + ", course=" + course
                + "]";
    }


}
