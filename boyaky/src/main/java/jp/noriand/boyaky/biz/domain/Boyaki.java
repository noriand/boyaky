package jp.noriand.boyaky.biz.domain;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import javax.validation.constraints.Size;


@Entity
@Table(name="BOYAKI")
@NamedQuery(name="Boyaki.findBoyakiList", query="SELECT b FROM Boyaki b ORDER BY b.id")
public class Boyaki implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id @GeneratedValue
    @Column(name="ID")
    Long id;
 
    @Size(min=2, max=15,message="{errors.size.content}")
    @Column(name="CONTENT")
    private String content;
    
    @Column(name="CREATED_DATE")
    private Date createdDate;

    public Boyaki() {
    	this.createdDate = new Date(System.currentTimeMillis());
    }

    public Boyaki(String content) {
    	super();
        this.content = content;
        
    }

    public Long getId() {
    	return id;
    }
    
    public void setContent(String content) {
    	this.content = content;
    }
    
    public String getContent() {
    	return content;
    }
    
    @Override
    public String toString() {
        return content + " ( " + createdDate + ")";
    }
}
