package hello;


import javax.persistence.*;

/**
 * Created by libinsalal on 2/1/16.
 */
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private Integer version;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String publishedDate;

    @Column(nullable = true)
    private String detailUrl;

    @Column(nullable = true)
    private String referenceUrl;

    protected Book(){
        //NOP
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name , String author ,  String description) {
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public String getReferenceUrl() {
        return referenceUrl;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
