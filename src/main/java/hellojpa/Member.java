package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="Member")
@SequenceGenerator(
        name="MEMBER_SEQ_GENERATOR",
        sequenceName="MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50
)

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "MEMBER_SEQ_GENERATOR")
    private long id;
    @Column(name = "name", nullable = false)
    private String username;

    public Member() {
    }

    public Member(long id, String name) {
        this.id = id;
        this.username = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }
}
