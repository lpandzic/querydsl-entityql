package pl.exsio.querydsl.entityql.config.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "JCOMPOSITE_PK")
public class JCompositePk implements Serializable {

    @Id
    @Column(name = "ID_1")
    private Long id1;

    @Id
    @Column(name = "ID_2")
    private String id2;

    @Column(name = "DESC")
    private String desc;

    public JCompositePk() {
    }

    public JCompositePk(Long id1, String id2, String desc) {
        this.id1 = id1;
        this.id2 = id2;
        this.desc = desc;
    }

    Long getId1() {
        return id1;
    }

    String getId2() {
        return id2;
    }

    String getDesc() {
        return desc;
    }
}
